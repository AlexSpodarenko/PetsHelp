/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.ImplJPA;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.persistence.EntityManagerFactory;

import Idao.IPetDao;
import dto.Pet;

/**
 *
 * @author root
 */
public class PetJpaController extends GenericDaoJpa<Pet> implements IPetDao{

	public PetJpaController(EntityManagerFactory emf) {
		super(Pet.class, emf);
	}
	/**
	 * Возвращает колекцию характеристик всех типов и пород животных что есть в базе 
	 */
	public Collection<String> getAllPetType()
	{
		Collection<Pet> col=findAll();
		Collection<String> res=new LinkedList<String>();
		Iterator<Pet> it=col.iterator();
		while(it.hasNext())
		{	Pet tmp=it.next();
			if(!res.contains(tmp.getPatType()))
			{
				res.add(tmp.getPatType());
			}
		}
		return res;
	}
	
	/**
	 * Возвращает список всех пород животных что есть в базе
	 */
	public Collection<String> getAllPetSpecies()
	{
		Collection<Pet> col=findAll();
		Collection<String> res=new LinkedList<String>();
		Iterator<Pet> it=col.iterator();
		while(it.hasNext())
		{	Pet tmp=it.next();
			if(!res.contains(tmp.getSpecies()))
			{
				res.add(tmp.getSpecies());
			}
		}
		return res;
	}

	@Override
	public Collection<String> getAllPetSize() {
		Collection<Pet> col=findAll();
		Collection<String> res=new LinkedList<String>();
		Iterator<Pet> it=col.iterator();
		while(it.hasNext())
		{	Pet tmp=it.next();
			if(!res.contains(tmp.getPatSize()))
			{
				res.add(tmp.getPatSize());
			}
		}
		return res;
	}
	/**
	 * Возвращает породу животного по id
	 */
	public Collection<Pet> getSpeciesByType(String type) {
		String query="Select x from Pet x where x.patType="+"'"+type+"'";
		return executeQuery(query, false, false);
		
	}
	
	public Collection<Pet> getByType(String type)
	{
		String query="Select x from Pet x where x.patType="+"'"+type+"'";
		return executeQuery(query, false, false);
	}
	
	public Pet getByTypeAndSpecies(String type,String species)
	{
		String query="select x from Pet x where x.patType="+"'"+type+"'"+" and x.species="+"'"+species+"'";
		return executeQuery(query, false, true);
	}
	
	public Collection<Pet> getByCityNameAndRegion(String region, String city)
	{
		String query="select p from Pet p,City c,FindingPet f where f.city=c and f.pet=p and c.region='"+region+"' and c.cityName='"+city+"'";
		return executeQuery(query, false, false);
	}
	

}
