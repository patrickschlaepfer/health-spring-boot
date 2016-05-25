package com.schlaepfer.health.generator;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ca.uhn.hl7v2.model.Message;

@Component
public class RespondACK {

    private static final Logger LOGGER = LoggerFactory.getLogger(RespondACK.class);
    
    @Handler
    public Message handle(Message in) throws Exception {
        LOGGER.info("in: {}", in.toString());
        Message out = in.generateACK();
        LOGGER.info("out: {}", out.toString());
        return out;
    }
}
