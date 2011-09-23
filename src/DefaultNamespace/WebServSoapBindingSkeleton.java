/**
 * WebServSoapBindingSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package DefaultNamespace;

public class WebServSoapBindingSkeleton implements DefaultNamespace.WebServ, org.apache.axis.wsdl.Skeleton {
    private DefaultNamespace.WebServ impl;
    private static java.util.Map _myOperations = new java.util.Hashtable();
    private static java.util.Collection _myOperationsList = new java.util.ArrayList();

    /**
    * Returns List of OperationDesc objects with this name
    */
    public static java.util.List getOperationDescByName(java.lang.String methodName) {
        return (java.util.List)_myOperations.get(methodName);
    }
 
    /**
    * Returns Collection of OperationDescs
    */
    public static java.util.Collection getOperationDescs() {
        return _myOperationsList;
    }

    static {
        org.apache.axis.description.OperationDesc _oper;
        org.apache.axis.description.FaultDesc _fault;
        org.apache.axis.description.ParameterDesc [] _params;
        _params = new org.apache.axis.description.ParameterDesc [] {
            new org.apache.axis.description.ParameterDesc(new javax.xml.namespace.QName("http://DefaultNamespace", "petType"), org.apache.axis.description.ParameterDesc.IN, new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"), java.lang.String.class, false, false), 
        };
        _oper = new org.apache.axis.description.OperationDesc("getGoodHandsList", _params, new javax.xml.namespace.QName("http://DefaultNamespace", "getGoodHandsListReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dto", "GoodHandsInfo"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://DefaultNamespace", "getGoodHandsList"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getGoodHandsList") == null) {
            _myOperations.put("getGoodHandsList", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getGoodHandsList")).add(_oper);
        _params = new org.apache.axis.description.ParameterDesc [] {
        };
        _oper = new org.apache.axis.description.OperationDesc("getStaffList", _params, new javax.xml.namespace.QName("http://DefaultNamespace", "getStaffListReturn"));
        _oper.setReturnType(new javax.xml.namespace.QName("http://dto", "StaffInfo"));
        _oper.setElementQName(new javax.xml.namespace.QName("http://DefaultNamespace", "getStaffList"));
        _oper.setSoapAction("");
        _myOperationsList.add(_oper);
        if (_myOperations.get("getStaffList") == null) {
            _myOperations.put("getStaffList", new java.util.ArrayList());
        }
        ((java.util.List)_myOperations.get("getStaffList")).add(_oper);
    }

    public WebServSoapBindingSkeleton() {
        this.impl = new DefaultNamespace.WebServSoapBindingImpl();
    }

    public WebServSoapBindingSkeleton(DefaultNamespace.WebServ impl) {
        this.impl = impl;
    }
    public dto.GoodHandsInfo[] getGoodHandsList(java.lang.String petType) throws java.rmi.RemoteException
    {
        dto.GoodHandsInfo[] ret = impl.getGoodHandsList(petType);
        return ret;
    }

    public dto.StaffInfo[] getStaffList() throws java.rmi.RemoteException
    {
        dto.StaffInfo[] ret = impl.getStaffList();
        return ret;
    }

}
