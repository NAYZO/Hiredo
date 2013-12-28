/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nzo;

import java.util.Date;
import java.util.List;
import nzo.entity.Cv;
import nzo.entity.Education;
import nzo.entity.Experience;
import nzo.entity.Language;
import nzo.entity.Resume;
import nzo.entity.Users;
import nzo.entity.Video;

/**
 *
 * @author nayzo
 */
public class PostuleDetail {
    
    private Users user;
    private Cv cv1;
    private Resume lm;
    private Video vid;
    private Date postuleDate;
    
    /**
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * @return the cv1
     */
    public Cv getCv() {
        return cv1;
    }

    /**
     * @param cv1 the education to set
     */
    public void setCv(Cv cv1) {
        this.cv1 = cv1;
    }

    /**
     * @return the lm
     */
    public Resume getLm() {
        return lm;
    }

    /**
     * @param lm the lm to set
     */
    public void setLm(Resume lm) {
        this.lm = lm;
    }

    /**
     * @return the vid
     */
    public Video getVideo() {
        return vid;
    }

    /**
     * @param vid the video to set
     */
    public void setVideo(Video vid) {
        this.vid = vid;
    }

    /**
     * @return the postuleDate
     */
    public Date getPostuleDate() {
        return postuleDate;
    }

    /**
     * @param postuleDate the cv to set
     */
    public void setPostuleDate(Date postuleDate) {
        this.postuleDate = postuleDate;
    }
    
}
