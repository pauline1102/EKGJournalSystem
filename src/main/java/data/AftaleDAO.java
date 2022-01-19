package data;

import db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


public class AftaleDAO {
    private static Connection connection = new DBConnector().getMySQLConnection();


   /* public List<AftaleData> getAftalen() {
        String getAftaler = "SELECT * FROM aftaler";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAftaler);
            ResultSet resultSet = preparedStatement.executeQuery();
            List<AftaleData> aftaleList = new ArrayList<>();
            while (resultSet.next()){
                String cpr = resultSet.getString("CPR");
                String id = resultSet.getString("ID");
                String timeStart = resultSet.getString("timeStart");
                String timeEnd = resultSet.getString("timeEnd");
                int klinikID = resultSet.getInt("klinikID");
                String notat = resultSet.getString("notat");
                AftaleData aftale = new AftaleData();
                aftaleList.add(aftale);
            }
            return aftaleList;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;

    }*/

    public void addAftale(AftaleData aftale){
        String ID = UUID.randomUUID().toString();
        aftale.setId(ID);
        String insertAftale = "INSERT INTO aftaler (CPR, ID, timeStart, timeEnd, klinikID, notat )" + " VALUES (?,?,?,?,?,?);";
        System.out.println(insertAftale);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertAftale);
            preparedStatement.setString(1, aftale.getCpr());
            preparedStatement.setString(2, aftale.getId());
            preparedStatement.setString(3, aftale.getTimeStart());
            preparedStatement.setString(4, aftale.getTimeEnd());
            preparedStatement.setInt(5, aftale.getKlinikID());
            preparedStatement.setString(6, aftale.getNotat());
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Ups.. Der opstod en fejl under oprettelsen af aftalen. Prøv igen eller kontakt udviklerne!");
            ex.printStackTrace();
        }

    }

    public AftaleListe getAftaler(String findCpr) {
        String getAftaler = "SELECT * FROM aftaler WHERE cpr = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getAftaler);
            preparedStatement.setString(1,findCpr);
            ResultSet resultSet = preparedStatement.executeQuery();
            AftaleListe aftaleListe = new AftaleListe();
           // List<AftaleData> aftaleList = new ArrayList<>();
            while (resultSet.next()){
                System.out.println(resultSet.getMetaData().getColumnCount());
                String cpr = resultSet.getString("CPR");
                System.out.println(cpr);
                String id = resultSet.getString("ID");
                String timeStart = resultSet.getString("timeStart");
                String timeEnd = resultSet.getString("timeEnd");
                int klinikID = resultSet.getInt("klinikID");
                String notat = resultSet.getString("notat");
                AftaleData aftale = new AftaleData(cpr, id, timeStart, timeEnd, klinikID, notat);
                aftaleListe.getAftaler().add(aftale);
                System.out.println(aftale);
            }
            return aftaleListe;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    public void deleteAftaler(AftaleData aftale){
        String deleteAftaler = "DELETE FROM aftaler WHERE CPR = (?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(deleteAftaler);
            preparedStatement.setString(1, aftale.getCpr());
            preparedStatement.execute();
        } catch (SQLException e) {
            System.out.println("Aftale er ikke slettet");
            e.printStackTrace();
        }
    }
}

