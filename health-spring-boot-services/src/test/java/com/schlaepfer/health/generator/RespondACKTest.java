package com.schlaepfer.health.generator;

import org.junit.Test;

import com.schlaepfer.health.generator.RespondACK;

import ca.uhn.hl7v2.DefaultHapiContext;
import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.HapiContext;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.parser.Parser;

import static org.fest.assertions.api.Assertions.assertThat;

public class RespondACKTest {
    
    final String MSG_IN = "MSH|^~\\&|MYSENDER|MYRECEIVER|MYAPPLICATION||200612211200||QRY^A19|1234|P|2.5\r";
    final String MSG_OUT = "MSH|^~\\&|MYAPPLICATION||MYSENDER|MYRECEIVER|20160512192101.496+0200||ACK^A19^ACK|1|P|2.5\r";

    @Test
    public void testRespondACK() throws HL7Exception, Exception {
        
        RespondACK respondACK = new RespondACK();
        
        HapiContext context = new DefaultHapiContext();
        Parser p = context.getGenericParser();
        Message out = respondACK.handle(p.parse(MSG_IN));
        
        // assertThat(out.toString()).isEqualTo(MSG_OUT);
        
    }

}
