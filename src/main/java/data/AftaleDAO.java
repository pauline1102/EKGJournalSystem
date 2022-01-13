package data;

import db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class AftaleDAO {
    private static Connection connection = new DBConnector().getMySQLConnection();


    public List<AftaleData> getAftaler() {
        String getAftaler = "SELECT * FROM aftaler";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAftaler);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<AftaleData> aftaleList = new ArrayList<>();
            while (resultSet.next()){
                String cpr = resultSet.getString("cpr");
                String date = resultSet.getString("date");
                AftaleData aftale = new AftaleData(date,cpr);
                aftaleList.add(aftale);
            }
            return aftaleList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }

    public void addAftale(AftaleData aftale){

        String insertAftale = "INSERT INTO aftaler (cpr, date)" + " VALUES (?,?);";
        System.out.println(insertAftale);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertAftale);
            preparedStatement.setString(1, aftale.getCpr());
            preparedStatement.setString(2, aftale.getDate());
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Ups.. Der opstod en fejl under oprettelsen af aftalen. Prøv igen eller kontakt udviklerne!");
            ex.printStackTrace();
        }

    }

    public List<AftaleData> getAftaler(String findCpr) {
        String getAftaler = "SELECT * FROM aftaler WHERE cpr = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAftaler);
            preparedStatement.setString(1,findCpr);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<AftaleData> aftaleList = new ArrayList<>();
            while (resultSet.next()){
                String cpr = resultSet.getString("cpr");
                String date = resultSet.getString("date");
                AftaleData aftale = new AftaleData(date,cpr);
                aftaleList.add(aftale);
            }
            return aftaleList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteAftaler(AftaleData aftale){
        String deleteAftaler = "DELETE FROM aftaler WHERE date = (?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteAftaler);
            preparedStatement.setString(1, aftale.getCpr());
            preparedStatement.setString(2, aftale.getDate());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Aftale er ikke slettet");
            e.printStackTrace();
        }
    }
}

