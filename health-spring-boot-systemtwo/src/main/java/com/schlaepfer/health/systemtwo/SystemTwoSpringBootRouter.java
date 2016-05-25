package com.schlaepfer.health.systemtwo;

import org.apache.camel.spring.boot.FatJarRouter;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
//@ComponentScan("biz.hcnet.eu.hipsringboot.config")
@Import({ com.schlaepfer.health.translator.odata.HL7ToOData.class,
	com.schlaepfer.health.config.ActiveMQContextConfig.class })
public class SystemTwoSpringBootRouter extends FatJarRouter {

}
