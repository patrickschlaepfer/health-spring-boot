package com.schlaepfer.health.sap.proc;

import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.schlaepfer.health.sap.proc.direct.DirectRouteBuilder;

@Configuration
public class SapProcessConfiguration {
	
	@Autowired
	DirectRouteBuilder directRouteBuilder;
	
	@Bean
	public SpringCamelContext camelContext(final ApplicationContext applicationContext) throws Exception {
		final SpringCamelContext camelContext = new SpringCamelContext(applicationContext);
		
		camelContext.addRoutes(directRouteBuilder);

		return camelContext;
	}

}
