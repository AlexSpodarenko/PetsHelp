package Idao;

import java.util.Collection;

import javax.persistence.PersistenceException;

import org.apache.commons.fileupload.FileItem;

import dto.Statemate;

public interface IStatemateDao extends IGenericDao<Statemate>{

	public Collection<Statemate> complexFind(String region, String city, String petType, String species, String size );
	public Statemate save(Statemate entity,FileItem fileForPhoto) throws PersistenceException;
}
