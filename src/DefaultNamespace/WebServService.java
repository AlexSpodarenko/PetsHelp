/**
 * WebServService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public interface WebServService extends javax.xml.rpc.Service {
    public java.lang.String getwebServAddress();

    public DefaultNamespace.WebServ getwebServ() throws javax.xml.rpc.ServiceException;

    public DefaultNamespace.WebServ getwebServ(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
