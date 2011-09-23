/**
 * DomainSuperClass.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package dto;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

                                 //@MappedSuperclass
/**
 * Супер для для классов-доменов. От этого класса наследуються все классы домены
 */
public abstract class DtoSuperClass  implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	/** Суррогатный уникальный первичный ключ */
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id", unique=true, nullable=false)
	Integer id;

    public DtoSuperClass() {
    }

    public DtoSuperClass(
           java.lang.Integer id) {
           this.id = id;
    }


    /**
     * Gets the id value for this DomainSuperClass.
     * 
     * @return id
     */
    public java.lang.Integer getId() {
        return id;
    }


    /**
     * Sets the id value for this DomainSuperClass.
     * 
     * @param id
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    /* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!DtoSuperClass.class.isAssignableFrom(obj.getClass()))
			return false;
		DtoSuperClass other = (DtoSuperClass) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */


}
