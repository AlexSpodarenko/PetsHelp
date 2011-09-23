package Idao;

import java.util.Collection;

import dto.Staff;

public interface IStaffDao extends IGenericDao<Staff>{
	Staff testLogin(String login);
	public Collection<Staff> getAllStaff();
}
