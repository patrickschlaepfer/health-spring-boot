package com.schlaepfer.health.systemone;

import org.apache.camel.spring.SpringRouteBuilder;

public abstract class AbstractSystemOneRouteBuilder extends SpringRouteBuilder {

	private final int nettyPort;

	protected AbstractSystemOneRouteBuilder(final int nettyPort) {
		this.nettyPort = nettyPort;
	}

	protected final int nettyPort() {
		return nettyPort;
	}
}
