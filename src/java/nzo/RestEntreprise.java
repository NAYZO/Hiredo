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
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
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
    
   /* @GET
    @Produces("application/json")
    @Path("{email}")
    public Users Login(@PathParam("email") String email, @PathParam("password") String password) {
        Users user = null;
        user = (Users) em.createNamedQuery("findByEmailAndPassword").setParameter("email", email).setParameter("password", password).getSingleResult();
        return user;
    }
    */
    
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public Response CreateEnterprise(Enterprise user) {
        
        try {
            em.persist(user);
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return Response.status(201).entity("ok").build();
    }
    
    /**
     * PUT method for updating or creating an instance of RestUsers
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("text/html")
    public void putHtml(String content) {
    }
}
