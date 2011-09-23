package dao.ImplJPA;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import Idao.IGenericDao;
import dto.DtoSuperClass;


/**
 * Класс, реализующий все методы интерфейса {@link IGenericDao} для работы с БД,
 * используя JPA.
 * 
 * От данного класса наследуються все классы ДАО. В нем реализуються все основные операции которые должны быть 
 * реализованы во всех ДАО, а именно: сохранение, удаление, поиск по id, выборка всех элементов.
 * 
 * 
 * @param <T>
 *            Класс объектов, которые участвуют в операциях с базой данных
 */
public abstract class GenericDaoJpa<T extends DtoSuperClass> implements
		IGenericDao<T> {

	private static final String QUERY_SELECT_ALL = "SELECT x FROM %s x";

	private static final String QUERY_COUNT_ALL = "SELECT COUNT(x) FROM %s x";

	/** Entity manager factory that will be used for creating entity managers */
	protected EntityManagerFactory entityManagerFactory;

	/** Persistent class that this dao works with */
	protected Class<T> persistentClass;

	/**
	 * Constructor with fields
	 * 
	 * @param persistentClass
	 *            Class that this dao will work with
	 * @param entityManager
	 *            EntityManager to use
	 */
	public GenericDaoJpa(Class<T> persistentClass, EntityManagerFactory emf) {
		super();
		this.persistentClass = persistentClass;
		this.entityManagerFactory = emf;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ua.cn.stu.oop.example.dao.IGenericDao#delete(ua.cn.stu.oop.example.domain
	 * .DomainSuperClass)
	 */
	
	/**
	 * Удаление элемента с базы данных
	 */
	public void delete(T entity) throws PersistenceException {
		// Checking for null parameters
		if (entity == null) {
			throw new PersistenceException(
					"Entity for deleting cannot be null!");
		}

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		entityManager.getTransaction().begin();

		try {
			T savedEntity = entityManager.find(persistentClass, entity.getId());
			entityManager.remove(savedEntity);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new PersistenceException(e);

		} finally {
			entityManager.close();

		}
	}
	
	
	public void delete(Integer entityId) throws PersistenceException {
		delete(findById(entityId));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.cn.stu.oop.example.dao.IGenericDao#findAll()
	 */
	public Collection<T> findAll() throws PersistenceException {
		return executeQuery(String.format(QUERY_SELECT_ALL, persistentClass.getSimpleName()), false, false);
	}
	
	/* (non-Javadoc)
	 * @see ua.cn.stu.oop.example.dao.IGenericDao#getAllCount()
	 */
	public Long getAllCount() throws PersistenceException {
		return executeQuery(String.format(QUERY_COUNT_ALL, persistentClass.getSimpleName()), false, true);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ua.cn.stu.oop.example.dao.IGenericDao#findById(java.lang.Integer)
	 */
	public T findById(Integer id) throws PersistenceException {
		if (id == null) {
			throw new PersistenceException(
					"Entity id for getting cannot be null!");
		}

		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();
		
		T savedEntity = null;

		try {
			savedEntity = entityManager.find(persistentClass, id);
			entityManager.getTransaction().commit();
			
		} catch (Exception e) {
			entityManager.getTransaction().rollback();
			throw new PersistenceException(e);

		} finally {
			entityManager.close();
		}

		return savedEntity;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ua.cn.stu.oop.example.dao.IGenericDao#save(ua.cn.stu.oop.example.domain
	 * .DomainSuperClass)
	 * Сохраняет обект в базе данных
	 */
	public T save(T entity) throws PersistenceException {
		if (entity == null) {
			throw new PersistenceException("Entity for saving cannot be null!");
		}
		EntityManager entityManager = entityManagerFactory
				.createEntityManager();
		entityManager.getTransaction().begin();

		T savedEntity = null;

		try {
			if (entity.getId() == null) {
				entityManager.persist(entity);
				savedEntity = entity;
			} else {			
				savedEntity = entityManager.merge(entity);
			}
			entityManager.getTransaction().commit();

		} catch (Exception e) {		
			entityManager.getTransaction().rollback();
			throw new PersistenceException(e);

		} finally {
			entityManager.close();

		}

		return savedEntity;
	}

	/**
	 * <p>
	 * This template method executes query with performing all needed
	 * operations, like creating EntityManager, creating transaction,
	 * committing, or rolling it back.
	 * </p>
	 * <p>
	 * Methods sets parameters for the query as they appear in the parameters
	 * list, by number starting from 1. So, the first parameter in your named
	 * query should be referenced as <code>?1</code>, second as <code>?2</code>
	 * and so on.
	 * </p>
	 * <p>
	 * If <code>singleResult = true</code> and no result is found, then
	 * <code>null</code> is returned.
	 * </p>
	 * <p>
	 * Be aware, that when multiple results are returned, they are being
	 * dynamically casted to <code>REZ</code> class. It should be able to cast
	 * to {@link java.util.List}. When returning single result, <code>REZ</code>
	 * should be a single persistent entity class.
	 * </p>
	 * 
	 * @param <REZ>
	 *            Class of the result
	 * @param queryOrQueryName
	 *            Query string or NamedQuery name
	 * @param namedQuery
	 * 			  Specifies, whether query is named query
	 * @param singleResult
	 *            Specifies, whether single result should be returned
	 * @param parameters
	 *            Parameters. You can specify multiple parameters separated by comma
	 * @return Result of the query
	 * @throws PersistenceException
	 *             If error occurs
	 *             
	 *             Метода предназначен для выполнинея SQL запрсов к базе данных из классов ДАО которые 
	 *             будут наследоваться от данного класса
	 */
	@SuppressWarnings("unchecked")
	protected <REZ> REZ executeQuery(String queryOrQueryName,
			boolean namedQuery, boolean singleResult, Object... parameters)
			throws PersistenceException {

		// Creating entity manager to work with entity
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		// Begin a new local transaction so that we can persist a new entity
		entityManager.getTransaction().begin();

		REZ result;

		try {

			Query q;
			
			// Creating either named or simple query
			if (namedQuery) {
				q = entityManager.createNamedQuery(queryOrQueryName);
			} else {
				q = entityManager.createQuery(queryOrQueryName);
			}

			for (int i = 0; i < parameters.length; i++) {
				q.setParameter(i+1, parameters[i]);
			}
			if (singleResult) {
				
				List<?> list = q.getResultList();
				if (!list.isEmpty()) {
					result = (REZ) list.get(0);
				} else {
					result = null;
				}

			} else {

				result = (REZ) q.getResultList();

			}
			entityManager.getTransaction().commit();

		} catch (Exception e) {

			entityManager.getTransaction().rollback();

			throw new PersistenceException(e);

		} finally {

			entityManager.close();

		}

		return result;
	}

}
