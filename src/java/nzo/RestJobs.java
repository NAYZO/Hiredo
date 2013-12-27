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
import nzo.entity.Job;
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
@Path("job")
public class RestJobs {
    
    @PersistenceContext
    private EntityManager em;

    /**
     * Retrieves representation of an instance of helloWorld.RestUsers
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Job getjob(@PathParam("id") Integer id) {
        return em.find(Job.class, id);
    }
    
    @POST
    @Produces("application/json")
    @Path("/domaine")
    public List<Job> getJobsByDomaine(Job jb) {
        return em.createNamedQuery("Job.findByDomaine").setParameter("domaine", jb.getDomaine()).getResultList();
    }
    
    @GET
    @Produces("application/json")
    @Path("/findall")
    public List<Job> getAllJobs() {
        return em.createNamedQuery("Job.findAll").getResultList();
    }
    
    @GET
    @Produces("application/json")
    @Path("/findall/{id}")
    public List<Job> getMyjobs (@PathParam("id") Integer id) {
        return em.createNamedQuery("Job.findByIdEntreprise").setParameter("idEntreprise", id).getResultList();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public Response CreateJob(Job jb) {
        
        try {
            em.persist(jb);
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return Response.status(201).entity("ok").build();
    }
    
    @DELETE
    @Path("{id}")
    public void deleteJob (@PathParam("id") String id) {
        try {
            em.remove(em.find(Job.class, id));

        } catch (Exception ex) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("text/plain")
    public Response UpdateJob (Job val) {
        
        try {
            em.merge(val);
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return Response.status(201).entity("ok").build();
    }
}
