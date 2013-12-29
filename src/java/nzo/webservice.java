/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nzo;

import javax.ejb.EJBException;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import nzo.entity.Video;

/**
 *
 * @author nayzo
 */
@Stateless
@WebService(serviceName = "webservice")
public class webservice {

    @PersistenceContext
    private EntityManager em;

    public void webservice() {
    }

    @WebMethod(operationName = "wsuploadvideo")
    public String wsuploadvideo (Integer iduer, String name) {
        Video vd = new Video();
        vd.setIdUser(iduer);
        vd.setName(name);
        vd.setPath("vide");
        try {
            em.persist(vd);
        } catch (Exception e) {
            throw new EJBException(e);
        }
        return "ok";
    }
    
    
}