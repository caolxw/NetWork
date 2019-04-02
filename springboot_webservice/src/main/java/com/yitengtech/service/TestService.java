package com.yitengtech.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

import com.yitengtech.bean.Position;

@WebService
public interface TestService {
	@WebMethod
	public String sayHello();
	
	@WebMethod
	public Position selectPosition(@WebParam(name = "mac") String mac);
}
