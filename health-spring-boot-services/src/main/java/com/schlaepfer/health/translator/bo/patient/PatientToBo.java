package com.schlaepfer.health.translator.bo.patient;

import java.util.Arrays;
import java.util.List;

import org.apache.camel.Handler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.schlaepfer.health.schema.Patient;

import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.datatype.CX;
import ca.uhn.hl7v2.model.v25.segment.PID;


@Component
public class PatientToBo {

	private static final Logger LOGGER = LoggerFactory.getLogger(PatientToBo.class);
	
	@Handler
	public Patient handle(Message message) throws Exception {
		
		LOGGER.info("Translating from HL7 to BO");
		
		PID pid = (PID) message.get("PID");

		Patient patient = new Patient();
		
		List<CX> cxs = Arrays.asList(pid.getPatientIdentifierList());
        cxs.forEach(cx -> {
            LOGGER.info("id: {}",cx.getCx1_IDNumber().getValue());
            /*
            PatientExterneID patientExterneID = new PatientExterneID();
            patientExterneID.setSystemPatientID(cx.getCx1_IDNumber().getValue());
            patientExterneID.setSystemRef(cx.getAssigningAuthority().getName());
            patient.getPatientExterneID().add(patientExterneID);
            */
            
        });
        
		patient.setName(pid.getPatientName(0).getFamilyName().getSurname().getValue());
        patient.setVorname(pid.getPatientName(0).getGivenName().getValue());
		
		return patient;
	}

}
