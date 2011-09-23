/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.ImplJPA;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import javax.persistence.EntityManagerFactory;

import Idao.ICityDao;
import dto.City;

/**
 *
 * @author root
 * ДАО для городов
 */
public class CityJpaController extends GenericDaoJpa<City> implements ICityDao{

	public CityJpaController(EntityManagerFactory emf) {
		super(City.class, emf);
	}
	/**
	 * Возвращает колекцию строк - имен городов которые есть в базе. Если есть города с одинаковыми именами то
	 * возвращает имя только в одном экземпляре
	 */
	public Collection<String> getAllCityName()
	{
		Collection<City> col=findAll();
		Collection<String> res=new LinkedList<String>();
		Iterator<City> it=col.iterator();
		while(it.hasNext())
		{	City tmp=it.next();
			if(!res.contains(tmp.getCityName()))
			{
				res.add(tmp.getCityName());
			}
		}
		return res;
	}
	/**
	 * Возвращает колекцию строк - имен регионов которые есть в базе. Если есть регионы с одинаковыми именами то
	 * возвращает имя только в одном экземпляре
	 */
	public Collection<String> getAllRegion()
	{
		Collection<City> col=findAll();
		Collection<String> res=new LinkedList<String>();
		Iterator<City> it=col.iterator();
		while(it.hasNext())
		{	City tmp=it.next();
			if(!res.contains(tmp.getRegion()))
			{
				res.add(tmp.getRegion());
			}
		}
		return res;
	}
	
	/**
	 * возвращает все города с заданым именем
	 */
	public Collection<City> getByName(String cityName)
	{	String query="Select x from City x where x.cityName="+"'"+cityName+"'";
		return executeQuery(query, false, false);
	}
	

	/**
	 * возвращает все города с что находяться в данной области
	 */
	public Collection<City> getByRegion(String region)
	{
		String query="Select x from City x where x.region="+"'"+region+"'";
		return executeQuery(query, false, false);
	}
	
	/**
	 * Возвращает город по указаному имени городу и области
	 */
	public City findByNameAndRegion(String name, String region)
	{
		String query="select x from City x where x.cityName="+"'"+name+"'"+" and x.region="+"'"+region+"'";
		return executeQuery(query, false, true);
	}
	
	
}
