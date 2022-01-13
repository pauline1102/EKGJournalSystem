package api;

import data.Ekg;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("ecg")
public class EkgService {
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public String postEKGDATA(Ekg data){
            System.out.println(data.getData().toString());
            return "hej";
        }
}
