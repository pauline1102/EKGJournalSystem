import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import data.Aftale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
@Deprecated
@WebServlet(name = "xmlservlet", urlPatterns = "/api")
public class XMLServlet extends HttpServlet {
    XmlMapper mapper = new XmlMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Aftale aftale = new Aftale();
        aftale.setCPR("1234567890");
        aftale.setID("Test ID: 1");
        aftale.setKlinikID("Klinik ID: 104");
        aftale.setTimeStart("15-01-2022 14:30:00");
        aftale.setTimeEnd("15-01-2022 14:45:00");
        aftale.setNotat("Diagnose: Wolff-Parkinson-White syndrom");
        String xmlString = mapper.writeValueAsString(aftale);
        PrintWriter writer = resp.getWriter();
        writer.write(xmlString);
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        Aftale aftale = mapper.readValue(req.getInputStream(), Aftale.class);
        System.out.println(aftale);
        resp.getWriter().write("Tak for brugeren: " + aftale);
    }
    URL url;

    {
        try {
            url = new URL("http://localhost:8080/EKGJournalSystem_war/api");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    HttpURLConnection http;

    {
        try {
            http = (HttpURLConnection)url.openConnection();
            http.setRequestMethod("POST");
            http.setDoOutput(true);
            http.setRequestProperty("Content-Type", "application/xml");

            String data = "<User><userName>Test User</userName><passWord>Test Pass</passWord></User>";
            byte[] out = data.getBytes(StandardCharsets.UTF_8);

            OutputStream stream = http.getOutputStream();
            stream.write(out);

            System.out.println(http.getResponseCode() + " ");
            http.getResponseMessage();
            http.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
