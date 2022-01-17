package api;

import data.AftaleDAO;
import data.AftaleData;
import data.Ekg;
import data.EkgDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("ecg")
public class EkgService {
    private EkgDAO ekgDAO = new EkgDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public String postEKGDATA(Ekg data) {
        System.out.println(data.getData().toString());
        String id = ekgDAO.addEkg(data);
        return id;
    }

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{sessionID}")
    public List<Float> getEkgListe(@PathParam("sessionID") String sessionID){
        System.out.println("SessionID =" + sessionID);
        System.out.println("Listen =" + ekgDAO.getEkg((sessionID)));
        return ekgDAO.getEkg(sessionID);
    }

     */
}


