package data;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "session")
public class SessionsData {

    String sessionID;
    String cpr;
    String timeStart;
    String comments;


    public SessionsData() {

    }


    @Override
    public String toString() {
        return "SessionsData{" +
                "sessionID='" + sessionID + '\'' +
                ", cpr='" + cpr + '\'' +
                ", timeStart='" + timeStart + '\'' +
                ", comments='" + comments + '\'' +
                '}';
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }



}
