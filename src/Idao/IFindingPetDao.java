package Idao;

import java.util.Collection;

import javax.persistence.PersistenceException;

import org.apache.commons.fileupload.FileItem;

import dto.FindingPet;

public interface IFindingPetDao extends IGenericDao<FindingPet>{

	public Collection<FindingPet> complexFind(String region, String city, String petType, String species, String size );
	public FindingPet save(FindingPet entity,FileItem fileForPhoto) throws PersistenceException;
	public Collection<Integer> getAllId();
	public Collection<FindingPet> getAllPetWhichPlacedHearForALongTime(java.util.Date curD);
}
