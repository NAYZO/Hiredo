/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package nzo.entity;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author nayzo
 */
@Entity
@Table(name = "enterprise")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Enterprise.search", query = "SELECT u FROM Enterprise u WHERE (u.name LIKE :value OR u.activity LIKE :value) AND u.city LIKE :city"),
    @NamedQuery(name = "Enterprise.findAll", query = "SELECT e FROM Enterprise e"),
    @NamedQuery(name = "Enterprise.findById", query = "SELECT e FROM Enterprise e WHERE e.id = :id"),
    @NamedQuery(name = "Enterprise.findByEmailAndPassword", query = "SELECT e FROM Enterprise e WHERE e.email = :email AND e.password = :password"),
    @NamedQuery(name = "Enterprise.findByPassword", query = "SELECT e FROM Enterprise e WHERE e.password = :password"),
    @NamedQuery(name = "Enterprise.findByEmail", query = "SELECT e FROM Enterprise e WHERE e.email = :email"),
    @NamedQuery(name = "Enterprise.findByName", query = "SELECT e FROM Enterprise e WHERE e.name = :name"),
    @NamedQuery(name = "Enterprise.findByTel", query = "SELECT e FROM Enterprise e WHERE e.tel = :tel"),
    @NamedQuery(name = "Enterprise.findByFax", query = "SELECT e FROM Enterprise e WHERE e.fax = :fax"),
    @NamedQuery(name = "Enterprise.findByLogo", query = "SELECT e FROM Enterprise e WHERE e.logo = :logo"),
    @NamedQuery(name = "Enterprise.findByCity", query = "SELECT e FROM Enterprise e WHERE e.city = :city"),
    @NamedQuery(name = "Enterprise.findByCode", query = "SELECT e FROM Enterprise e WHERE e.code = :code"),
    @NamedQuery(name = "Enterprise.findByNotif", query = "SELECT e FROM Enterprise e WHERE e.notif = :notif"),
    @NamedQuery(name = "Enterprise.findByNotifmsg", query = "SELECT e FROM Enterprise e WHERE e.notifmsg = :notifmsg"),
    @NamedQuery(name = "Enterprise.findByActivity", query = "SELECT e FROM Enterprise e WHERE e.activity = :activity"),
    @NamedQuery(name = "Enterprise.findByNbemplyee", query = "SELECT e FROM Enterprise e WHERE e.nbemplyee = :nbemplyee"),
    @NamedQuery(name = "Enterprise.findByWebsite", query = "SELECT e FROM Enterprise e WHERE e.website = :website"),
    @NamedQuery(name = "Enterprise.findNotification", query = "SELECT e FROM Enterprise e WHERE e.id = :id AND e.notif = 1"),
    @NamedQuery(name = "Enterprise.initNotification", query = "UPDATE Enterprise e SET e.notif = 0 WHERE e.id = :id"),
    @NamedQuery(name = "Enterprise.setNotif", query = "UPDATE Enterprise e SET e.notif = 1, e.code = :code, e.notifmsg = :jobId WHERE e.id = :id")})

public class Enterprise implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "password")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 255)
    @Column(name = "name")
    private String name;
    @Size(max = 50)
    @Column(name = "tel")
    private String tel;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Size(max = 50)
    @Column(name = "fax")
    private String fax;
    @Size(max = 255)
    @Column(name = "logo")
    private String logo;
    @Lob
    @Size(max = 65535)
    @Column(name = "address")
    private String address;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 100)
    @Column(name = "code")
    private String code;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notif")
    private int notif;
    @Basic(optional = false)
    @NotNull
    @Column(name = "notifmsg")
    private int notifmsg;
    @Size(max = 255)
    @Column(name = "activity")
    private String activity;
    @Lob
    @Size(max = 65535)
    @Column(name = "resume")
    private String resume;
    @Column(name = "nbemplyee")
    private Integer nbemplyee;
    @Size(max = 255)
    @Column(name = "website")
    private String website;

    public Enterprise() {
    }

    public Enterprise(Integer id) {
        this.id = id;
    }

    public Enterprise(Integer id, String password, String email, String name, int notif, int notifmsg) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.notif = notif;
        this.notifmsg = notifmsg;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNotif() {
        return notif;
    }

    public void setNotif(int notif) {
        this.notif = notif;
    }

    public int getNotifmsg() {
        return notifmsg;
    }

    public void setNotifmsg(int notifmsg) {
        this.notifmsg = notifmsg;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public Integer getNbemplyee() {
        return nbemplyee;
    }

    public void setNbemplyee(Integer nbemplyee) {
        this.nbemplyee = nbemplyee;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
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
        if (!(object instanceof Enterprise)) {
            return false;
        }
        Enterprise other = (Enterprise) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nzo.entity.Enterprise[ id=" + id + " ]";
    }
    
}
