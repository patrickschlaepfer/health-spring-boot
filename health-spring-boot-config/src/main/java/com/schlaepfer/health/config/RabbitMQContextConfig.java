package com.schlaepfer.health.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.rabbitmq.client.ConnectionFactory;

@Configuration
public class RabbitMQContextConfig {
	
	@Value("${rabbitmq.port:5672}")
	private int port;
	
	@Value("${rabbitmq.host:localhost}")
	private String hostName;
	
	
	@Bean(name="rabbitMQConnectionFactory")
	public ConnectionFactory connectionFactory() {
		ConnectionFactory connectionFactory = new ConnectionFactory();
		connectionFactory.setPort(port);
		connectionFactory.setHost(hostName);
		
		return connectionFactory;
	}

}
