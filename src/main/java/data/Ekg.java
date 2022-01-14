package data;

import java.util.List;

public class Ekg {

   // String measurements;
    List<Float> data;
    String sessionID;
    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }



    public Ekg(Float measurement, String sessionsID) {
    }


//Tanken er at dette kan bruges til at strukturere dataen, så den kan behandles som en String
 /*   public String getMeasurements(){return measurements;}

    public void setMeasurements(String measurements) {
        this.measurements = measurements;
    }*/

    public List<Float> getData() {
        return data;
    }

    public void setData(List<Float> data) {
        this.data = data;
    }


}
//https://reqbin.com/code/python/m2g4va4a/python-requests-post-json-example



