package com.yitengtech.service;

import java.util.List;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

import com.yitengtech.bean.Position;
import com.yitengtech.util.SQLUtil;

@WebService(
targetNamespace = "http://service.yitengtech.com", 			// 与接口中的命名空间一致,一般是接口的包名倒
endpointInterface = "com.yitengtech.service.TestService"	// 接口地址
)
@Component
public class TestServiceImpl implements TestService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "hello ";
	}

	@Override
	public Position selectPosition(String mac) {
		// TODO Auto-generated method stub
		List<Position> list = null;
		try {
			list = SQLUtil.selectBymac(mac);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (list != null && list.size() == 1) {
			return list.get(0);
		}
		return null;
	}


}
