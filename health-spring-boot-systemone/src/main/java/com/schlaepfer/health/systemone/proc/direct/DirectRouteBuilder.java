package com.schlaepfer.health.systemone.proc.direct;

import static com.schlaepfer.health.commons.Routes.id;

import org.apache.camel.ExchangePattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.schlaepfer.health.generator.RespondACK;
import com.schlaepfer.health.systemone.AbstractSystemOneRouteBuilder;
import com.schlaepfer.health.systemone.translator.HL7Translator;
import com.schlaepfer.health.translator.odata.HL7ToOData;
import com.schlaepfer.health.translator.odata.ODataToHL7;

@Component
public class DirectRouteBuilder extends AbstractSystemOneRouteBuilder {

	private static final Logger LOG = LoggerFactory.getLogger(DirectRouteBuilder.class);

	private static final String ROUTE_LABEL = "systemone_direct";

	@Autowired
	public DirectRouteBuilder(@Value("${netty.port}") final int nettyPort) {
		super(nettyPort);
		LOG.info("Netty port would be: {}", nettyPort);
	}

	@Override
	public void configure() throws Exception {
		LOG.info("Configure {} route", ROUTE_LABEL);

		final String routeId = id(DirectRouteBuilder.class, ROUTE_LABEL);

		// @formatter:off 
		from("direct:hl7Main")
      		.routeId(routeId)
      		.log("HL7 Request: ${body}")
      		.unmarshal()
      		.hl7()
      		.bean(lookup(HL7Translator.class))
      		.bean(lookup(HL7ToOData.class))
			.log("after procssing: ${body}")
			.setExchangePattern(ExchangePattern.InOut)
			// .to("rabbitmq://localhost:5672/amq.fanout?connectionFactory=#rabbitMQConnectionFactory")
			// .to("rabbitmq://localhost:5672/in?connectionFactory=#rabbitMQConnectionFactory")
			.to("rabbitmq://localhost:5672/adtxx.in?automaticRecoveryEnabled=true&autoDelete=false&durable=true&connectionFactory=#rabbitMQConnectionFactory")
			// .to("activemqhip:queue:in?replyTo=out&receiveTimeout=250")
			.bean(lookup(ODataToHL7.class))
      		.bean(lookup(RespondACK.class))
      		.end();
		// @formatter:on

	}

}
