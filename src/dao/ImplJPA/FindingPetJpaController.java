/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.ImplJPA;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

import org.apache.commons.fileupload.FileItem;

import Idao.IFindingPetDao;
import dto.FindingPet;

/**
 *ДАО потеряных животных
 * @author root
 */
public class FindingPetJpaController extends GenericDaoJpa<FindingPet> implements IFindingPetDao{

	public FindingPetJpaController(EntityManagerFactory emf) {
		super(FindingPet.class, emf);
	}
	
	/**
	 * Перегруженый метод сохранения в базе данных, предназначен для сохранения обекта в базе
	 *  и фотографии в файловой системе и записи пути к файлу в файловой системе в соответствующую 
	 *  колонку в строчке таблицы
	 * 
	 */
	public FindingPet save(FindingPet entity,FileItem fileForPhoto) {
		if (entity == null) {
			
		}
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();

		FindingPet savedEntity = null;

		try {
			if (entity.getId() == null) {
				
				String query="select max(\"finding_pet\".\"id\") from \"finding_pet\"";
				Query q=entityManager.createNativeQuery(query);
				List res=q.getResultList();			
				Integer id=(Integer)res.get(0);
				if(id==null)
					id=0;
				id=id+1;
				String name=fileForPhoto.getName();
				String extantion=fileForPhoto.getName().substring(fileForPhoto.getName().indexOf('.'));
				entity.setPhoto("images/imageF/"+id.toString()+extantion);
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
	 * Комплексный поиск по региону , городу ,типу животного, породе и размеру
	 */
	public Collection<FindingPet> complexFind(String region, String city, String petType, String species, String size )
	{	String query="select x from FindingPet x";
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
	/**
	 * Возвращает все коллекцию id всех животных
	 */
	public Collection<Integer> getAllId()
	{
		String query="Select x from FindingPet x";
		Collection<Integer> resCol=new LinkedList<Integer>();
		Collection<FindingPet> allRec=executeQuery(query, false, false);
		Iterator<FindingPet> it=allRec.iterator();
		while(it.hasNext())
		{
			FindingPet cur=it.next();
			resCol.add(cur.getId());
		}
		return resCol;
	}
	/**
	 * возвращает коллекцию животных которые находяться в базе дольше чем 2 месяца 
	 * нужен для переноса в таблицу "в добрые руки"
	 */
	
	public Collection<FindingPet> getAllPetWhichPlacedHearForALongTime(java.util.Date criticalTime)
	{
		String query="Select x from FindingPet x";
		Collection<FindingPet> allFp=executeQuery(query, false,false);
		Iterator<FindingPet> it=allFp.iterator();
		Collection<FindingPet> resCollection=new LinkedList<FindingPet>();
		while(it.hasNext())
		{
			FindingPet cur=it.next();
			if(cur.getDate().compareTo(criticalTime)<0)
			{
				resCollection.add(cur);
			}
		}
		return resCollection;
	}


	

}
