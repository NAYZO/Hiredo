/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package nzo;

import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nzo.entity.Enterprise;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;


@Stateless
@LocalBean
@Path("entreprise")
public class RestEntreprise {
    
    @PersistenceContext
    private EntityManager em;

    /**
     * Retrieves representation of an instance of helloWorld.RestUsers
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Enterprise getEntreprise (@PathParam("id") Integer id) {
        return em.find(Enterprise.class, id);
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/login")
    public Enterprise Login(Enterprise user) {
        return (Enterprise) em.createNamedQuery("Enterprise.findByEmailAndPassword")
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getSingleResult();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public Response CreateEnterprise (Enterprise user) {
        
        try {
            em.persist(user);
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return Response.status(201).entity("ok").build();
    }
    
    @DELETE
    @Path("{id}")
    public void deleteEnterprise (@PathParam("id") String id) {
        try {
            em.remove(id);                
            
        } catch (Exception ex) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("text/plain")
    public Response UpdateEnterprise (Enterprise val) {
        
        try {
            em.persist(val);
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return Response.status(201).entity("ok").build();
    }
}
