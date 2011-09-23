package Idao;

import dto.Client;

public interface IClientDao extends IGenericDao<Client>{
	Client testLogin(String login);
}
