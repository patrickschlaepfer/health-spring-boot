package com.schlaepfer.health.commons.routebuilder;

import org.apache.camel.spring.SpringRouteBuilder;

public abstract class AbstractNetty4RouteBuilder extends SpringRouteBuilder {

	private final int nettyPort;
	
	private final String nettyHostname;

	protected AbstractNetty4RouteBuilder(final int nettyPort, final String nettyHostname) {
		this.nettyPort = nettyPort;
		this.nettyHostname = nettyHostname;
	}

	protected final int nettyPort() {
		return nettyPort;
	}
	
	protected final String nettyHostname() {
		return nettyHostname;
	}
}
