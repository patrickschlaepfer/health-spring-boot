package com.schlaepfer.health.config;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.activemq.pool.PooledConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.JmsTransactionManager;

@Configuration
public class ActiveMQContextConfig {
	
	@Value("${activemq.brokerurl}")
	private String brokerURL;
    
	@Value("${activemq.maxConnections}")
	private int maxConnections;
	
	@Bean(name = "connectionFactory")
	public ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory();
		factory.setBrokerURL(brokerURL);
		factory.setTrustAllPackages(true);
		return factory;
	}

	@Bean(name = "jmsTransactionManager")
	public JmsTransactionManager jmsTransactionManager() {
		JmsTransactionManager transactionManager = new JmsTransactionManager();
		transactionManager.setConnectionFactory(activeMQConnectionFactory());
		return transactionManager;
	}

	@Bean(name = "pooledConnectionFactory")
	public PooledConnectionFactory pooledConnectionFactory() {
		PooledConnectionFactory pool = new PooledConnectionFactory();
		pool.setMaxConnections(maxConnections);
		pool.setConnectionFactory(activeMQConnectionFactory());
		return pool;
	}

	@Bean(name = "activemqhip")
	public ActiveMQComponent activeMQComponent() {
		ActiveMQComponent component = new ActiveMQComponent();
		component.setConnectionFactory(pooledConnectionFactory());
		component.setTransactionManager(jmsTransactionManager());
		return component;
	}
}
