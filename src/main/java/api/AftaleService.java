package api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import data.AftaleDAO;
import data.AftaleData;
import data.AftaleListe;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("aftaler")
public class AftaleService {

    private AftaleDAO aftaleDAO = new AftaleDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void opretAftale(AftaleData aftale) {
        aftaleDAO.addAftale(aftale);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Path("{cpr}")
    public AftaleListe getAftale(@PathParam("cpr") String cpr) { //skal der være en query param her også??
        System.out.println(aftaleDAO.getAftaler(cpr));
        return aftaleDAO.getAftaler(cpr);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getAftaleXML(@QueryParam("cpr") String cpr) throws JsonProcessingException {
        XmlMapper mapper = new XmlMapper();
        String s = mapper.writeValueAsString(aftaleDAO.getAftaler(cpr));
        return s;
    }
/*    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void deleteAftale(@PathParam("id") String id){
        aftaleDAO.deleteAftaler(id);
    }*/


    /*
    /*@DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    public void deleteAftale(String cpr) {
        System.out.println("Removing aftale with CPR: " + cpr);
        for (AftaleData aftale : aftaleDAO.getAftaler()) {
            if (aftale.getCpr().equals(cpr)) {
                System.out.println("Aftale med patient: " + cpr + ": DATE: " + aftale.getDate() + " CPR: " + cpr + " has been deleted");
            }
        }
    }

     */


//
//    @PUT
//    @Consumes(MediaType.APPLICATION_JSON)
//    public void editAftale(String cpr, String nyDate) {
////            for (Aftale aftale : aftaleDAO.getAftaler()) {
////                if (aftale.getCpr().equals(cpr)) {
////                    String beforeDate = aftale.getDate();
////                    aftale.setDate(nyDate);
////                    System.out.println("Aftale with patient: " + cpr + " has been changed from: " + beforeDate + " to: " + nyDate);
////                }
////            }
//    }

}




