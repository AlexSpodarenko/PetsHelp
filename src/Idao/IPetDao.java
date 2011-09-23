package Idao;

import java.util.Collection;

import dto.Pet;

public interface IPetDao extends IGenericDao<Pet>{

	public Collection<String> getAllPetType();
	public Collection<String> getAllPetSpecies();
	public Collection<String> getAllPetSize();
	public Collection<Pet> getByType(String type);
	public Collection<Pet> getSpeciesByType(String type);
	public Pet getByTypeAndSpecies(String type,String species);
	public Collection<Pet> getByCityNameAndRegion(String region, String city);
}
