package com.schlaepfer.health.translator.odata;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.schlaepfer.health.entity.ODataManual;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;

@Component
public class ODataToHL7 {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ODataToHL7.class);

	private final String msg = "MSH|^~\\&|MYSENDER|MYRECEIVER|MYAPPLICATION||200612211200||QRY^A19|1234|P|2.5\r";

	@Handler
	public Message handle(ODataManual odata) throws Exception {
		
		LOGGER.info("Translationg form OData to HL7");
		LOGGER.info("OData: {}", odata);

		
		HapiContext context = new DefaultHapiContext();
		Parser p = context.getGenericParser();
		Message hapimsg = p.parse(msg);
		
		return hapimsg;

	}

}
