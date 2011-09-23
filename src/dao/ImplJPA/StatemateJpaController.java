/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.ImplJPA;

import java.io.File;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.commons.fileupload.FileItem;

import Idao.IStatemateDao;
import dto.Statemate;

/**
 *
 * @author root
 * Класс ДАО для работы с заявлениями о пропаже животных
 */
public class StatemateJpaController extends GenericDaoJpa<Statemate> implements IStatemateDao{

	public StatemateJpaController(EntityManagerFactory emf) {
		super(Statemate.class, emf);
	}
	
	
	public Collection<Statemate> complexFind(String name,String petType, String petSpecies, String petSize)
	{
		String Query="SELECT p,c,s FROM Pet p, City c, Statemate s  WHERE p.patType='%s' " +
				"and p.patSize='%s' and p.species='%s' and s.city=c and s.pet=p and c.cityName='%s'";
		
		return this.executeQuery(String.format(Query,petType,petSize,petSpecies,name), false, false);		
	}
	
	/**
	 * Перегруженый метод для сохранения заявления о пропаже в БД и фотографии в файловой системе
	 */
	public Statemate save(Statemate entity,FileItem fileForPhoto)  {
		if (entity == null) {
			
		}
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();

		Statemate savedEntity = null;

		try {
			if (entity.getId() == null) {
				
				String query="select max(\"statemate\".\"id\") from \"statemate\"";
				Query q=entityManager.createNativeQuery(query);
				List res=q.getResultList();			
				Integer id=(Integer)res.get(0);
				if(id==null)
					id=0;
				id=id+1;
				String name=fileForPhoto.getName();
				String extantion=fileForPhoto.getName().substring(fileForPhoto.getName().indexOf('.'));
				entity.setPhoto("images/imageS/"+id.toString()+extantion);
				entityManager.persist(entity);
				File saveF=new File("WebContent/"+entity.getPhoto());
				fileForPhoto.write(saveF);
	
			} else {			
				savedEntity = entityManager.merge(entity);
			}
			entityManager.getTransaction().commit();

		} catch (Exception e) {		
			entityManager.getTransaction().rollback();
			

		} finally {
			entityManager.close();

		}

		return savedEntity;
	}
	/**
	 * Комплексный поиск по региону,городу,типу, породе и размеру животного
	 */
	public Collection<Statemate> complexFind(String region, String city, String petType, String species, String size )
	{	String query="select x from Statemate x";
		if(!region.equals("non set"))
			query+=", City c";
		if((!petType.equals("non set"))||(!size.equals("non set")))
			query+=", Pet p";
		
		boolean addWhere=false;
		
		if(!region.equals("non set"))
		{
			if(addWhere)
			{
				query+=" and x.city=c and c.region='"+region+"'";
			}
			else
			{	addWhere=true;
				query+=" where x.city=c and c.region='"+region+"'";
			}	
		}		
		if(!city.equals("non set"))
		{
			if(addWhere)
			{
				query+=" and x.city=c and c.cityName='"+city+"'";
			}
			else
			{	addWhere=true;
				query+=" where x.city=c and c.cityName='"+city+"'";
			}	
		}
		
		if(!petType.equals("non set"))
		{
			if(addWhere)
			{
				query+=" and x.pet=p and p.patType='"+petType+"'";
			}
			else
			{	addWhere=true;
				query+=" where x.pet=p and p.patType='"+petType+"'";
			}
		}
		if(!species.equals("non set"))
		{
			if(addWhere)
			{
				query+=" and x.pet=p and p.species='"+species+"'";
			}
			else
			{	addWhere=true;
				query+=" where x.pet=p and p.species='"+species+"'";
			}	
		}
		if(!size.equals("non set"))
		{
			if(addWhere)
			{
				query+=" and x.pet=p and p.patSize='"+size+"'";
			}
			else
			{	addWhere=true;
				query+=" where x.pet=p and p.patSize='"+size+"'";
			}	
		}

		return executeQuery(query, false, false);

		}

}
