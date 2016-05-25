package com.schlaepfer.health.systemone.translator;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import ca.uhn.hl7v2.model.Message;

@Component
public class HL7Translator {

	private static final Logger LOGGER = LoggerFactory.getLogger(HL7Translator.class);

	@Handler
	public Message handle(Message message) {
		LOGGER.info("In handle");
		Message response = (Message) message;
		
		return response;
	}
}
