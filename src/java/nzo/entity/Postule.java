/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nzo.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nayzo
 */
@Entity
@Table(name = "postule")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Postule.findAll", query = "SELECT p FROM Postule p"),
    @NamedQuery(name = "Postule.findById", query = "SELECT p FROM Postule p WHERE p.id = :id"),
    @NamedQuery(name = "Postule.findByIdJob", query = "SELECT p FROM Postule p WHERE p.idJob = :idJob"),
    @NamedQuery(name = "Postule.findByIdUser", query = "SELECT p FROM Postule p WHERE p.idUser = :idUser"),
    @NamedQuery(name = "Postule.findByResume", query = "SELECT p FROM Postule p WHERE p.resume = :resume"),
    @NamedQuery(name = "Postule.findByCv", query = "SELECT p FROM Postule p WHERE p.cv = :cv"),
    @NamedQuery(name = "Postule.findByDatePostule", query = "SELECT p FROM Postule p WHERE p.datePostule = :datePostule"),
    @NamedQuery(name = "Postule.findByVideo", query = "SELECT p FROM Postule p WHERE p.video = :video")})
public class Postule implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_job")
    private int idJob;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @Size(max = 255)
    @Column(name = "resume")
    private String resume;
    @Size(max = 255)
    @Column(name = "cv")
    private String cv;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_postule")
    @Temporal(TemporalType.DATE)
    private Date datePostule;
    @Size(max = 255)
    @Column(name = "video")
    private String video;

    public Postule() {
    }

    public Postule(Integer id) {
        this.id = id;
    }

    public Postule(Integer id, int idJob, int idUser, Date datePostule) {
        this.id = id;
        this.idJob = idJob;
        this.idUser = idUser;
        this.datePostule = datePostule;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdJob() {
        return idJob;
    }

    public void setIdJob(int idJob) {
        this.idJob = idJob;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public Date getDatePostule() {
        return datePostule;
    }

    public void setDatePostule(Date datePostule) {
        this.datePostule = datePostule;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Postule)) {
            return false;
        }
        Postule other = (Postule) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nzo.entity.Postule[ id=" + id + " ]";
    }
    
}
