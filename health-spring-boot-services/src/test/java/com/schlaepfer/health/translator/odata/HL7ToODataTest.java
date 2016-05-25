package com.schlaepfer.health.translator.odata;

import org.apache.camel.component.hl7.HL7Converter;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.schlaepfer.health.entity.ODataManual;
import com.schlaepfer.health.translator.odata.HL7ToOData;

import ca.uhn.hl7v2.model.Message;

import static org.fest.assertions.api.Assertions.*;

public class HL7ToODataTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(HL7ToODataTest.class);

    private final static String HL7_PID = "MSH|^~\\&|SYSTEMONE|0710|ESB|0710|20160518073340||ADT^A31|00100255|P|2.5|||NE|NE|||||\r" +
            "EVN|A31|20160518|||||\r"+ 
            "PID|1||992244111^^^SAP~32441^^^SYSTEMONE||Schlaepfer^Patrick^^^Herr||19371129|1|||Im Schlosse 28^^Bern^^3001^CH^1^^FR||^^1^^^^^^^^^011 111 11 11||1||0||111.1111.1111.11|||||||||||";

    @Test
    public void testHandleOData() throws Exception {

        Message message = HL7Converter.toMessage(HL7_PID);
        
        HL7ToOData hl7ToOData = new HL7ToOData();

        ODataManual out = hl7ToOData.handle(message);
        
        LOGGER.info("out: {}", out.toString());
        
        assertThat(out.getPatientName()).isEqualTo("Schlaepfer");
        assertThat(out.getPatientVorname()).isEqualTo("Patrick");
    }

}
