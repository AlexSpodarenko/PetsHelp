/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao.ImplJPA;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.persistence.EntityManagerFactory;

import Idao.IGoodHands;
import dto.FindingPet;
import dto.GoodHands;

/**
 *
 * @author root
 */
public class GoodHandsJpaController extends GenericDaoJpa<GoodHands> implements IGoodHands{

	public GoodHandsJpaController(EntityManagerFactory emf) {
		super(GoodHands.class, emf);
	}
	/**
	 * Метод предназначен для пополнения таблицы "добрые руки" из таблицы найденых животных в случае если они находяться 
	 * там больше 2 месяцев
	 */
	public void replenishment()
	{
		Date curD=new Date();
		Collection<FindingPet> fpCol=DaoFactory.getFindingPetDao().getAllPetWhichPlacedHearForALongTime(curD);
		Iterator<FindingPet> it=fpCol.iterator();
		while(it.hasNext())
		{	FindingPet curFp=it.next();			
			GoodHands tmp=new GoodHands();
			tmp.setPaint(curFp.getIdPet().getPaint());
			tmp.setPatType(curFp.getIdPet().getPatType());
			tmp.setPetKind(curFp.getIdPet().getSpecies());
			tmp.setPhoto(curFp.getPhoto());
			tmp.setSize(curFp.getIdPet().getPatSize());
			tmp.setSpecialFeature(curFp.getSpecialFeatures());
			tmp.setWherePlaced(curFp.getWherePlaced());			
			DaoFactory.getGoodHandsDao().save(tmp);
			DaoFactory.getFindingPetDao().delete(curFp);
		}
	}
	
	public Collection<GoodHands> getByType(String type)
	{
		String query="Select x From GoodHands x where x.patType='"+type+"'";
		return executeQuery(query, false, false);
		
	}


}
