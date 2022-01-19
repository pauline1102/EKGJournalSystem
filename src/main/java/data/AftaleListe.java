package data;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement (name = "Aftaleliste")
public class AftaleListe {
    public List<AftaleData> getAftaler() {
        System.out.println("AftaleListe: " + Aftaler);
        return Aftaler;
    }


    public void setAftaler(List<AftaleData> aftaler) {
        Aftaler = aftaler;
    }

    @XmlElement
    List<AftaleData> Aftaler = new ArrayList<>();

}
