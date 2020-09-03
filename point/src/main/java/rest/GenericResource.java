/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import Facade.PointFacade;
import com.google.gson.*;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import point.Point;

/**
 * REST Web Service
 *
 * @author simon
 */
@Path("point")
public class GenericResource {
    
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
    }

    /**
     * Retrieves representation of an instance of rest.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getXml() {
        //TODO return proper representation object
        
        String response = "{\"message\":\"hello\"}"; 
        return response;
    }
    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPoints(){
        
        PointFacade pfacade = new PointFacade();
        List<Point> points = pfacade.allPoints();
        
        String response = gson.toJson(points);
        
        return Response.ok().entity(response).build();
    }
}
