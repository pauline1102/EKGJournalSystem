package api;

import business.JWTHandler;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;


@Provider
public class AuthFilter implements ContainerRequestFilter {
    @Override
    public void filter(ContainerRequestContext containerRequestContext) throws IOException {
        System.out.println(containerRequestContext.getUriInfo().getPath());
        if ("aftale".equals(containerRequestContext.getUriInfo().getPath())) {
            System.out.println("tilgår aftaler");
            if (!containerRequestContext.getHeaderString("Authorization").equals("Bearer hemmeliglogin")) {
                throw new WebApplicationException("psst hvad er kodeordet?", 401);
            }
            return;
        }
//Undgå at afvise folk der prøver at logge ind.
           String path = containerRequestContext.getUriInfo().getPath();
            if (!"login".equals(path) && !"ekgSessions".equals(path)) {
                String authorization = containerRequestContext.getHeaderString("Authorization");
                if (authorization == null) {
                    throw new WebApplicationException("manglende header", 401);
                }
                JWTHandler.validate(authorization.split(" ")[1]);
            }
        }
    }


