# JAVA网络编程
## TCP
### 客户端client
1.建立连接，创建Socket对象。
```
//serverIP是服务器地址，port是端口号。
Socket socket = new Socket(serverIP, port);
```
2.发送数据  
利用IO流发送数据
```
//要发送的数据必须是byte数组
OutputStream os = socket.getOutputStream();
os.write(data);
//如果是String类型，
//os.write(data.getBytes());
```

3.接收服务器的返回数据
```
//接收到的数据也是byte数组
InputStream is = socket.getInputStream();
byte[] b = new byte[1024];
int len = is.read(b);

System.out.println(new String(b, 0, len));
```

### 服务器端server
1.监听窗口
```
ServerSocket ss = new ServerSocket(port);
```

2.获得连接
```
Socket socket = ss.accept();
```

3.接收客户端数据
```
InputStream is = socket.getInputStream();
byte[] b = new byte[1024];
int len = is.read();

System.out.println(new String(b, 0, len));
```

4.发送反馈数据
```
OutputStream os = socket.getOutputStream();
os.write(data);
```
+ 记得在最后要关闭流对象和socket


<hr>
以上只能处理一次数据发送，接下来介绍多次数据发送时，服务器端的处理：  
```
//采用线程池来处理并发情况
//创建线程池
ExecutorService threadPool = Executors.newFixedThreadPool(100);

while(true){
    Socket socket = ss.accept();
    
    //创建线程
    Runnable runnable = ()->{
        try{                    //这里只能采用try...catch来处理异常
            InputStream is = socket.getInputStream();
            byte[] b = new byte[1024];
            int len;
            StringBuffer sb = new StringBuffer();
            
            while((len = is.read(b)) != -1){
                sb.append(new String(b, 0, len);
            }
            
            is.close();
            socket.close();
        }catch(Exception e){}
    }
    
    threadpool.submit(runnable);
}
```

## UDP
### 客户端client
1.建立连接
```
DatagramSocket ds = new DatagramSocket();
```
+ 注意UDP不需要在建立连接的时候指定IP地址和端口号。

2.初始化发送数据包并发送
```
InetAddress address = InetAddress.getByName(serverIP);
//数据data应为byte数组
DatagramPacket sendDP = new DatagramPacket(data, data.length, address, port);

//发送数据包
ds.send(sendDP);
```
+ 服务器的IP地址和端口号被封装在数据包当中。

3.接收服务器返回数据
```
//初始化接收数据包
byte[] b = new byte[1024];
DatagramPacket receiveDP = new DatagramPacket(b, b.length);

ds.receive(receiveDP);
```
4.对数据进行处理
```
//获取缓冲数组
byte[] data = receiveDP.getData();
//获取有效数据长度
int len = receiveDP.getLength();

System.out.println(new String(data, 0, len));
```
### 服务器端server
1.建立连接并监听窗口
```
DatagramSocket ds = new DatagramSocket(port);
```
+ 注意在服务器一端是需要指定窗口，才可以进行监听。

2.接收数据
```
byte[] data = new byte[1024];
DatagramPacket receiveDP = new DatagramPacket(data, data.length);

ds.receive(receiveDP);
```
3.处理数据
```
//拿到发送端的IP地址
InetAddress clientIP = receiveDP.getAddress();

//拿到发送端的端口号
int clientport = receiveDP.getPort();

byte[] info = receiveDP.getData();
int len = receiveDP.getLength();
```
4.发送反馈数据，与客户端发送操作一致，不再缀述。
<hr>

+ 多线程的并发情况解决思路和TDP一致。
+ UDP是无连接服务，所以在创建socket对象的时候不用指定IP地址和端口号。
+ 以上只是基础操作，实际项目中不会那么简单。