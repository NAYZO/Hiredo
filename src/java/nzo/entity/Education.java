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
@Table(name = "education")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Education.findAll", query = "SELECT e FROM Education e"),
    @NamedQuery(name = "Education.findById", query = "SELECT e FROM Education e WHERE e.id = :id"),
    @NamedQuery(name = "Education.findByIdUser", query = "SELECT e FROM Education e WHERE e.idUser = :idUser"),
    @NamedQuery(name = "Education.findByTitle", query = "SELECT e FROM Education e WHERE e.title = :title"),
    @NamedQuery(name = "Education.findByDeploma", query = "SELECT e FROM Education e WHERE e.deploma = :deploma"),
    @NamedQuery(name = "Education.findByDateFrom", query = "SELECT e FROM Education e WHERE e.dateFrom = :dateFrom"),
    @NamedQuery(name = "Education.findByDateTo", query = "SELECT e FROM Education e WHERE e.dateTo = :dateTo"),
    @NamedQuery(name = "Education.findByUniversity", query = "SELECT e FROM Education e WHERE e.university = :university"),
    @NamedQuery(name = "Education.findByLocation", query = "SELECT e FROM Education e WHERE e.location = :location")})
public class Education implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_user")
    private int idUser;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "title")
    private String title;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "deploma")
    private String deploma;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_from")
    @Temporal(TemporalType.DATE)
    private Date dateFrom;
    @Basic(optional = false)
    @NotNull
    @Column(name = "date_to")
    @Temporal(TemporalType.DATE)
    private Date dateTo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "university")
    private String university;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "location")
    private String location;

    public Education() {
    }

    public Education(Integer id) {
        this.id = id;
    }

    public Education(Integer id, int idUser, String title, String deploma, Date dateFrom, Date dateTo, String university, String location) {
        this.id = id;
        this.idUser = idUser;
        this.title = title;
        this.deploma = deploma;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.university = university;
        this.location = location;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeploma() {
        return deploma;
    }

    public void setDeploma(String deploma) {
        this.deploma = deploma;
    }

    public Date getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public Date getDateTo() {
        return dateTo;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
        if (!(object instanceof Education)) {
            return false;
        }
        Education other = (Education) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nzo.entity.Education[ id=" + id + " ]";
    }
    
}
