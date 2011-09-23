/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "pet")
@NamedQueries({
    @NamedQuery(name = "Pet.findAll", query = "SELECT p FROM Pet p"),
    @NamedQuery(name = "Pet.findByPaint", query = "SELECT p FROM Pet p WHERE p.paint = :paint"),
    @NamedQuery(name = "Pet.findByAverageWeight", query = "SELECT p FROM Pet p WHERE p.averageWeight = :averageWeight"),
    @NamedQuery(name = "Pet.findById", query = "SELECT p FROM Pet p WHERE p.id = :id"),
    @NamedQuery(name = "Pet.findBySpecies", query = "SELECT p FROM Pet p WHERE p.species = :species"),
    @NamedQuery(name = "Pet.findByPatType", query = "SELECT p FROM Pet p WHERE p.patType = :patType"),
    @NamedQuery(name = "Pet.findByPatSize", query = "SELECT p FROM Pet p WHERE p.patSize = :patSize")})
public class Pet extends DtoSuperClass {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
	private Integer id;
    @Column(name = "paint")
    private String paint;
    @Column(name = "average_weight")
    private Integer averageWeight;
    @Basic(optional = false)
    @Column(name = "species")
    private String species;
    @Column(name = "pat_type")
    private String patType;
    @Column(name = "pat_size")
    private String patSize;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")	//,
    private Collection<Statemate> statemateCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "pet")	//, 
    private Collection<FindingPet> findingPetCollection;

    public Pet() {
    }

    public Pet(Integer id) {
        this.id = id;
    }

    public Pet(Integer id, String species) {
        this.id = id;
        this.species = species;
    }

    public String getPaint() {
        return paint;
    }

    public void setPaint(String paint) {
        this.paint = paint;
    }

    public Integer getAverageWeight() {
        return averageWeight;
    }

    public void setAverageWeight(Integer averageWeight) {
        this.averageWeight = averageWeight;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPatType() {
        return patType;
    }

    public void setPatType(String patType) {
        this.patType = patType;
    }

    public String getPatSize() {
        return patSize;
    }

    public void setPatSize(String patSize) {
        this.patSize = patSize;
    }

    public Collection<Statemate> getStatemateCollection() {
    	if(statemateCollection==null)
        	statemateCollection=new LinkedList<Statemate>();
    	return statemateCollection;
    }

    public void setStatemateCollection(Collection<Statemate> statemateCollection) {
        this.statemateCollection = statemateCollection;
    }
    
    public Collection<FindingPet> getFindingPetCollection() {
    	 if(findingPetCollection==null)
         	findingPetCollection=new LinkedList<FindingPet>();
    	return findingPetCollection;
    }

    public void setFindingPetCollection(Collection<FindingPet> FindingPetCollection) {
        this.findingPetCollection = FindingPetCollection;
    }

    @Override
    public String toString() {
        return "dto.Pet[id=" + id + "]";
    }

}
