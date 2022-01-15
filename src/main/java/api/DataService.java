package api;

import data.Aftale;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/remote")
@Produces(MediaType.APPLICATION_XML)
public class DataService {

    @GET
    public Aftale getAftale() {
        Aftale aftale = new Aftale();
        aftale.setCPR("1234567890");
        aftale.setID("Test ID: 1");
        aftale.setKlinikID("Klinik ID: 104");
        aftale.setTimeStart("15-01-2022 14:30:00");
        aftale.setTimeEnd("15-01-2022 14:45:00");
        aftale.setNotat("Diagnose: Wolff-Parkinson-White syndrom");
        return aftale;
    }

    @POST
    public String postAhoy(String name){
        return "Ahoy "+ name;
    }

}



