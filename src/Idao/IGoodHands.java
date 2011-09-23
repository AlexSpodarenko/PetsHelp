package Idao;

import java.util.Collection;

import dto.GoodHands;

public interface IGoodHands extends IGenericDao<GoodHands>{
	public void replenishment();
	public Collection<GoodHands> getByType(String type);
}
