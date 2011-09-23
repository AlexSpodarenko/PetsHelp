/**
 * StaffInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package dto;
/**
 * Класс нужен для работы с вэб-сервисом. Вэб-сервис отдает клиентской программе колекцию обектов именно этого класса.
 * Клиентская программа может использовать информацию взятую из атрибутов обектов этого класса.
 * @author corwin
 *
 */
public class StaffInfo  implements java.io.Serializable {
    private int age;

    private java.lang.Integer count;

    private int salary;

    private java.lang.String staffLogin;

    private java.lang.String staffName;

    public StaffInfo() {
    }

    public StaffInfo(
           int age,
           java.lang.Integer count,
           int salary,
           java.lang.String staffLogin,
           java.lang.String staffName) {
           this.age = age;
           this.count = count;
           this.salary = salary;
           this.staffLogin = staffLogin;
           this.staffName = staffName;
    }


    /**
     * Gets the age value for this StaffInfo.
     * 
     * @return age
     */
    public int getAge() {
        return age;
    }


    /**
     * Sets the age value for this StaffInfo.
     * 
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }


    /**
     * Gets the count value for this StaffInfo.
     * 
     * @return count
     */
    public java.lang.Integer getCount() {
        return count;
    }


    /**
     * Sets the count value for this StaffInfo.
     * 
     * @param count
     */
    public void setCount(java.lang.Integer count) {
        this.count = count;
    }


    /**
     * Gets the salary value for this StaffInfo.
     * 
     * @return salary
     */
    public int getSalary() {
        return salary;
    }


    /**
     * Sets the salary value for this StaffInfo.
     * 
     * @param salary
     */
    public void setSalary(int salary) {
        this.salary = salary;
    }


    /**
     * Gets the staffLogin value for this StaffInfo.
     * 
     * @return staffLogin
     */
    public java.lang.String getStaffLogin() {
        return staffLogin;
    }


    /**
     * Sets the staffLogin value for this StaffInfo.
     * 
     * @param staffLogin
     */
    public void setStaffLogin(java.lang.String staffLogin) {
        this.staffLogin = staffLogin;
    }


    /**
     * Gets the staffName value for this StaffInfo.
     * 
     * @return staffName
     */
    public java.lang.String getStaffName() {
        return staffName;
    }


    /**
     * Sets the staffName value for this StaffInfo.
     * 
     * @param staffName
     */
    public void setStaffName(java.lang.String staffName) {
        this.staffName = staffName;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof StaffInfo)) return false;
        StaffInfo other = (StaffInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            this.age == other.getAge() &&
            ((this.count==null && other.getCount()==null) || 
             (this.count!=null &&
              this.count.equals(other.getCount()))) &&
            this.salary == other.getSalary() &&
            ((this.staffLogin==null && other.getStaffLogin()==null) || 
             (this.staffLogin!=null &&
              this.staffLogin.equals(other.getStaffLogin()))) &&
            ((this.staffName==null && other.getStaffName()==null) || 
             (this.staffName!=null &&
              this.staffName.equals(other.getStaffName())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        _hashCode += getAge();
        if (getCount() != null) {
            _hashCode += getCount().hashCode();
        }
        _hashCode += getSalary();
        if (getStaffLogin() != null) {
            _hashCode += getStaffLogin().hashCode();
        }
        if (getStaffName() != null) {
            _hashCode += getStaffName().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(StaffInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto", "StaffInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("age");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto", "age"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("count");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto", "count"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("salary");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto", "salary"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("staffLogin");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto", "staffLogin"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("staffName");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto", "staffName"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
