package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.mysql.cj.Session;
import data.*;

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
    @Path("{cpr}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public SessionListe getCPR(@PathParam("cpr") String cpr){
        System.out.println("sessionID for CPR? = " +sessionsDAO.getSessionID(cpr));
        return sessionsDAO.getSessionID(cpr);
    }


    @GET
    @Produces(MediaType.APPLICATION_XML)
    public String getCPRXML(@QueryParam("cpr") String cpr) throws JsonProcessingException {
       // System.out.println("sessionID for CPR? = " +sessionsDAO.getSessionID(cpr));
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(sessionsDAO.getSessions(cpr));
    }

    @GET
    @Path("measurements/{sessionID}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Float> getEkg(@PathParam("sessionID") String sessionID){
        System.out.println("SessionID =" + sessionID);
        System.out.println("Listen =" + ekgDAO.getEkg((sessionID)));
        return ekgDAO.getEkg(sessionID);
    }

    @GET
    @Path("measurements")
    @Produces( MediaType.APPLICATION_XML)
    public String getEkgXML(@QueryParam("sessionID") String sessionID) throws JsonProcessingException {
        /*System.out.println("SessionID =" + sessionID);
        System.out.println("Listen =" + ekgDAO.getEkg((sessionID)));*/
        XmlMapper mapper = new XmlMapper();
        return mapper.writeValueAsString(ekgDAO.getEkg(sessionID));

    }

}


