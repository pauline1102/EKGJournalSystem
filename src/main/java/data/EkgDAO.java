package data;

import db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.UUID;


public class EkgDAO {
    private static Connection connection = new DBConnector().getMySQLConnection();

    public String addEkg(Ekg ekg){

        String insertEkg = "INSERT INTO measurements (dataEkg, sessionID, orderNo)" + " VALUES (?,?,?);";
        System.out.println(insertEkg);
        try {
            UUID sessionID = UUID.randomUUID();
            PreparedStatement preparedStatement = connection.prepareStatement(insertEkg);
            for (int i = 0; i <ekg.getData().size(); i++) {
                preparedStatement.setFloat(1, ekg.data.get(i));
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
}
