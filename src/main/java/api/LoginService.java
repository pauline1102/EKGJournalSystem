package api;

import business.LoginController;
import data.UserData;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("login")
public class LoginService {
    private static LoginController loginController = new LoginController();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String doLogin(UserData userData){
        //returner en token hvis det går godt
        return loginController.validateUser(userData);
    }
}

    /*

            }
            throw new WebApplicationException("forkert brugernavn/kodeord",401);
        }

     */