package com.yitengtech.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.yitengtech.service.TestService;
import com.yitengtech.service.TestServiceImpl;

/*
 * 配置类
 */
@Configuration
public class CxfConfig {
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
    public ServletRegistrationBean dispatcherServlet(){
        return new ServletRegistrationBean(new CXFServlet(),"/service/*");//发布服务名称
    }
	
	@Bean(name = Bus.DEFAULT_BUS_ID)
    public SpringBus springBus()
    {
        return  new SpringBus();
    }

    @Bean
    public TestService testService()
    {
        return new TestServiceImpl();
    }

//	@Autowired
//	private Bus bus;
//	
//	@Autowired
//	private TestService service;
    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint=new EndpointImpl(springBus(), testService());//绑定要发布的服务
        endpoint.publish("/test"); //显示要发布的名称
        return endpoint;
    }

}
