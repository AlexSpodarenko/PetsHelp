package dao.ImplJPA;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import Idao.IAdminDB;
import Idao.ICityDao;
import Idao.IClientDao;
import Idao.ICommentsPet;
import Idao.IFindingPetDao;
import Idao.IGoodHands;
import Idao.IPetDao;
import Idao.IStaffDao;
import Idao.IStatemateDao;

/**
 * класс фабрика предназначен для подключения к базе данных и создания обектов ДАО
 * подключение создаеться из propertis файла
 * @author corwin
 *
 */

public abstract class DaoFactory {
	
	static ICityDao cityD=null;
	static IPetDao petD=null;
	static IClientDao clientD=null;
	static IStaffDao staffD=null;
	static IFindingPetDao findingD=null;
	static IStatemateDao statemateD=null;
	static IAdminDB adminD=null;
	static IGoodHands goodHandD=null;
	static ICommentsPet comments=null;
	static EntityManagerFactory emf=null;
	
	
	
	
	static{
		/*InputStream iss=DaoFactory.class.getResourceAsStream("./DAOProperties.txt");
		Properties props=new Properties();
		try {
			props.load(iss);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	*/
		Properties props=new Properties();
		props.put("openjpa.ConnectionUserName", "postgres");
		props.put("openjpa.ConnectionPassword", "Satareal");
		props.put("openjpa.ConnectionDriverName", "org.postgresql.Driver");
		props.put("openjpa.ConnectionURL", "jdbc:postgresql://localhost:5433/PatsBD");
		props.put("openjpa.jdbc.SynchronizeMappings", "buildSchema");
		emf=Persistence.createEntityManagerFactory("exportDAOPU", props);
	}
	
	
	public static ICityDao getCityDao()
	{
		if(cityD==null)
			cityD=(ICityDao) new CityJpaController(emf);
		return cityD;
	}
	
	public static IPetDao getPetDao()
	{
		if(petD==null)
			petD=(IPetDao) new PetJpaController(emf);
		return petD;
	}
	
	public static IClientDao getClientDao()
	{
		if(clientD==null)
			clientD=(IClientDao) new ClientJpaController(emf);	
		return clientD;
	}
	
	public static IStatemateDao getStatemateDao()
	{ if(statemateD==null)
		statemateD=(IStatemateDao) new StatemateJpaController(emf);
	return statemateD;
	}
	
	public static IFindingPetDao getFindingPetDao()
	{
		if(findingD==null)
			findingD=(IFindingPetDao) new FindingPetJpaController(emf);
		return findingD;
	}
	
	public static ICommentsPet getCommentsDao()
	{
		if(comments==null)
			comments=(ICommentsPet) new CommentsPetJpaController(emf);
		return comments;
	}
	
	
	public static IStaffDao getStaffDao()
	{ if(staffD==null)
		staffD=(IStaffDao) new StaffJpaController(emf);
	return staffD;
	}
	
	public static IAdminDB getAdminDao()
	{ if(adminD==null)
		adminD=(IAdminDB)new AdminDBJpaController(emf);
	return adminD;
	}
	
	public static IGoodHands getGoodHandsDao()
	{ if(goodHandD==null)
		goodHandD=(IGoodHands) new GoodHandsJpaController(emf);
	return goodHandD;
	}
		
}
