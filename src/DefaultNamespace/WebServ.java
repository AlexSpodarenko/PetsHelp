/**
 * WebServ.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface WebServ extends java.rmi.Remote {
    public dto.GoodHandsInfo[] getGoodHandsList(java.lang.String petType) throws java.rmi.RemoteException;
    public dto.StaffInfo[] getStaffList() throws java.rmi.RemoteException;
}
