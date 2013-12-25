/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nzo;

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
public class Profile {
    private Users user;
    private List<Education> education;
    private List<Experience> experience;
    private List<Language> language;
    private List<Cv> cv;
    private List<Resume> resume;
    private List<Video> video;

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
     * @return the education
     */
    public List<Education> getEducation() {
        return education;
    }

    /**
     * @param education the education to set
     */
    public void setEducation(List<Education> education) {
        this.education = education;
    }

    /**
     * @return the experience
     */
    public List<Experience> getExperience() {
        return experience;
    }

    /**
     * @param experience the experience to set
     */
    public void setExperience(List<Experience> experience) {
        this.experience = experience;
    }

    /**
     * @return the language
     */
    public List<Language> getLanguage() {
        return language;
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(List<Language> language) {
        this.language = language;
    }

    /**
     * @return the cv
     */
    public List<Cv> getCv() {
        return cv;
    }

    /**
     * @param cv the cv to set
     */
    public void setCv(List<Cv> cv) {
        this.cv = cv;
    }

    /**
     * @return the resume
     */
    public List<Resume> getResume() {
        return resume;
    }

    /**
     * @param resume the resume to set
     */
    public void setResume(List<Resume> resume) {
        this.resume = resume;
    }

    /**
     * @return the video
     */
    public List<Video> getVideo() {
        return video;
    }

    /**
     * @param video the video to set
     */
    public void setVideo(List<Video> video) {
        this.video = video;
    }

    
}
