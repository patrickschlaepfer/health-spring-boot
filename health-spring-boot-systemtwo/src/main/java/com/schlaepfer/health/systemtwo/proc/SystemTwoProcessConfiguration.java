package com.schlaepfer.health.systemtwo.proc;

import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.schlaepfer.health.systemtwo.proc.direct.SystemTwoDirectRouteBuilder;

@Configuration
public class SystemTwoProcessConfiguration {
	
	@Autowired
	SystemTwoDirectRouteBuilder updateDirectRouteBuilder;

	@Bean
	public SpringCamelContext camelContext(final ApplicationContext applicationContext) throws Exception {
		final SpringCamelContext camelContext = new SpringCamelContext(applicationContext);
		
		camelContext.addRoutes(updateDirectRouteBuilder);

		return camelContext;
	}
	
}
