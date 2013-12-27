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
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findById", query = "SELECT u FROM Users u WHERE u.id = :id"),
    @NamedQuery(name = "Users.findByEmailAndPassword", query = "SELECT u FROM Users u WHERE u.email = :email AND u.password = :password"),
    @NamedQuery(name = "Users.findByPassword", query = "SELECT u FROM Users u WHERE u.password = :password"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findByLastname", query = "SELECT u FROM Users u WHERE u.lastname = :lastname"),
    @NamedQuery(name = "Users.findByEmail", query = "SELECT u FROM Users u WHERE u.email = :email"),
    @NamedQuery(name = "Users.findByTel", query = "SELECT u FROM Users u WHERE u.tel = :tel"),
    @NamedQuery(name = "Users.findByCity", query = "SELECT u FROM Users u WHERE u.city = :city"),
    @NamedQuery(name = "Users.findByCode", query = "SELECT u FROM Users u WHERE u.code = :code"),
    @NamedQuery(name = "Users.findByNotif", query = "SELECT u FROM Users u WHERE u.notif = :notif"),
    @NamedQuery(name = "Users.findByNotifmsg", query = "SELECT u FROM Users u WHERE u.notifmsg = :notifmsg"),
    @NamedQuery(name = "Users.findBySocialsituation", query = "SELECT u FROM Users u WHERE u.socialsituation = :socialsituation"),
    @NamedQuery(name = "Users.findByTitleprofile", query = "SELECT u FROM Users u WHERE u.titleprofile = :titleprofile"),
    @NamedQuery(name = "Users.findByWebsite", query = "SELECT u FROM Users u WHERE u.website = :website"),
    @NamedQuery(name = "Users.findByPhoto", query = "SELECT u FROM Users u WHERE u.photo = :photo")})
public class Users implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "lastname")
    private String lastname;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 70)
    @Column(name = "email")
    private String email;
    @Size(max = 20)
    @Column(name = "tel")
    private String tel;
    @Lob
    @Size(max = 65535)
    @Column(name = "address")
    private String address;
    @Size(max = 50)
    @Column(name = "city")
    private String city;
    @Size(max = 10)
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
    @Size(max = 50)
    @Column(name = "socialsituation")
    private String socialsituation;
    @Lob
    @Size(max = 65535)
    @Column(name = "resume")
    private String resume;
    @Size(max = 200)
    @Column(name = "titleprofile")
    private String titleprofile;
    @Size(max = 255)
    @Column(name = "website")
    private String website;
    @Size(max = 255)
    @Column(name = "photo")
    private String photo;

    public Users() {
    }

    public Users(Integer id) {
        this.id = id;
    }

    public Users(Integer id, String password, String name, String lastname, String email, int notif, int notifmsg) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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

    public String getSocialsituation() {
        return socialsituation;
    }

    public void setSocialsituation(String socialsituation) {
        this.socialsituation = socialsituation;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getTitleprofile() {
        return titleprofile;
    }

    public void setTitleprofile(String titleprofile) {
        this.titleprofile = titleprofile;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
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
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "nzo.entity.Users[ id=" + id + " ]";
    }
    
}
