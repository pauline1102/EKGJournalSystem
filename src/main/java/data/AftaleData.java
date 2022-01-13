package data;

public class AftaleData {

    private String date;
    private String cpr;

    public AftaleData(){

    }

    public AftaleData(String date, String cpr){
        this.date = date;
        this.cpr = cpr;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String toString(){
        return this.date + " " + this.cpr;
    }
}

