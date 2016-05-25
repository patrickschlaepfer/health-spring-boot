package com.schlaepfer.health.translator.bo.patient;

import org.apache.camel.component.hl7.HL7Converter;
import org.junit.Test;
import org.mapstruct.factory.Mappers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.schlaepfer.health.schema.Patient;
import com.schlaepfer.health.translator.bo.patient.PatientMapper;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.Message;
import ca.uhn.hl7v2.model.v25.segment.PID;


import static org.fest.assertions.api.Assertions.assertThat;

public class HL7ToBoMapperTest {

	private static final Logger LOGGER = LoggerFactory.getLogger(HL7ToBoMapperTest.class);

	private static String HL7_1 = "MSH|^~\\&|SYSTEMONE|0750|ESB|0710|20160518073340||ADT^A31|00100255|P|2.5|||NE|NE|||||\r"
			+ "EVN|A31|20160518|||||\r"
			+ "PID|1||11111111^^^SAP~11111^^^SYSTEMONE||Schlaepfer^Patrick^^^Herr||19720223|1|||Alpenweg 28^^Bern^^3001^CH^1^^FR||^^1^^^^^^^^^012 333 11 11||1||0||000.0000.0000.00|||||||||||\r";

	private static String EXPECTED_GESCHLECT_REF = "1";
	private static String EXPECTED_NAME = "Schlaepfer";
	private static String EXPECTED_VORNAME = "Patrick";
	
	@Test
	public void testMapping() throws HL7Exception {

		LOGGER.info("Testing Mapper mapping");

		Message message = HL7Converter.toMessage(HL7_1);

		PID pid = (PID) message.get("PID");

		PatientMapper patientMapper = Mappers.getMapper(PatientMapper.class);

		Patient patient = patientMapper.PIDToPatient(pid);

		assertThat(patient.getGeschlechtRef()).isEqualTo(EXPECTED_GESCHLECT_REF);
		assertThat(patient.getName()).isEqualTo(EXPECTED_NAME);
		assertThat(patient.getVorname()).isEqualTo(EXPECTED_VORNAME);
		
	}

}
