package com.schlaepfer.health.entity;

import java.io.Serializable;

public class ODataManual implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;
    private String patientName;
    private String patientVorname;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientVorname() {
        return patientVorname;
    }

    public void setPatientVorname(String patientVorname) {
        this.patientVorname = patientVorname;
    }

    @Override
    public String toString() {
        return "ODataManual [id=" + id + ", patientName=" + patientName + ", patientVorname=" + patientVorname + "]";
    }

}
