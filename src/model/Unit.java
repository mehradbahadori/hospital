package model;

public class Unit {
    String name;
    String doctorName;
    String nurseName;
    String patientName;

    public Unit(String name, String doctorName, String nurseName, String patientName) {
        this.name = name;
        this.doctorName = doctorName;
        this.nurseName = nurseName;
        this.patientName = patientName;
    }

    public String getName() {
        return name;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getNurseName() {
        return nurseName;
    }

    public String getPatientName() {
        return patientName;
    }
}
