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
	
	private static final String ROUTE_LABEL_1 = "systemtwo_direct_1";
	private static final String ROUTE_LABEL_2 = "systemtwo_direct_2";

	@Override
	public void configure() throws Exception {
		
		final String routeId1 = id(SystemTwoDirectRouteBuilder.class, ROUTE_LABEL_1);
		final String routeId2 = id(SystemTwoDirectRouteBuilder.class, ROUTE_LABEL_2);
		
		LOGGER.info("In System Two Direct Route Builder");
		
		// @formatter:off 
		from("rabbitmq://localhost:5672/adtxx.out?queue=adtxx.systemtwo&autoDelete=true&connectionFactory=#rabbitMQConnectionFactory")
			.routeId(routeId1)
			.log("Got OData: ${body}")
			.setExchangePattern(ExchangePattern.InOnly)
			.end();
		// @formatter:on
		
	}
	

}
