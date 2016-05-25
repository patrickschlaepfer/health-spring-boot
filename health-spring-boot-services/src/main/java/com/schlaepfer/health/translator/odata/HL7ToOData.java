package com.schlaepfer.health.translator.odata;

import java.util.Arrays;
import java.util.List;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.schlaepfer.health.entity.ODataManual;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.datatype.CX;
import ca.uhn.hl7v2.model.v25.segment.PID;

@Component
public class HL7ToOData {

    private static final Logger LOGGER = LoggerFactory.getLogger(HL7ToOData.class);

    @Handler
    public ODataManual handle(Message in) throws Exception {

        LOGGER.info("Translating from HL7 to OData Standard");
        
        PID pid = (PID) in.get("PID");
        
        LOGGER.info("pid: {}", pid.getPatientID().getCx1_IDNumber());
        
        ODataManual response = new ODataManual();
        
        List<CX> cxs = Arrays.asList(pid.getPatientIdentifierList());
        cxs.forEach(cx -> {
            LOGGER.info("id: {}",cx.getCx1_IDNumber().getValue());
        });
        
        
        response.setId(pid.getPatientID().getCx1_IDNumber().getValue());
        response.setPatientName(pid.getPatientName(0).getFamilyName().getSurname().getValue());
        response.setPatientVorname(pid.getPatientName(0).getGivenName().getValue());
        
        return response;
        
    }

}
