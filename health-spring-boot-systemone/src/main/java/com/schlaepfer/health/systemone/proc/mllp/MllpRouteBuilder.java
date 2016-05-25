package com.schlaepfer.health.systemone.proc.mllp;

import static com.schlaepfer.health.commons.Routes.id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.schlaepfer.health.commons.routebuilder.AbstractNetty4RouteBuilder;

@Component
public class MllpRouteBuilder extends AbstractNetty4RouteBuilder {

	private static final Logger LOG = LoggerFactory.getLogger(MllpRouteBuilder.class);

	private static final String ROUTE_LABEL = "systemone_mllp";
	
	@Autowired
	public MllpRouteBuilder(@Value("${netty.port}") final int nettyPort, @Value("${netty.hostname}") final String nettyHostname) {
		super(nettyPort, nettyHostname);
		LOG.info("Netty Port: {}", nettyPort);
		LOG.info("Netty Host: {}", nettyHostname);
	}

	@Override
	public void configure() throws Exception {
		LOG.info("Configure {} route", ROUTE_LABEL);
	
		final String routeId = id(MllpRouteBuilder.class, ROUTE_LABEL);

		// @formatter:off
		from("netty4:tcp://"+nettyHostname()+":"+nettyPort()+"?sync=true&encoder=#hl7encoder&decoder=#hl7decoder")
         	.routeId(routeId)
         	.to("direct:hl7Main");
		// @formatter:on
	}

}
