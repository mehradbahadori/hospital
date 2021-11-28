package model;

public class Patient extends Person {
    String doctorName;
    String nurseName;

    public Patient(String name, String unit, int age, String doctorName, String nurseName) {
        super(name, unit, age);
        this.doctorName = doctorName;
        this.nurseName = nurseName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public String getNurseName() {
        return nurseName;
    }
}
