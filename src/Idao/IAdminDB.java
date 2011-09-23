package Idao;

import dto.AdminDB;

public interface IAdminDB extends IGenericDao<AdminDB>{
	
	public AdminDB testLogin(String login);
}
