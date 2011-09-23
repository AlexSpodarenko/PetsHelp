/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.ImplJPA;

import javax.persistence.EntityManagerFactory;

import Idao.IAdminDB;
import dto.AdminDB;

/**
 *
 * @author root
 * ДАО администраторов  
 */
public class AdminDBJpaController extends GenericDaoJpa<AdminDB> implements IAdminDB {

	public AdminDBJpaController(EntityManagerFactory emf) {
		super(AdminDB.class, emf);
	}
	
	/**
	 * Метод проверяет есть ли администратор с таким логином если есть то возвращает его
	 */
	public AdminDB testLogin(String login)
	{
		String query="Select x from AdminDB x where x.adminLogin='"+login+"'";
		Object col=this.executeQuery(query,false, true);
		if(col==null)
			return null;
		else 
			return (AdminDB)col;
	}
	/**
	 * Метод проверяет правильность введенного пароля, если пароль введен правильно то возвращает true
	 */
	
}
