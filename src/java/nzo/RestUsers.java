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
import nzo.entity.Users;
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
import nzo.entity.Cv;
import nzo.entity.Education;
import nzo.entity.Experience;
import nzo.entity.Job;
import nzo.entity.Language;
import nzo.entity.Resume;
import nzo.entity.Video;


@Stateless
@LocalBean
@Path("user")
public class RestUsers {
    
    @PersistenceContext
    private EntityManager em;
    
    /**
     * Retrieves representation of an instance of helloWorld.RestUsers
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/json")
    @Path("{id}")
    public Users getUser(@PathParam("id") Integer id) {
        return em.find(Users.class, id);
    }
    
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    @Path("/login")
    public Users Login(Users user) {
        return (Users) em.createNamedQuery("Users.findByEmailAndPassword")
                .setParameter("email", user.getEmail())
                .setParameter("password", user.getPassword())
                .getSingleResult();
    }
    
    @GET
    @Produces("application/json")
    @Path("/profile/{id}")
    public Profile MyProfile (@PathParam("id") Integer id) {
        Profile prof = new Profile();
        prof.setUser(em.find(Users.class, id));
        prof.setEducation( (List<Education>) em.createNamedQuery("Education.findByIdUser").setParameter("idUser", id).getResultList() );
        prof.setExperience( (List<Experience>) em.createNamedQuery("Experience.findByIdUser").setParameter("idUser", id).getResultList() );
        prof.setLanguage( (List<Language>) em.createNamedQuery("Language.findByIdUser").setParameter("idUser", id).getResultList() );
        return prof;
    }
    
    @GET
    @Produces("application/json")
    @Path("/getcvresumevideo/{id}")
    public Profile getCvResumeVideo (@PathParam("id") Integer id) {
        Profile prof = new Profile();
        prof.setCv( (List<Cv>) em.createNamedQuery("Cv.findByIdUser").setParameter("idUser", id).getResultList() );
        prof.setResume((List<Resume>) em.createNamedQuery("Resume.findByIdUser").setParameter("idUser", id).getResultList() );
        prof.setVideo((List<Video>) em.createNamedQuery("Video.findByIdUser").setParameter("idUser", id).getResultList() );
        return prof;
    }
    
    @GET
    @Produces("application/json")
    @Path("/listejobpostule/{id}")
    public List<Job> getListeJobPostule (@PathParam("id") Integer id) {
        return (List<Job>) em.createNamedQuery("Job.findListJob").setParameter("idUser", id).getResultList();
    }
    
    @POST
    @Consumes("application/json")
    @Produces("text/plain")
    public Response CreateUser(Users user) {
        
        try {
            em.persist(user);
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return Response.status(201).entity("ok").build();
    }
   
    @DELETE
    @Path("{id}")
    public void deleteUsers (@PathParam("id") String id) {
        try {
            em.remove(id);                
            
        } catch (Exception ex) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
    }
    
    @PUT
    @Consumes("application/json")
    @Produces("text/plain")
    public Response UpdateUsers (Users val) {
        
        try {
            em.persist(val);
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return Response.status(201).entity("ok").build();
    }
}
