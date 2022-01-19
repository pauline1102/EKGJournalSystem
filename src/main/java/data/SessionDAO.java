package data;

import db.DBConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SessionDAO {
    private static Connection connection = new DBConnector().getMySQLConnection();

    public SessionsData getSessions(String findSessions){
        String getSessions = "SELECT * FROM sessions WHERE cpr = ?";
        System.out.println("Finder sessions for cpr" + findSessions);
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getSessions);
            preparedStatement.setString(1, findSessions);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
               SessionsData sessionsData = new SessionsData();
               sessionsData.setSessionID(resultSet.getString("sessionID"));
               sessionsData.setCpr(resultSet.getString("cpr"));
               sessionsData.setTimeStart(resultSet.getString("timeStart"));
               sessionsData.setComments(resultSet.getString("comments"));
               return sessionsData;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } return null;
    }

  public SessionListe getSessionID(String findsession){
        String getSessionID = "SELECT * FROM sessions WHERE cpr = ?";
        System.out.println("Finder sessionsID på cpr =" + findsession);
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(getSessionID);
            preparedStatement.setString(1, findsession);
            ResultSet resultSet = preparedStatement.executeQuery();
            SessionsData sessionsData = new SessionsData();
            SessionListe sessionListe = new SessionListe();
            while (resultSet.next()){
                sessionsData.setSessionID(resultSet.getString("sessionID"));
                sessionsData.setCpr(resultSet.getString("cpr"));
                sessionsData.setTimeStart(resultSet.getString("timeStart"));
                sessionsData.setComments(resultSet.getString("comments"));
                sessionListe.getSessions().add(sessionsData);
                return sessionListe;
            }
            System.out.println(findsession);

        } catch (SQLException e) {
            e.printStackTrace();
        } return null;
    }
}
