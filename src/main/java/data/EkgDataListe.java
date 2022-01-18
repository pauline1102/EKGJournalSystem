package data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement (name = "measurements")
public class EkgDataListe {
    public List<EkgData> getEkgDataListe() {
        return EkgDataListe;
    }

    public void setEkgDataListe(List<EkgData> ekgDataListe) {
        EkgDataListe = ekgDataListe;
    }

    List<EkgData> EkgDataListe = new ArrayList<>();


}
