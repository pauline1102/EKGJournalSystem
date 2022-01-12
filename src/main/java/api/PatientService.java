package api;

import data.PatientDAO;
import data.PatientData;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;

@Path("patienter")
public class PatientService {

    private PatientDAO patientDAO = new PatientDAO();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void opretPatient(PatientData patient) {
        patientDAO.addPatient(patient);
    }
}
