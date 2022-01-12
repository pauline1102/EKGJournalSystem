package data;

import db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    public static UserData findUser(String username) {

        try {
            Connection connection = DBConnector.getMySQLConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users1 WHERE username = ?");
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            //Check om der var resultat og konverter til Java-Object (LoginData)
            if (resultSet.next()) {
                UserData foundUser = new UserData();
                foundUser.setUsername(resultSet.getString("username"));
                foundUser.setPassword(resultSet.getString("password"));
                System.out.println(foundUser);
                return foundUser;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return null;
    }
}
