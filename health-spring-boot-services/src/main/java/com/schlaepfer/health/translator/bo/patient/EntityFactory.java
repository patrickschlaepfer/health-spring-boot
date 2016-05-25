package com.schlaepfer.health.translator.bo.patient;

import java.io.IOException;

import org.mapstruct.TargetType;

import ca.uhn.hl7v2.HL7Exception;
import ca.uhn.hl7v2.model.v25.message.ADT_A01;
import ca.uhn.hl7v2.model.v25.segment.PID;

public class EntityFactory {

	public <T extends PID> T createEntity(@TargetType Class<T> entityClass) {
		ADT_A01 adt = new ADT_A01(); 
		try {
			adt.initQuickstart("ADT", "A01", "P");
		} catch (HL7Exception | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PID pid = adt.getPID(); 
		return (T) pid;
		 
	}
}
