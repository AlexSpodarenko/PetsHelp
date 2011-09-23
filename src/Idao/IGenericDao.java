package Idao;

import java.util.Collection;

import javax.persistence.PersistenceException;

import dto.DtoSuperClass;
/**
 * 
 * @author corwin
 *
 * @param <T>
 */


public interface IGenericDao<T extends DtoSuperClass> {
	
	void delete(Integer entityId) throws PersistenceException;
	
	void delete(T entity) throws PersistenceException;

	Collection<T> findAll() throws PersistenceException;
	
	Long getAllCount() throws PersistenceException;
	
	T findById(Integer id) throws PersistenceException;
     
	T save(T entity) throws PersistenceException;

}
