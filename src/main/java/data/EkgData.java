package data;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement (name = "measurement")
public class EkgData {

    List<Float> data;

public EkgData() {

}
    public List<Float> getData() {
        return data;
    }

    public void setData(List<Float> data) {
        this.data = data;
    }

}
//https://reqbin.com/code/python/m2g4va4a/python-requests-post-json-example



