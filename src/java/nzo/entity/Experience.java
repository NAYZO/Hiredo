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
@Table(name = "experience")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Experience.findAll", query = "SELECT e FROM Experience e"),
    @NamedQuery(name = "Experience.findById", query = "SELECT e FROM Experience e WHERE e.id = :id"),
    @NamedQuery(name = "Experience.findByIdUser", query = "SELECT e FROM Experience e WHERE e.idUser = :idUser"),
    @NamedQuery(name = "Experience.findByTitle", query = "SELECT e FROM Experience e WHERE e.title = :title"),
    @NamedQuery(name = "Experience.findByDateFrom", query = "SELECT e FROM Experience e WHERE e.dateFrom = :dateFrom"),
    @NamedQuery(name = "Experience.findByDateTo", query = "SELECT e FROM Experience e WHERE e.dateTo = :dateTo"),
    @NamedQuery(name = "Experience.findByLink", query = "SELECT e FROM Experience e WHERE e.link = :link"),
    @NamedQuery(name = "Experience.findByEntreprise", query = "SELECT e FROM Experience e WHERE e.entreprise = :entreprise"),
    @NamedQuery(name = "Experience.findByLocation", query = "SELECT e FROM Experience e WHERE e.location = :location")})
public class Experience implements Serializable {
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
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Size(max = 255)
    @Column(name = "link")
    private String link;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "entreprise")
    private String entreprise;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "location")
    private String location;

    public Experience() {
    }

    public Experience(Integer id) {
        this.id = id;
    }

    public Experience(Integer id, int idUser, String title, Date dateFrom, Date dateTo, String description, String entreprise, String location) {
        this.id = id;
        this.idUser = idUser;
        this.title = title;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.description = description;
        this.entreprise = entreprise;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
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
        if (!(object instanceof Experience)) {
            return false;
        }
        Experience other = (Experience) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nzo.entity.Experience[ id=" + id + " ]";
    }
    
}
