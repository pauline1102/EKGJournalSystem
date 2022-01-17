package api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.json.XML;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("xml")
public class XMLService {

/*    @GET
    public AftaleListe getAftale(){
        AftaleListe aftaleListe = new AftaleListe();
        Aftale aftale = new Aftale();
        AftaleDAO aftaleDAO = new AftaleDAO();
        aftale.setCPR("");
        aftale.setID("11000");
        aftale.setKlinikID("104");
        aftale.setTimeStart("15-01-2022 14:30:00");
        aftale.setTimeEnd("15-01-2022 14:45:00");
        aftale.setNotat("Diagnose: Wolff-Parkinson-White syndrom");
        aftaleListe.getAftaler().add(aftale);
        return aftaleListe;
    }*/

    @GET
    @Path("aftale")
    public String hentAftale(@QueryParam("cpr") String cpr) throws UnirestException {
        HttpResponse<String> stringHttpResponse = Unirest.get("http://ekg2.diplomportal.dk:8080/data/aftaler?cpr=" +cpr)
                .header("accept", "application/xml")
                .header("Authorization", "Bearer hemmeliglogin")
                .asString();
        String body = stringHttpResponse.getBody();
        JSONObject xmlJSONObj = XML.toJSONObject(body);
        return xmlJSONObj.toString();
    }
}



//.asString().getBody();