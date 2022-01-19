package data;

import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.List;

public class SessionListe {
    public List<SessionsData> getSessions() {
        System.out.println("SessionListe: " + Sessions);
        return Sessions;
    }


    public void setSessions(List<SessionsData> sessions) {
        Sessions = sessions;
    }

    @XmlElement
    List<SessionsData> Sessions = new ArrayList<>();
}
