import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

        import com.fasterxml.jackson.core.JsonProcessingException;
        import com.fasterxml.jackson.databind.SerializationFeature;
        import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import data.Aftale;

import java.io.File;
        import java.io.IOException;
@Deprecated
public class XMLSerializer {
    public static void main(String[] args) {
        Aftale aftale = new Aftale();
        XmlMapper mapper = new XmlMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            String xmlString = mapper.writeValueAsString(aftale);
           // String xmlString2 = mapper.writeValueAsString(patient1);
            System.out.println(xmlString);
           // System.out.println(xmlString2);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            mapper.writeValue(new File("Aftale.xml"),aftale);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Aftale aftaleFromXML = mapper.readValue(new File("Aftale.xml"),Aftale.class);
            System.out.println("Read From XML: " + aftaleFromXML);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}