/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author corwin
 */
@Entity
@Table(name = "good_hands")
@NamedQueries({
    @NamedQuery(name = "GoodHands.findAll", query = "SELECT g FROM GoodHands g"),
    @NamedQuery(name = "GoodHands.findById", query = "SELECT g FROM GoodHands g WHERE g.id = :id"),
    @NamedQuery(name = "GoodHands.findByWherePlaced", query = "SELECT g FROM GoodHands g WHERE g.wherePlaced = :wherePlaced"),
    @NamedQuery(name = "GoodHands.findByPhoto", query = "SELECT g FROM GoodHands g WHERE g.photo = :photo"),
    @NamedQuery(name = "GoodHands.findBySpecialFeature", query = "SELECT g FROM GoodHands g WHERE g.specialFeature = :specialFeature"),
    @NamedQuery(name = "GoodHands.findByPatType", query = "SELECT g FROM GoodHands g WHERE g.patType = :patType"),
    @NamedQuery(name = "GoodHands.findByPetKind", query = "SELECT g FROM GoodHands g WHERE g.petKind = :petKind"),
    @NamedQuery(name = "GoodHands.findByPaint", query = "SELECT g FROM GoodHands g WHERE g.paint = :paint"),
    @NamedQuery(name = "GoodHands.findBySize", query = "SELECT g FROM GoodHands g WHERE g.size = :size")})
public class GoodHands extends DtoSuperClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
    private Integer id;
    @Column(name = "where_placed", length = 2147483647)
    private String wherePlaced;
    @JoinColumn(name = "photo")
    private String photo;
    @Column(name = "special_feature", length = 2147483647)
    private String specialFeature;
    @Basic(optional = false)
    @Column(name = "pat_type", nullable = false, length = 2147483647)
    private String patType;
    @Column(name = "pet_kind", length = 2147483647)
    private String petKind;
    @Column(name = "paint", length = 2147483647)
    private String paint;
    @Column(name = "size", length = 2147483647)
    private String size;

    public GoodHands() {
    }

    public GoodHands(Integer id) {
        this.id = id;
    }

    public GoodHands(Integer id, String patType) {
        this.id = id;
        this.patType = patType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWherePlaced() {
        return wherePlaced;
    }

    public void setWherePlaced(String wherePlaced) {
        this.wherePlaced = wherePlaced;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSpecialFeature() {
        return specialFeature;
    }

    public void setSpecialFeature(String specialFeature) {
        this.specialFeature = specialFeature;
    }

    public String getPatType() {
        return patType;
    }

    public void setPatType(String patType) {
        this.patType = patType;
    }

    public String getPetKind() {
        return petKind;
    }

    public void setPetKind(String petKind) {
        this.petKind = petKind;
    }

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
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
        if (!(object instanceof GoodHands)) {
            return false;
        }
        GoodHands other = (GoodHands) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.GoodHands[id=" + id + "]";
    }

}
