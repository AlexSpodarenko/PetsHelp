/**
 * GoodHandsInfo.java
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
public class GoodHandsInfo  implements java.io.Serializable {
    private java.lang.String paint;

    private java.lang.String patType;

    private java.lang.String petKind;

    private java.lang.String size;

    private java.lang.String specialFeature;

    private java.lang.String wherePlaced;

    public GoodHandsInfo() {
    }

    public GoodHandsInfo(
           java.lang.String paint,
           java.lang.String patType,
           java.lang.String petKind,
           java.lang.String size,
           java.lang.String specialFeature,
           java.lang.String wherePlaced) {
           this.paint = paint;
           this.patType = patType;
           this.petKind = petKind;
           this.size = size;
           this.specialFeature = specialFeature;
           this.wherePlaced = wherePlaced;
    }


    /**
     * Gets the paint value for this GoodHandsInfo.
     * 
     * @return paint
     */
    public java.lang.String getPaint() {
        return paint;
    }


    /**
     * Sets the paint value for this GoodHandsInfo.
     * 
     * @param paint
     */
    public void setPaint(java.lang.String paint) {
        this.paint = paint;
    }


    /**
     * Gets the patType value for this GoodHandsInfo.
     * 
     * @return patType
     */
    public java.lang.String getPatType() {
        return patType;
    }


    /**
     * Sets the patType value for this GoodHandsInfo.
     * 
     * @param patType
     */
    public void setPatType(java.lang.String patType) {
        this.patType = patType;
    }


    /**
     * Gets the petKind value for this GoodHandsInfo.
     * 
     * @return petKind
     */
    public java.lang.String getPetKind() {
        return petKind;
    }


    /**
     * Sets the petKind value for this GoodHandsInfo.
     * 
     * @param petKind
     */
    public void setPetKind(java.lang.String petKind) {
        this.petKind = petKind;
    }


    /**
     * Gets the size value for this GoodHandsInfo.
     * 
     * @return size
     */
    public java.lang.String getSize() {
        return size;
    }


    /**
     * Sets the size value for this GoodHandsInfo.
     * 
     * @param size
     */
    public void setSize(java.lang.String size) {
        this.size = size;
    }


    /**
     * Gets the specialFeature value for this GoodHandsInfo.
     * 
     * @return specialFeature
     */
    public java.lang.String getSpecialFeature() {
        return specialFeature;
    }


    /**
     * Sets the specialFeature value for this GoodHandsInfo.
     * 
     * @param specialFeature
     */
    public void setSpecialFeature(java.lang.String specialFeature) {
        this.specialFeature = specialFeature;
    }


    /**
     * Gets the wherePlaced value for this GoodHandsInfo.
     * 
     * @return wherePlaced
     */
    public java.lang.String getWherePlaced() {
        return wherePlaced;
    }


    /**
     * Sets the wherePlaced value for this GoodHandsInfo.
     * 
     * @param wherePlaced
     */
    public void setWherePlaced(java.lang.String wherePlaced) {
        this.wherePlaced = wherePlaced;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GoodHandsInfo)) return false;
        GoodHandsInfo other = (GoodHandsInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.paint==null && other.getPaint()==null) || 
             (this.paint!=null &&
              this.paint.equals(other.getPaint()))) &&
            ((this.patType==null && other.getPatType()==null) || 
             (this.patType!=null &&
              this.patType.equals(other.getPatType()))) &&
            ((this.petKind==null && other.getPetKind()==null) || 
             (this.petKind!=null &&
              this.petKind.equals(other.getPetKind()))) &&
            ((this.size==null && other.getSize()==null) || 
             (this.size!=null &&
              this.size.equals(other.getSize()))) &&
            ((this.specialFeature==null && other.getSpecialFeature()==null) || 
             (this.specialFeature!=null &&
              this.specialFeature.equals(other.getSpecialFeature()))) &&
            ((this.wherePlaced==null && other.getWherePlaced()==null) || 
             (this.wherePlaced!=null &&
              this.wherePlaced.equals(other.getWherePlaced())));
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
        if (getPaint() != null) {
            _hashCode += getPaint().hashCode();
        }
        if (getPatType() != null) {
            _hashCode += getPatType().hashCode();
        }
        if (getPetKind() != null) {
            _hashCode += getPetKind().hashCode();
        }
        if (getSize() != null) {
            _hashCode += getSize().hashCode();
        }
        if (getSpecialFeature() != null) {
            _hashCode += getSpecialFeature().hashCode();
        }
        if (getWherePlaced() != null) {
            _hashCode += getWherePlaced().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GoodHandsInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://dto", "GoodHandsInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("paint");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto", "paint"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("patType");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto", "patType"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("petKind");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto", "petKind"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("size");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto", "size"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("specialFeature");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto", "specialFeature"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("wherePlaced");
        elemField.setXmlName(new javax.xml.namespace.QName("http://dto", "wherePlaced"));
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
