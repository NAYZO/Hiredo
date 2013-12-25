/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package nzo;


import java.util.List;
import javax.ejb.EJBException;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nzo.entity.Language;
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
@Path("language")
public class RestLanguage {
    
    @PersistenceContext
    private EntityManager em;

    /**
     * Retrieves representation of an instance of helloWorld.RestUsers
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Language getLanguage (@PathParam("id") Integer id) {
        return em.find(Language.class, id);
    }
    
    @GET
    @Produces("application/json")
    @Path("/findall")
    public List<Language> getAllLanguage () {
        return em.createNamedQuery("Language.findAll").getResultList();
    }
    
    @DELETE
    @Path("{id}")
    public void deleteLanguage (@PathParam("id") String id) {
        try {
            em.remove(id);                
            
        } catch (Exception ex) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("text/plain")
    public Response UpdateLanguage (Language val) {
        
        try {
            em.persist(val);
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return Response.status(201).entity("ok").build();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public Response CreateLanguage (Language val) {
        
        try {
            em.persist(val);
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return Response.status(201).entity("ok").build();
    }
}
