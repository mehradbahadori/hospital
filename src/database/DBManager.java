package database;

import model.Doctor;
import model.Nurse;
import model.Patient;
import model.Unit;

import java.sql.*;
import java.util.ArrayList;

public class DBManager {
    Connection connection;

    private static DBManager instance;
    private DBManager(){
        String url="jdbc:sqlite:hospital.db";
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
    }
    public static DBManager getInstance(){
        if (instance==null){
            instance=new DBManager();
        }
        return instance;
    }
    public boolean saveDoctors(Doctor doctor) {
        try {
            Statement st = connection.createStatement();
            String query=String.format("INSERT INTO model.Doctor(name,unit,age,patientName)" +
                            "VALUES( '%s', '%s', '%d', '%s');",
                    doctor.getName(),doctor.getUnit(),doctor.getAge(),doctor.getPatientName());
            st.execute(query);
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public boolean saveNurses(Nurse nurse){
        try {
            Statement st=connection.createStatement();
            String query=String.format("INSERT INTO 'model.Nurse' (name,unit,age,patientName)"+
                            "VALUES ('%s','%s','%d','%s');",
                    nurse.getName(),nurse.getUnit(),nurse.getAge(),nurse.getPatientName());
            st.execute(query);
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
    public boolean savePatients(Patient patient){
        try {
            Statement st=connection.createStatement();
            String query=String.format("INSERT INTO 'model.Patient' (name,unit,age,doctorName,nurseName)"+
                            "VALUES ('%s','%s','%d','%s','%s');"
                    ,patient.getName(),patient.getUnit(),patient.getAge(),patient.getDoctorName(),patient.getNurseName());
            st.execute(query);
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
    public boolean saveUnits(Unit unit){
        try {
            Statement st=connection.createStatement();
            String query=String.format("INSERT INTO 'model.Unit' (name,doctorName,nurseName,patientName)"+
                            "VALUES ('%s,'%s','%s','%s');",
                    unit.getName(),unit.getDoctorName(),unit.getNurseName(),unit.getPatientName());
            st.execute(query);
            return true;
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return false;
    }
    public ArrayList<Doctor> loadDoctors() {
        ArrayList<Doctor> doctors = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Doctor;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name=resultSet.getString("name");
                String unit=resultSet.getString("unit");
                int age=resultSet.getInt("age");
                String patientsName=resultSet.getString("patientName");
                Doctor doctor=new Doctor(name,unit,age,patientsName);
                doctors.add(doctor);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return doctors;
    }
    public ArrayList<Nurse> loadNurses() {
        ArrayList<Nurse> nurses = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Nurse;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name=resultSet.getString("name");
                String unit=resultSet.getString("unit");
                int age=resultSet.getInt("age");
                String patientsName=resultSet.getString("patientName");
                Nurse nurse=new Nurse(name,unit,age,patientsName);
                nurses.add(nurse);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return nurses;
    }
    public ArrayList<Patient> loadPatients() {
        ArrayList<Patient> patients = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Patient;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name=resultSet.getString("name");
                String unit=resultSet.getString("unit");
                int age=resultSet.getInt("age");
                String doctorsName=resultSet.getString("doctorName");
                String nursesName=resultSet.getString("nursesName");
                Patient patient=new Patient(name,unit,age,doctorsName,nursesName);
                patients.add(patient);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return patients;
    }
    public ArrayList<Unit> loadUnits() {
        ArrayList<Unit> units = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM Unit;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                String name=resultSet.getString("name");
                String doctorsName=resultSet.getString("doctorsName");
                String nursesName=resultSet.getString("nursesName");
                String patientsName=resultSet.getString("patientsName");
                Unit unit=new Unit(name,doctorsName,nursesName,patientsName);
                units.add(unit);
            }
        } catch (SQLException throwable) {
            throwable.printStackTrace();
        }
        return units;
    }
}