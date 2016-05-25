package com.schlaepfer.health.translator.bo.patient;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import com.schlaepfer.health.schema.Patient;

import ca.uhn.hl7v2.model.v25.segment.PID;


@Mapper(uses = { HL7Mapper.class, DtoFactory.class, EntityFactory.class })
public interface PatientMapper {

	@Mappings({
        @Mapping(source = "administrativeSex.value", target = "geschlecht"),
        @Mapping(target="name", expression="java(new java.lang.String(pid.getPatientName(0).getFamilyName().getSurname().getValue()))"),
        @Mapping(target="vorname", expression="java(new java.lang.String(pid.getPatientName(0).getGivenName().getValue()))"),
    })
	Patient PIDToPatient(PID pid);

	@InheritInverseConfiguration
	PID patientToPID(Patient patient);

}
 