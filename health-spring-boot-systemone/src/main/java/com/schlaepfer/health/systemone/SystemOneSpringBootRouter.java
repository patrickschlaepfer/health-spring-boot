package com.schlaepfer.health.systemone;

import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
// @ComponentScan("biz.hcnet.eu.hipsringboot.config")
@Import({ com.schlaepfer.health.config.HL7ContextConfig.class,
		com.schlaepfer.health.translator.odata.HL7ToOData.class,
		com.schlaepfer.health.translator.odata.ODataToHL7.class,
		com.schlaepfer.health.generator.RespondACK.class,
		com.schlaepfer.health.config.SpringWsContextConfig.class,
		com.schlaepfer.health.config.ActiveMQContextConfig.class,
		com.schlaepfer.health.config.RabbitMQContextConfig.class})
public class SystemOneSpringBootRouter extends FatJarRouter {

}
