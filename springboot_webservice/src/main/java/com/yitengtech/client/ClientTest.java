package com.yitengtech.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.yitengtech.bean.Position;
import com.yitengtech.service.TestService;

public class ClientTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JaxWsProxyFactoryBean bean = new JaxWsProxyFactoryBean();
		bean.setAddress("http://localhost:8080/service/test?wsdl");
		bean.setServiceClass(TestService.class);
		
		TestService service = (TestService) bean.create();
		String info = service.sayHello();
		System.out.println("from service : " + info);
		
		Position position = service.selectPosition("001f7a85e271");
		System.out.println("from service : " + position);
	}

}
