package com.yitengtech.service;

import javax.jws.WebService;

import org.springframework.stereotype.Component;

@WebService(
targetNamespace = "http://service.yitengtech.com", // 与接口中的命名空间一致,一般是接口的包名倒
endpointInterface = "com.yitengtech.service.TestService"// 接口地址
)

@Component
public class TestServiceImpl implements TestService {

	@Override
	public String sayHello() {
		// TODO Auto-generated method stub
		return "hello ";
	}

}
