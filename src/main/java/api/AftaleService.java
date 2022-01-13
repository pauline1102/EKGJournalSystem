package api;

import data.AftaleData;
import data.AftaleDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

@Path("aftaler")
public class AftaleService {

    private AftaleDAO aftaleDAO = new AftaleDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<AftaleData> getAftaler() {
        return aftaleDAO.getAftaler();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void opretAftale(AftaleData aftale) {
        aftaleDAO.addAftale(aftale);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{cpr}")
    public List<AftaleData> getAftale(@PathParam("cpr") String cpr) {
        return aftaleDAO.getAftaler(cpr);
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public void deleteAftale(@PathParam("id") String id){
        aftaleDAO.deleteAftaler(id);
    }

    /*
    @DELETE
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





//        public String hentCpr (String cpr) throws NullPointerException {
//            String patientcpr = "SELECT CPR from sundtek.aftale where cpr =" + cpr + ";";
//            String CPRnr = "";
//            try {
//                statement = connection.createStatement();
//                resultSet = statement.executeQuery(patientcpr);
//                while (resultSet.next()) {
//                    double cprNr = resultSet.getDouble(1);
//                    CPRnr = String.valueOf(cprNr);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//                System.out.println("Wooops.. Kunne ikke hente aftalen. ");
//            }
//            return CPRnr;
//        }
//
//        public List<String> hentDato (String cpr) throws NullPointerException {
//            String patientaftale = "SELECT date FROM sundtek.aftale where cpr = '10-12-1999-7878'";
//            List<String> date = new ArrayList<>();
//            try {
//                statement = connection.createStatement();
//                resultSet = statement.executeQuery(patientaftale);
//                while (resultSet.next()) {
//                    date.add(resultSet.getString(1));
//
//                }
//            } catch (SQLException g) {
//                g.printStackTrace();
//                System.out.println("Ups.. Kunne ikke hente patientaftalen.. :(");
//            }
//            return date;
//        }

//public void hentAftale(Aftale nyAftale){
//System.out.println(nyAftale.getDate());
//System.out.println(nyAftale.getCpr());
//aftaleController.saveAftale(nyAftale);
//}


