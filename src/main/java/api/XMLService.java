package api;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import java.util.ArrayList;

@Path("xml")
public class XMLService {

    @GET
    @Path("aftale")
    public String hentAftale(@QueryParam("cpr") String cpr) throws UnirestException {
        ArrayList<String> roots = new ArrayList<>();
        roots.add("http://ekg2.diplomportal.dk:8080/data");
        roots.add("https://ekg3.diplomportal.dk/data");
        roots.add("http://ekg4.diplomportal.dk:8080/data");
        roots.add("http://130.225.170.165:8080/data");
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("Bearer hemmeliglogin");
        tokens.add("Bearer hemmeliglogin");
        tokens.add("Bearer hemmeliglogin");
        tokens.add("hemmeliglogin");

        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < roots.size(); i++) {
            HttpResponse<String> stringHttpResponse = Unirest.get(roots.get(i) + "/aftaler?cpr=" + cpr)
                    .header("accept", "application/xml")
                    .header("Authorization", tokens.get(i))
                    .asString();
            String body = stringHttpResponse.getBody();
            JSONObject xmlJSONObj = XML.toJSONObject(body);
            jsonArray.put(xmlJSONObj);
        }
        return jsonArray.toString();
    }

    @GET
    @Path("sessions")
    public String hentSession(@QueryParam("cpr") String cpr) throws UnirestException{
        ArrayList<String> roots1 = new ArrayList<>();
        roots1.add("http://ekg2.diplomportal.dk:8080/data");
        roots1.add("https://ekg3.diplomportal.dk/data");
        roots1.add("http://ekg4.diplomportal.dk:8080/data");
        roots1.add("http://130.225.170.165:8080/data");
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("Bearer hemmeliglogin");
        tokens.add("Bearer hemmeliglogin");
        tokens.add("Bearer hemmeliglogin");
        tokens.add("hemmeliglogin");
        JSONArray jsonArray1 = new JSONArray();
        for (int i = 0; i < roots1.size(); i++) {
            HttpResponse<String> stringHttpResponse = Unirest.get(roots1.get(i) + "/ekgSessions?cpr=" + cpr)
                    .header("accept", "application/xml")
                    .header("Authorization", tokens.get(i))
                    .asString();
            String body = stringHttpResponse.getBody();
            JSONObject xmlJSONObj = XML.toJSONObject(body);
            jsonArray1.put(xmlJSONObj);
        }
        return jsonArray1.toString();
    }

    @GET
    @Path("sessions/measurements")
    public String hentEkgMeasurements(@QueryParam("sessionID") int sessionID) throws UnirestException {
        ArrayList<String> roots2 = new ArrayList<>();
        roots2.add("http://ekg2.diplomportal.dk:8080/data");
        roots2.add("https://ekg3.diplomportal.dk/data");
        roots2.add("http://ekg4.diplomportal.dk:8080/data");
        roots2.add("http://130.225.170.165:8080/data");
        ArrayList<String> tokens = new ArrayList<>();
        tokens.add("Bearer hemmeliglogin");
        tokens.add("Bearer hemmeliglogin");
        tokens.add("Bearer hemmeliglogin");
        tokens.add("hemmeliglogin");
        JSONArray jsonArray2 = new JSONArray();
        for (int i = 0; i < roots2.size(); i++) {
            HttpResponse<String> stringHttpResponse = Unirest.get(roots2.get(i) + "/ekgSessions/measurements?sessionID=" + sessionID)
                    .header("accept", "application/xml")
                    .header("Authorization", tokens.get(i))
                    .asString();
            String body = stringHttpResponse.getBody();
            JSONObject xmlJSONObj = XML.toJSONObject(body);
            jsonArray2.put(xmlJSONObj);
            System.out.println(jsonArray2);
        }
        return jsonArray2.toString();
    }
}

