/**
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * You may not modify, use, reproduce, or distribute this software except in
 * compliance with  the terms of the License at:
 * http://java.net/projects/javaeetutorial/pages/BerkeleyLicense
 */
package nzo;


import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nzo.entity.Cv;
import nzo.entity.Resume;


@Stateless
public class RequestManager {
    
    @PersistenceContext
    private EntityManager em;
    
    public void uploadCv (Cv newcv) {

        try {
            em.persist(newcv);
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }
    
    public void uploadResume (Resume newresume) {

        try {
            em.persist(newresume);
        } catch (Exception e) {
            throw new EJBException(e);
        }
    }
}
