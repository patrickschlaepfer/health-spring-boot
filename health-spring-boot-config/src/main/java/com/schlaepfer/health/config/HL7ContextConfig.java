package com.schlaepfer.health.config;

import org.apache.camel.component.hl7.HL7MLLPNettyDecoderFactory;
import org.apache.camel.component.hl7.HL7MLLPNettyEncoderFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HL7ContextConfig {
	
	@Value("${hl7.charset.in:UTF-8}")
	private String HL7CharsetIn;
	
	@Value("${hl7.charset.out:UTF-8}")
	private String HL7CharsetOut;
    
    @Bean(name = "hl7decoder")
    public HL7MLLPNettyDecoderFactory hl7mllpNettyDecoderFactory() {
        HL7MLLPNettyDecoderFactory factory = new HL7MLLPNettyDecoderFactory();
        factory.setCharset(HL7CharsetIn);
        factory.setProduceString(false);
        factory.setConvertLFtoCR(true);
        return factory;
    }

    @Bean(name = "hl7encoder")
    public HL7MLLPNettyEncoderFactory hl7mllpNettyEncoderFactory() {
        HL7MLLPNettyEncoderFactory factory = new HL7MLLPNettyEncoderFactory();
        factory.setCharset(HL7CharsetOut);
        factory.setProduceString(false);
        factory.setConvertLFtoCR(true);
        return factory;
    }

}