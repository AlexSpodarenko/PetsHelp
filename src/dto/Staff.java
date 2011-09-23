/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.util.Collection;
import java.util.LinkedList;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author root
 */
@Entity
@Table(name = "staff")
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByStaffName", query = "SELECT s FROM Staff s WHERE s.staffName = :staffName"),
    @NamedQuery(name = "Staff.findById", query = "SELECT s FROM Staff s WHERE s.id = :id"),
    @NamedQuery(name = "Staff.findByAge", query = "SELECT s FROM Staff s WHERE s.age = :age"),
    @NamedQuery(name = "Staff.findBySalary", query = "SELECT s FROM Staff s WHERE s.salary = :salary"),
    @NamedQuery(name = "Staff.findByStaffLogin", query = "SELECT s FROM Staff s WHERE s.staffLogin = :staffLogin"),
    @NamedQuery(name = "Staff.findByStaffPassword", query = "SELECT s FROM Staff s WHERE s.staffPassword = :staffPassword"),
    @NamedQuery(name = "Staff.findByCount", query = "SELECT s FROM Staff s WHERE s.count = :count")})
public class Staff extends DtoSuperClass {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
	private Integer id;
    @Basic(optional = false)
    @Column(name = "staff_name")
    private String staffName;
    @Basic(optional = false)
    @Column(name = "age")
    private int age;
    @Basic(optional = false)
    @Column(name = "salary")
    private int salary;
    @Basic(optional = false)
    @Column(name = "staff_login")
    private String staffLogin;
    @Basic(optional = false)
    @Column(name = "staff_password")
    private String staffPassword;
    @Column(name = "count")
    private Integer count;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "staff")
    private Collection<Statemate> statemateCollection;
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "staff")
    private Collection<FindingPet> findingPetCollection;

    public Staff() {
    }

    public Staff(Integer id) {
        this.id = id;
    }

    public Staff(Integer id, String staffName, int age, int salary, String staffLogin, String staffPassword) {
        this.id = id;
        this.staffName = staffName;
        this.age = age;
        this.salary = salary;
        this.staffLogin = staffLogin;
        this.staffPassword = staffPassword;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getStaffLogin() {
        return staffLogin;
    }

    public void setStaffLogin(String staffLogin) {
        this.staffLogin = staffLogin;
    }

    public String getStaffPassword() {
        return staffPassword;
    }

    public void setStaffPassword(String staffPassword) {
        this.staffPassword = staffPassword;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Collection<Statemate> getStatemateCollection() {
    	if(statemateCollection==null)
        	statemateCollection=new LinkedList<Statemate>();
    	return statemateCollection;
    }

    public void setStatemateCollection(Collection<Statemate> statemateCollection) {
        this.statemateCollection = statemateCollection;
    }

    public Collection<FindingPet> getFindingPetCollection() {
    	 if(findingPetCollection==null)
         	findingPetCollection=new LinkedList<FindingPet>();
    	return findingPetCollection;
    }

    public void setFindingPetCollection(Collection<FindingPet> findingPetCollection) {
        this.findingPetCollection = findingPetCollection;
    }

    @Override
    public String toString() {
        return "dto.Staff[id=" + id + "]";
    }

}
