package model;

public class Nurse extends Person {
    String patientName;

    public Nurse(String name, String unit, int age, String patientName) {
        super(name, unit, age);
        this.patientName = patientName;
    }

    public String getPatientName() {
        return patientName;
    }
}
