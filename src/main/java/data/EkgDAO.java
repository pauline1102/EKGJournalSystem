package data;

import db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class EkgDAO {
    private static Connection connection = new DBConnector().getMySQLConnection();

    public String addEkg(EkgData ekgData){

        String insertEkg = "INSERT INTO measurements (dataEkg, sessionID, orderNo)" + " VALUES (?,?,?);";
        System.out.println(insertEkg);
        try {
            UUID sessionID = UUID.randomUUID();
            PreparedStatement preparedStatement = connection.prepareStatement(insertEkg);
            for (int i = 0; i < ekgData.getData().size(); i++) {
                preparedStatement.setFloat(1, ekgData.data.get(i));
                preparedStatement.setString(2, sessionID.toString());
                preparedStatement.setInt(3, i);
                preparedStatement.addBatch();
            }
            preparedStatement.executeBatch();
            return sessionID.toString();
        } catch (SQLException ex) {
            System.out.println("Ups.. Der opstod en fejl under oprettelsen af ekg. Prøv igen eller kontakt udviklerne!");
            ex.printStackTrace();
        }
        return null;
    }

    public List<Float> getEkg(String findSessionID){
        String getMeasurements = "SELECT dataEkg FROM measurements WHERE sessionID = ?";
        System.out.println("Finder målinger for sessionID" + findSessionID);
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getMeasurements);
            preparedStatement.setString(1, findSessionID);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<Float> measurementsList = new ArrayList<>();
            while (resultSet.next()){
                Float measurement = resultSet.getFloat("dataEkg");
                measurementsList.add(measurement);
            }
            System.out.println("Liste med measurements = " +measurementsList);
            System.out.println(findSessionID);
            return measurementsList;
        } catch (SQLException e) {
            e.printStackTrace();
        } return null;
    }
}


