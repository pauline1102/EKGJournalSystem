package data;

import db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class EkgDAO {
    private static Connection connection = new DBConnector().getMySQLConnection();

    public void addEkg(Ekg ekg){

        String insertEkg = "INSERT INTO measurements (dataEkg)" + " VALUES (?);";
        System.out.println(insertEkg);
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertEkg);
            preparedStatement.setString(1, String.valueOf(ekg.data.get(0)));
            preparedStatement.execute();
        } catch (SQLException ex) {
            System.out.println("Ups.. Der opstod en fejl under oprettelsen af ekg. Prøv igen eller kontakt udviklerne!");
            ex.printStackTrace();
        }

    }
}
