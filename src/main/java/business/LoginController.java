package business;

import data.UserDAO;
import data.UserData;

import javax.ws.rs.WebApplicationException;

public class LoginController {
    public String validateUser(UserData userData) {
        UserData user = UserDAO.findUser(userData.getUsername());
        System.out.println("Userdata: " + userData);
        System.out.println("userFound" + user);
        if (user!=null && user.getPassword().equals(userData.getPassword())){
            String token = JWTHandler.generateJwtToken(userData);
            System.out.println(token);
            return  token;
        }
        throw new WebApplicationException("forkert brugernavn/kodeord",401);
    }
}
