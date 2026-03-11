package com.jordan;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import java.util.List;

@Path("/records")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class RecordResource {

    private RecordDAO dao = new RecordDAO();

    @GET
    public List<Record> getRecords() throws Exception {
        return dao.getAllRecords();
    }

    @POST
    public Response addRecord(Record r) throws Exception {
        dao.addRecord(r);
        return Response.status(Response.Status.CREATED).build();
    }
}