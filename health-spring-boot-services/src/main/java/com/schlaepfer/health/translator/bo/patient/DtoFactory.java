package com.schlaepfer.health.translator.bo.patient;

import com.schlaepfer.health.schema.Patient;

public class DtoFactory {

	public Patient PIDToPatient() {
		return new Patient();
	}
	
}
