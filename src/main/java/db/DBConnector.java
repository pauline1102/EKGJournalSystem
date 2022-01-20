package db;

import data.AftaleDAO;
import data.EkgDAO;
import data.UserDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {
    public static Connection getMySQLConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://mysql-db.caprover.diplomportal.dk/s205481?user=s205481&password=iSdBO5cuIySWKV9I42kvo");
            if (connection != null) {
                System.out.println("Connected to MYSQL Schema: Journal");
            }
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
