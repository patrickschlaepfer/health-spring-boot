package com.schlaepfer.health.systemone.proc;

import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.schlaepfer.health.systemone.proc.direct.DirectRouteBuilder;
import com.schlaepfer.health.systemone.proc.mllp.MllpRouteBuilder;
import com.schlaepfer.health.systemone.proc.ws.WSRouteBuilder;

@Configuration
public class SystemOneProcessConfiguration {

	@Autowired
	private MllpRouteBuilder mllpRouteBuilder;

	@Autowired
	private DirectRouteBuilder directRouteBuilder;

	@Autowired
	private WSRouteBuilder wsRouteBuilder; 
	
	@Bean
	public SpringCamelContext camelContext(final ApplicationContext applicationContext) throws Exception {
		final SpringCamelContext camelContext = new SpringCamelContext(applicationContext);

		camelContext.addRoutes(mllpRouteBuilder);
		camelContext.addRoutes(directRouteBuilder);
		camelContext.addRoutes(wsRouteBuilder);

		return camelContext;
	}

}
