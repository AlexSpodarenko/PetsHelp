/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.util.Collection;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "statemate")
@NamedQueries({
    @NamedQuery(name = "Statemate.findAll", query = "SELECT s FROM Statemate s"),
    @NamedQuery(name = "Statemate.findBySpecialFeatures", query = "SELECT s FROM Statemate s WHERE s.specialFeatures = :specialFeatures"),
    @NamedQuery(name = "Statemate.findByPhoto", query = "SELECT s FROM Statemate s WHERE s.photo = :photo"),
    @NamedQuery(name = "Statemate.findById", query = "SELECT s FROM Statemate s WHERE s.id = :id"),
    @NamedQuery(name = "Statemate.findByWeight", query = "SELECT s FROM Statemate s WHERE s.weight = :weight"),
    @NamedQuery(name = "Statemate.findByNamepat", query = "SELECT s FROM Statemate s WHERE s.namepat = :namepat"),
    @NamedQuery(name = "Statemate.findByAlreadyFinding", query = "SELECT s FROM Statemate s WHERE s.alreadyFinding = :alreadyFinding")})

   public class Statemate extends DtoSuperClass {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
	private Integer id;
    @Basic(optional = false)
    @Column(name = "special_features")
    private String specialFeatures;
    @Column(name = "photo")
    private String photo;
    @Column(name = "weight")
    private Integer weight;
    @Basic(optional = false)
    @Column(name = "namepat")
    private String namepat;
    @Column(name = "already_finding")
    private Integer alreadyFinding;
    @JoinColumn(name = "id_staff", referencedColumnName = "id")
    @ManyToOne
    private Staff staff;
    @JoinColumn(name = "id_pet", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Pet pet;
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "id_city", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private City city;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "statemate")
    private Collection<CommentsPet> commentsPetCollection;

    
    public Collection<CommentsPet> getCommentsPetCollection() {
		return commentsPetCollection;
	}

	public void setCommentsPetCollection(
			Collection<CommentsPet> commentsPetCollection) {
		this.commentsPetCollection = commentsPetCollection;
	}

	public Statemate() {
    }

    public Statemate(Integer id) {
        this.id = id;
    }

    public Statemate(Integer id,  String namepat) {
        this.id = id;       
        this.namepat = namepat;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getNamepat() {
        return namepat;
    }

    public void setNamepat(String namepat) {
        this.namepat = namepat;
    }

    public Integer getAlreadyFinding() {
        return alreadyFinding;
    }

    public void setAlreadyFinding(Integer alreadyFinding) {
        this.alreadyFinding = alreadyFinding;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "dto.Statemate[id=" + id + "]";
    }
    
    @Override
    public Integer getId()
    {
    	return id;
    }
    
    @Override
    public void setId(Integer id)
    {
    	this.id=id;
    }

}
