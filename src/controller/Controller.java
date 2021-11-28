package controller;

import database.DBManager;
import model.Doctor;
import model.Nurse;
import model.Patient;
import model.Unit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    private static Scanner sc=new Scanner(System.in);

    public static void register(){
        System.out.println("What do You want to register?\t(doctor-nurse-patient-unit)");
        String input=sc.nextLine();
        switch (input){
            case "doctor":
                Doctor doctor=getDoctorInfo();
                saveDoctorToDb(doctor);
                break;
            case "nurse":
                Nurse nurse=getNurseInfo();
                saveNurseToDb(nurse);
                break;
            case "patient":
                Patient patient=getPatientInfo();
                savePatientToDb(patient);
                break;
            case "unit":
                Unit unit=getUnitInfo();
                saveUnitToDb(unit);
                break;
        }
    }
    public static void showTables(){
        System.out.println("Which one of tables do you want to see?\t(doctor-nurse-patient-unit-all)");
        String input=sc.nextLine();
        switch (input){
            case "doctor":
                showDoctorsTable();
                break;
            case "nurse":
                showNursesTable();
                break;
            case "patient":
                showPatientsTable();
                break;
            case "unit":
                showUnitsTable();
                break;
            case "all":
                showDoctorsTable();
                showNursesTable();
                showPatientsTable();
                showUnitsTable();
                break;
        }
    }
    private static Doctor getDoctorInfo(){
        System.out.print("Enter model.Doctor information!\nWhat is the model.Doctor's name?");
        String doctorName=sc.nextLine();
        System.out.print("What is the doctor's unit?");
        String doctorUnit=sc.nextLine();
        System.out.print("How old is the doctor?");
        int doctorAge=sc.nextInt();
        System.out.print("What is the doctor's patient name?");
        String doctorsPatient=sc.nextLine();
        return new Doctor(doctorName,doctorUnit,doctorAge,doctorsPatient);

    }
    private static void saveDoctorToDb(Doctor doctor){
        boolean save= DBManager.getInstance().saveDoctors(doctor);
        if (save) {
            System.out.println("Process Saved Successfully!");
        } else {
            System.err.println("Save Process Unsuccessful!");
        }
    }
    private static Nurse getNurseInfo(){
        System.out.print("Enter model.Nurse information!\nWhat is the model.Nurse's name?");
        String nurseName=sc.nextLine();
        System.out.print("What is the model.Nurse's unit?");
        String nurseUnit=sc.nextLine();
        System.out.print("How old is the model.Nurse?");
        int nurseAge=sc.nextInt();
        System.out.print("What is the model.Nurse's patient name?");
        String patient=sc.nextLine();
        return new Nurse(nurseName,nurseUnit,nurseAge,patient);

    }
    private static void saveNurseToDb(Nurse nurse){
        boolean save= DBManager.getInstance().saveNurses(nurse);
        if (save) {
            System.out.println("Process Saved Successfully!");
        } else {
            System.err.println("Save Process Unsuccessful!");
        }
    }
    private static Patient getPatientInfo(){
        System.out.print("Enter model.Patient information!\nWhat is the model.Patient's name?");
        String patientName=sc.nextLine();
        System.out.print("What is the model.Patient's unit?");
        String patientUnit=sc.nextLine();
        System.out.print("How old is the model.Patient?");
        int patientAge=sc.nextInt();
        System.out.print("What is the model.Patient's doctor name?");
        String patientsDoctor=sc.nextLine();
        System.out.print("What is the model.Patient's nurse name?");
        String patientsNurse=sc.nextLine();
        return new Patient(patientName,patientUnit,patientAge,patientsDoctor,patientsNurse);
    }
    private static void savePatientToDb(Patient patient){
        boolean save= DBManager.getInstance().savePatients(patient);
        if (save) {
            System.out.println("Process Saved Successfully!");
        } else {
            System.err.println("Save Process Unsuccessful!");
        }
    }
    private static Unit getUnitInfo(){
        System.out.print("Enter model.Unit information!\nWhat is the model.Unit's name?");
        String unitName=sc.nextLine();
        System.out.print("What is the model.Unit's doctor name?");
        String unitsDoctor=sc.nextLine();
        System.out.print("What is the model.Unit's nurse name?");
        String unitsNurse=sc.nextLine();
        System.out.print("What is the model.Unit's patient name?");
        String unitsPatient=sc.nextLine();
        return new Unit(unitName,unitsDoctor,unitsNurse,unitsPatient);
    }
    private static void saveUnitToDb(Unit unit){
        boolean save= DBManager.getInstance().saveUnits(unit);
        if (save) {
            System.out.println("Process Saved Successfully!");
        } else {
            System.err.println("Save Process Unsuccessful!");
        }
    }
    private static void showDoctorsTable() {
        ArrayList<Doctor> doctors= DBManager.getInstance().loadDoctors();
        for (Doctor doctor:doctors){
            System.out.println(doctor);
        }
    }
    private static void showNursesTable() {
        ArrayList<Nurse> nurses= DBManager.getInstance().loadNurses();
        for (Nurse nurse:nurses){
            System.out.println(nurse);
        }
    }
    private static void showPatientsTable() {
        ArrayList<Patient> patients= DBManager.getInstance().loadPatients();
        for (Patient patient:patients){
            System.out.println(patient);
        }
    }
    private static void showUnitsTable() {
        ArrayList<Unit> units= DBManager.getInstance().loadUnits();
        for (Unit unit:units){
            System.out.println(unit);
        }
    }
}
