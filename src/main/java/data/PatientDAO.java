package data;

import db.DBConnector;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.core.MediaType;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientDAO {
    private static Connection connection = new DBConnector().getMySQLConnection();

    public void addPatient(PatientData patient){
        String insertPatient = "INSERT INTO patienter (name, cpr) VALUES (?,?):";
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
}
