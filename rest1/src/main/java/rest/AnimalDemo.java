/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.AnimalNoDB;

/**
 * REST Web Service
 *
 * @author simon
 */
@Path("animals")
public class AnimalDemo {
    
    private static Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AnimalDemo
     */
    public AnimalDemo() {
    }

    /**
     * Retrieves representation of an instance of rest.AnimalDemo
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getJson() {
        //TODO return proper representation object

        return "vuf";

    }

    @GET
    @Path("/animal_list")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson1() {
        return "[\"Dog\",\"Cat\",\"Mouse\",\"Bird\"]";
    }

    @GET
    @Path("/animal")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAnimal(){
        
        AnimalNoDB dog = new AnimalNoDB("dog", "Bark");
        
        String response = gson.toJson(dog);
        
        return response;
    }
}
