package api;

import data.AftaleDAO;
import data.AftaleData;
import data.Ekg;
import data.EkgDAO;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("ecg")
public class EkgService {
    private EkgDAO ekgDAO = new EkgDAO();
        @POST
        @Consumes(MediaType.APPLICATION_JSON)
        public String postEKGDATA(Ekg data){
            System.out.println(data.getData().toString());
            ekgDAO.addEkg(data);
            return "hej";
        }

}