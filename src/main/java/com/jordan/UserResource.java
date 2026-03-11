package com.jordan;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/users")
public class UserResource {
    private UserDAO userDAO = new UserDAO();

    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(User user) {
        try {
            if(userDAO.userExists(user.getUsername())) {
                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Username already exists").build();
            }
            userDAO.registerUser(user);
            return Response.ok().build();
        } catch(Exception e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(e.getMessage()).build();
        }
    }
}
