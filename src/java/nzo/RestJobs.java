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
        return (List<Job>) em.createNamedQuery("Job.findbydomaine")
                .setParameter("domaine", jb.getDomaine());
    }
    
    @GET
    @Produces("application/json")
    @Path("/findall")
    public List<Job> getAllJobs() {
        return (List<Job>) em.createNamedQuery("Job.findAll");
    }
    
    @POST
    @Produces("application/json")
    @Path("/myjobs")
    public List<Job> getMyjobs(Enterprise entp) {
        return (List<Job>) em.createNamedQuery("Job.findbyentreprise")
                .setParameter("entreprise", entp.getId());
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

}
