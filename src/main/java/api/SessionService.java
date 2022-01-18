package api;

import com.mysql.cj.Session;
import data.EkgData;
import data.EkgDAO;
import data.SessionDAO;
import data.SessionsData;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("ekgSessions")
public class SessionService {
    private EkgDAO ekgDAO = new EkgDAO();
    private SessionDAO sessionsDAO = new SessionDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postEKGDATA(EkgData data) {
        System.out.println(data.getData().toString());
        String id = ekgDAO.addEkg(data);
        return id;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{sessionID}")
    public List<Float> getEkgListe(@PathParam("sessionID") String sessionID){
        System.out.println("SessionID =" + sessionID);
        System.out.println("Listen =" + ekgDAO.getEkg((sessionID)));
        return ekgDAO.getEkg(sessionID);
    }

    @GET
    @Path("{cpr}")
    public String getCPR(@PathParam("cpr") String cpr){
        System.out.println("sessionID for CPR? = " +sessionsDAO.getSessions(cpr));
        return sessionsDAO.getSessionID(cpr);
    }

}


