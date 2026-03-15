package com.jordan;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;

@Path("/species")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class FishSpeciesResource {

    FishSpeciesDAO dao = new FishSpeciesDAO();

    // 获取所有鱼种
    @GET
    public List<FishSpecies> getAllSpecies() {
        return dao.getAllSpecies();
    }

    // 根据鱼种名字获取该鱼种的所有记录
    @GET
    @Path("/{name}/records")
    public List<Record> getRecordsBySpecies(@PathParam("name") String name) throws Exception {
        RecordDAO recordDao = new RecordDAO();
        return recordDao.getRecordsBySpecies(name);
    }
    @GET
    @Path("/test")
    public String test() {
        return "FishSpeciesResource is working";
    }
}
