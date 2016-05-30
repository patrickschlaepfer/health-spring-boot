package com.schlaepfer.health.sap;

import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@ComponentScan("biz.hcnet.eu.hipsringboot.config")
@Import({ com.schlaepfer.health.translator.odata.HL7ToOData.class,
	com.schlaepfer.health.config.ActiveMQContextConfig.class,
	com.schlaepfer.health.config.RabbitMQContextConfig.class})
public class SapSpringBootRouter extends FatJarRouter {

}
