package com.schlaepfer.health.systemtwo.proc.direct;

import static com.schlaepfer.health.commons.Routes.id;

import org.apache.camel.ExchangePattern;
import org.apache.camel.spring.SpringRouteBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class SystemTwoDirectRouteBuilder extends SpringRouteBuilder {
	
private static final Logger LOGGER = LoggerFactory.getLogger(SystemTwoDirectRouteBuilder.class);
	
	private static final String ROUTE_LABEL = "update_direct";

	@Override
	public void configure() throws Exception {
		
		final String routeId = id(SystemTwoDirectRouteBuilder.class, ROUTE_LABEL);
		
		LOGGER.info("In SAP Direct Route Builder");
		
		// @formatter:off 
		from("activemqhip:queue:in")
			.routeId(routeId)
			.log("Got OData: ${body}")
			.setExchangePattern(ExchangePattern.InOnly)
			.end();
		// @formatter:on
		
	}
	

}
