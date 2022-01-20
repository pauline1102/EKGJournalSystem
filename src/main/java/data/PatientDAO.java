package data;

import db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientDAO {
    private static Connection connection = new DBConnector().getMySQLConnection();

    public void addPatient(PatientData patient){
        String insertPatient = "INSERT INTO s205481.patienter (name, cpr) VALUES (?,?):";
        System.out.println(insertPatient);
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(insertPatient);
            preparedStatement.setString(1, patient.getName());
            preparedStatement.setString(2, patient.getCpr());
            preparedStatement.execute();
        } catch (SQLException ex){
            System.out.println("Der opstod en fejl under oprettelse af patienten");
            ex.printStackTrace();
        }
    }

    public PatientData getPatient(String findcpr){
    String getPatient = "SELECT * FROM patienter WHERE cpr = ?";
    try {
        PreparedStatement preparedStatement = connection.prepareStatement(getPatient);
        preparedStatement.setString(1, findcpr);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            PatientData foundPatient = new PatientData();
            foundPatient.setName(resultSet.getString("name"));
            foundPatient.setCpr(resultSet.getString("cpr"));
            System.out.println("Patient fundet: " + foundPatient);
            return foundPatient;
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } return null;
    }
}

