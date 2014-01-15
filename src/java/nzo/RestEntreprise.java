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
import javax.persistence.Query;
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
import nzo.entity.Job;
import nzo.entity.Users;


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
            em.remove(em.find(Enterprise.class, id));
            
        } catch (Exception ex) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("text/plain")
    public Response UpdateEnterprise (Enterprise val) {
        
        try {
            em.merge(val);
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return Response.status(201).entity("ok").build();
    }
    
    @GET
    @Produces("application/json")
    @Path("/search/{value}/{city}")
    public List<Enterprise> search (@PathParam("value") String value, @PathParam("city") String city) {
        if("000".equals(city)) {
            city = "";
        }
        return (List<Enterprise>) em.createNamedQuery("Enterprise.search").setParameter("value", "%" + value + "%").setParameter("city", "%" + city + "%").getResultList();
    }
    
    @GET
    @Produces("text/plain")
    @Path("/setnotif/{id_job}")
    public Response SetNotif (@PathParam("id_job") Integer idJob) {
        try {
            Job job = em.find(Job.class, idJob);
            Enterprise entre = em.find(Enterprise.class, job.getIdEntreprise());
            String code = "You have a new application on your job '" + job.getTitle() + "'.";
            
            Query qqq = em.createNamedQuery("Enterprise.setNotif").setParameter("code", code).setParameter("jobId", idJob).setParameter("id", entre.getId());
            qqq.executeUpdate();
        }
        catch(Exception ex) {
            return Response.status(500).entity("Error\nClass: " + ex.getClass() + "\nCause: " + ex.getCause() + "\nMessage: " + ex.getMessage()).build();
        }
        return Response.status(201).entity("ok").build();
    }
    
    @GET
    @Produces("application/json")
    @Path("/getnotif/{id}")
    public Notification getNotif(@PathParam("id") Integer id) {
        List liste = em.createNamedQuery("Enterprise.findNotification").setParameter("id", id).getResultList();
        if(liste.isEmpty()) {
            return new Notification();
        }
        
        Query up = em.createNamedQuery("Enterprise.initNotification").setParameter("id", id);
        up.executeUpdate();
        Notification notif = new Notification();
        Enterprise entre = em.find(Enterprise.class, id);
        notif.setEntreprise((Enterprise)liste.get(0));
        notif.setPostules(em.createNamedQuery("Postule.findByIdJob").setParameter("idJob", entre.getNotifmsg()).getResultList());
        return notif;
    }
    
}
