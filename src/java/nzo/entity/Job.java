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
import javax.persistence.Lob;
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
@Table(name = "job")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Job.findListJob", query = "SELECT j FROM Job j, Postule p WHERE p.idUser = :idUser AND p.idJob = j.id"),
    @NamedQuery(name = "Job.findAll", query = "SELECT j FROM Job j ORDER BY j.datecreation"),
    @NamedQuery(name = "Job.findById", query = "SELECT j FROM Job j WHERE j.id = :id"),
    @NamedQuery(name = "Job.findByIdEntreprise", query = "SELECT j FROM Job j WHERE j.idEntreprise = :idEntreprise ORDER BY j.datecreation DESC"),
    @NamedQuery(name = "Job.findByTitle", query = "SELECT j FROM Job j WHERE j.title = :title"),
    @NamedQuery(name = "Job.findByType", query = "SELECT j FROM Job j WHERE j.type = :type"),
    @NamedQuery(name = "Job.findByCity", query = "SELECT j FROM Job j WHERE j.city = :city"),
    @NamedQuery(name = "Job.findByDatecreation", query = "SELECT j FROM Job j WHERE j.datecreation = :datecreation"),
    @NamedQuery(name = "Job.findByDomaine", query = "SELECT j FROM Job j WHERE j.domaine = :domaine ORDER BY j.datecreation")})
public class Job implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_entreprise")
    private int idEntreprise;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Column(name = "datecreation")
    @Temporal(TemporalType.DATE)
    private Date datecreation;
    @Size(max = 100)
    @Column(name = "domaine")
    private String domaine;

    public Job() {
    }

    public Job(Integer id) {
        this.id = id;
    }

    public Job(Integer id, int idEntreprise, String title, String type, String description, String city, Date datecreation) {
        this.id = id;
        this.idEntreprise = idEntreprise;
        this.title = title;
        this.type = type;
        this.description = description;
        this.city = city;
        this.datecreation = datecreation;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdEntreprise() {
        return idEntreprise;
    }

    public void setIdEntreprise(int idEntreprise) {
        this.idEntreprise = idEntreprise;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(Date datecreation) {
        this.datecreation = datecreation;
    }

    public String getDomaine() {
        return domaine;
    }

    public void setDomaine(String domaine) {
        this.domaine = domaine;
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
        if (!(object instanceof Job)) {
            return false;
        }
        Job other = (Job) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nzo.entity.Job[ id=" + id + " ]";
    }
    
}
