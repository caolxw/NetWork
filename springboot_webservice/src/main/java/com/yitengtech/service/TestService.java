package com.yitengtech.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService
public interface TestService {
	@WebMethod
	public String sayHello();
}
