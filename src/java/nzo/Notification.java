/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nzo;

import java.util.List;
import nzo.entity.Enterprise;
import nzo.entity.Postule;

/**
 *
 * @author Hamza
 */
public class Notification {
    
    private Enterprise entreprise;
    private List<Postule> postules;
    
    /**
     * @return the entreprise
     */
    public Enterprise getEntreprise() {
        return entreprise;
    }

    /**
     * @param entreprise the entreprise to set
     */
    public void setEntreprise(Enterprise entreprise) {
        this.entreprise = entreprise;
    }

    /**
     * @return the postules
     */
    public List<Postule> getPostules() {
        return postules;
    }

    /**
     * @param postules the postules to set
     */
    public void setPostules(List<Postule> postules) {
        this.postules = postules;
    }
}
