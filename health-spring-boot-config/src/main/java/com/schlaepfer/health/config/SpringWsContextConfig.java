package com.schlaepfer.health.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ws.transport.http.MessageDispatcherServlet;

@Configuration
public class SpringWsContextConfig {
	
	@Value("${springws.url.mapping}")
	private String springWsUrlMapping;
    
	@Value("${springws.servlet.name}")
	private String springServletName;
	
	@Bean
    public ServletRegistrationBean servletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(
        		new MessageDispatcherServlet(), 
        		springWsUrlMapping);
        registration.setName(springServletName);
        return registration;
    }

}
