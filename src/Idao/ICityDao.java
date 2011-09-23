package Idao;

import java.util.Collection;

import dto.City;

public interface ICityDao extends IGenericDao<City>{
	public  Collection<String> getAllCityName();
	public Collection<City> getByName(String cityName);
	public Collection<City> getByRegion(String region);
	public Collection<String> getAllRegion();
	public City findByNameAndRegion(String name, String region);
}
