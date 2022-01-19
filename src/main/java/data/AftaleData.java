package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


public class AftaleData {


    private String cpr;
    private String id;
    private int klinikID = 1;
    private String timeStart;
    private String timeEnd;
    private String notat;


    public AftaleData(String cpr, String id, String timeStart, String timeEnd, int klinikID, String notat) {
    this.cpr = cpr;
    this.id = id;
    this.timeStart = timeStart;
    this.timeEnd = timeEnd;
    this.klinikID = klinikID;
    this.notat = notat;
    }

    @Override
    public String toString() {
        return "Aftale{" +
                "CPR='" + cpr + '\'' +
                ", ID='" + id + '\'' +
                ", KlinikID='" + klinikID + '\'' +
                ", TimeStart='" + timeStart + '\'' +
                ", TimeEnd='" + timeEnd + '\'' +
                ", Notat='" + notat + '\'' +
                '}';
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getKlinikID() {
        return klinikID;
    }

    public void setKlinikID(int klinikID) {
        this.klinikID = klinikID;
    }

    public String getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(String timeStart) {
        this.timeStart = timeStart;
    }

    public String getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(String timeEnd) {
        this.timeEnd = timeEnd;
    }

    public String getNotat() {
        return notat;
    }

    public void setNotat(String notat) {
        this.notat = notat;
    }
}


