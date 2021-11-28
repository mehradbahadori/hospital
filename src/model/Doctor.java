package model;

public class Doctor extends Person {
    String patientName;

    public Doctor(String name, String unit, int age,String patientName) {
        super(name, unit, age);
        this.patientName=patientName;
    }

    public String getPatientName() {
        return patientName;
    }
}
