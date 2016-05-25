package com.schlaepfer.health.sap;

import org.apache.camel.TypeConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@EnableAutoConfiguration
@SpringApplicationConfiguration(classes = SapSpringBootRouterTest.class)
@IntegrationTest("camel.springboot.typeConversion=false")
public class SapSpringBootRouterTest {

	@Autowired
	ApplicationContext applicationContext;

	@Test(expected = NoSuchBeanDefinitionException.class)
	public void shouldNotProvideConverter() {
		applicationContext.getBean(TypeConverter.class);
	}

}
