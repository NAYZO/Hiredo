/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nzo;

import java.util.List;
import nzo.entity.Education;
import nzo.entity.Experience;
import nzo.entity.Language;
import nzo.entity.Users;

/**
 *
 * @author nayzo
 */
public class Profile {
    private Users user;
    private List<Education> education;
    private List<Experience> experience;
    private List<Language> language;

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

    
}
