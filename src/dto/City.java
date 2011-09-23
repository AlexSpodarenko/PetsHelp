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
@Table(name = "city")
@NamedQueries({
    @NamedQuery(name = "City.findAll", query = "SELECT c FROM City c"),
    @NamedQuery(name = "City.findById", query = "SELECT c FROM City c WHERE c.id = :id"),
    @NamedQuery(name = "City.findByPopulation", query = "SELECT c FROM City c WHERE c.population = :population"),
    @NamedQuery(name = "City.findByMaire", query = "SELECT c FROM City c WHERE c.maire = :maire"),
    @NamedQuery(name = "City.findByCityName", query = "SELECT c FROM City c WHERE c.cityName = :cityName")})
public class City extends DtoSuperClass {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
	private Integer id;
    @Basic(optional = false)
    @Column(name = "population")
    private int population;
    @Basic(optional = false)
    @Column(name = "region")
    private String region;
    @Basic(optional = false)
    @Column(name = "maire")
    private String maire;
    @Basic(optional = false)
    @Column(name = "city_name")
    private String cityName;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "city")
    private Collection<Statemate> statemateCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "city")
    private Collection<FindingPet> findingPetCollection;

    public City() {
    }

    public City(Integer id) {
        this.id = id;
    }

    public City(Integer id, int population, String maire, String cityName) {
        this.id = id;
        this.population = population;
        this.maire = maire;
        this.cityName = cityName;
    }

 
    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getMaire() {
        return maire;
    }

    public void setMaire(String maire) {
        this.maire = maire;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
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

    public void setFindingPetCollection(Collection<FindingPet> findingPetCollection) {
        this.findingPetCollection = findingPetCollection;
    }


    @Override
    public String toString() {
        return "dto.City[id=" + id + "]";
    }

}
