package data;

public class PatientData {

    @Override
    public String toString() {
        return "Patient{" +
                "navn='" + name + '\'' +
                ", cpr='" + cpr + '\'' +
                '}';
    }

    private String name;
    private String cpr;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

}
