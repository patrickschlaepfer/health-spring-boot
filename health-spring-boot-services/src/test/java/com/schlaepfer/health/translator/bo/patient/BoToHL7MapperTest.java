package com.schlaepfer.health.translator.bo.patient;

import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.schlaepfer.health.schema.Patient;
import com.schlaepfer.health.translator.bo.patient.PatientMapper;

import ca.uhn.hl7v2.model.v25.segment.PID;


public class BoToHL7MapperTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(BoToHL7MapperTest.class);
	
	@Test
	public void testBoToHL7Mapping() {
		
		LOGGER.info("Testing Bo to HL7 mapping");
		
		Patient patient = new Patient();
		patient.setVorname("Vorname");
		patient.setName("Name");
		patient.setGeschlechtRef("1");
		
		PatientMapper patientMapper = Mappers.getMapper(PatientMapper.class);
		
		PID pid = patientMapper.patientToPID(patient);
		
		LOGGER.info("geschlechtRef: {}", pid.getAdministrativeSex().getValue());
		
	}

}
