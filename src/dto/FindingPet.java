/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.util.Collection;
import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author root
 */
@Entity
@Table(name = "finding_pet")
@NamedQueries({
    @NamedQuery(name = "FindingPet.findAll", query = "SELECT f FROM FindingPet f"),
    @NamedQuery(name = "FindingPet.findById", query = "SELECT f FROM FindingPet f WHERE f.id = :id"),
    @NamedQuery(name = "FindingPet.findByIdPet", query = "SELECT f FROM FindingPet f WHERE f.pet = :pet"),
    @NamedQuery(name = "FindingPet.findByWherePlaced", query = "SELECT f FROM FindingPet f WHERE f.wherePlaced = :wherePlaced"),
    @NamedQuery(name = "FindingPet.findByDate", query = "SELECT f FROM FindingPet f WHERE f.date = :date"),
    @NamedQuery(name = "FindingPet.findByPhoto", query = "SELECT f FROM FindingPet f WHERE f.photo = :photo"),
    @NamedQuery(name = "FindingPet.findBySpecialFeatures", query = "SELECT f FROM FindingPet f WHERE f.specialFeatures = :specialFeatures")})
public class FindingPet extends DtoSuperClass {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
	private Integer id;	
	@JoinColumn(name = "id_pet", referencedColumnName = "id")
	@ManyToOne
    private Pet pet;
    @Column(name = "where_placed")
    private String wherePlaced;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "photo")
    private String photo;
    @Column(name = "special_features")
    private String specialFeatures;
    @JoinColumn(name = "id_staff", referencedColumnName = "id")
    @ManyToOne
    private Staff staff;
    @JoinColumn(name = "id_client", referencedColumnName = "id")
     @ManyToOne(optional = false)
    private Client client;
    @JoinColumn(name = "id_city", referencedColumnName = "id")
     @ManyToOne(optional = false)
    private City city;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "finding_pet")
    private Collection<CommentsPet> commentsPetCollection;

    
    
    public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

	public Collection<CommentsPet> getCommentsPetCollection() {
		return commentsPetCollection;
	}

	public void setCommentsPetCollection(
			Collection<CommentsPet> commentsPetCollection) {
		this.commentsPetCollection = commentsPetCollection;
	}

	public FindingPet() {
    }

    public FindingPet(Integer id) {
        this.id = id;
    }

    public FindingPet(Integer id, Pet nPet) {
        this.id = id;
        this.pet = nPet;
    }


    public Pet getIdPet() {
        return pet;
    }

    public void setIdPet(Pet nPet) {
        this.pet = nPet;
    }

    public String getWherePlaced() {
        return wherePlaced;
    }

    public void setWherePlaced(String wherePlaced) {
        this.wherePlaced = wherePlaced;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
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
        return "dto.FindingPet[id=" + id + "]";
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
