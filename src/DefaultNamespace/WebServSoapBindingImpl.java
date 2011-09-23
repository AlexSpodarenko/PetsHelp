/**
 * WebServSoapBindingImpl.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

import java.util.Collection;
import java.util.Iterator;

import dao.ImplJPA.DaoFactory;
import dto.GoodHands;
import dto.GoodHandsInfo;
import dto.Staff;
import dto.StaffInfo;

public class WebServSoapBindingImpl implements DefaultNamespace.WebServ{
   
	public dto.GoodHandsInfo[] getGoodHandsList(java.lang.String petType) throws java.rmi.RemoteException {
    	Collection<GoodHands> col=DaoFactory.getGoodHandsDao().getByType(petType);
		Iterator<GoodHands> it=col.iterator();
		GoodHandsInfo[] resArr=new GoodHandsInfo[col.size()];
		int i=0;
		while(it.hasNext())
		{
			GoodHands tmp=it.next();
			GoodHandsInfo newinf=new GoodHandsInfo();
			newinf.setPaint(tmp.getPaint());
			newinf.setPatType(tmp.getPatType());
			newinf.setPetKind(tmp.getPetKind());
			newinf.setSize(tmp.getSize());
			newinf.setSpecialFeature(tmp.getSpecialFeature());
			newinf.setWherePlaced(tmp.getWherePlaced());
			resArr[i]=newinf;
			i++;
		}
		return resArr;
    }

    public dto.StaffInfo[] getStaffList() throws java.rmi.RemoteException {
    	Collection<Staff> col=DaoFactory.getStaffDao().findAll();
		Iterator<Staff> it=col.iterator();
		StaffInfo[] resArr=new StaffInfo[col.size()];
		int i=0;
		while(it.hasNext())
		{
			Staff tmp=it.next();
			StaffInfo newinf=new StaffInfo();
			newinf.setAge(tmp.getAge());
			newinf.setCount(tmp.getCount());
			newinf.setSalary(tmp.getSalary());
			newinf.setStaffLogin(tmp.getStaffLogin());
			newinf.setStaffName(tmp.getStaffName());
			resArr[i]=newinf;
			i++;
		}
		return resArr;
    }

}
