/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.ImplJPA;

import javax.persistence.EntityManagerFactory;

import Idao.IClientDao;
import dto.Client;

/**
 *
 * @author root
 * ДАО для клиентов
 */
public class ClientJpaController extends GenericDaoJpa<Client> implements IClientDao{

	public ClientJpaController(EntityManagerFactory emf) {
		super(Client.class, emf);
	}
	/**
	 * Проверяет есть ли клиент с заданым логином, если есть то возвращат его
	 */
	public Client testLogin(String login)
	{
		String query="Select x from Client x where x.clientLogin=%s";
		Object col=this.executeQuery(String.format(query,"'"+login+"'"),false, true);
		if(col==null)
			return null;
		else 
			return (Client)col;
	}
	/**
	 * Проверяет правильно ли введен пароль для данного клиента
	 */


}
