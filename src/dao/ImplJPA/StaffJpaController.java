/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.ImplJPA;

import java.util.Collection;

import javax.persistence.EntityManagerFactory;

import Idao.IStaffDao;
import dto.Staff;

/**
 *
 * @author root
 * Класс ДАО для работы с сотрудниками
 */
public class StaffJpaController extends GenericDaoJpa<Staff> implements IStaffDao{

	public StaffJpaController(EntityManagerFactory emf) {
		super(Staff.class, emf);
	}
	
	public Staff testLogin(String login)
	{
		String query="Select x from Staff x where x.staffLogin=%s";
		Object col=this.executeQuery(String.format(query,"'"+login+"'"),false, true);
		if(col==null)
			return null;
		else 
			return (Staff)col;
	}
	

	
	public Collection<Staff> getAllStaff()
	{
		String query="Select x from Staff x";
		return executeQuery(query, false, false);
	}

}
