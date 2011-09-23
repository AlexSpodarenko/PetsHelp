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
@Table(name = "client")
@NamedQueries({
    @NamedQuery(name = "Client.findAll", query = "SELECT c FROM Client c"),
    @NamedQuery(name = "Client.findByClientName", query = "SELECT c FROM Client c WHERE c.clientName = :clientName"),
    @NamedQuery(name = "Client.findById", query = "SELECT c FROM Client c WHERE c.id = :id"),
    @NamedQuery(name = "Client.findByTelephone", query = "SELECT c FROM Client c WHERE c.telephone = :telephone"),
    @NamedQuery(name = "Client.findByClientLogin", query = "SELECT c FROM Client c WHERE c.clientLogin = :clientLogin"),
    @NamedQuery(name = "Client.findByClientPassword", query = "SELECT c FROM Client c WHERE c.clientPassword = :clientPassword"),
    @NamedQuery(name = "Client.findByEMail", query = "SELECT c FROM Client c WHERE c.eMail = :eMail")})
public class Client extends DtoSuperClass {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id",unique=true, nullable=false)
	private Integer id;
	
    @Basic(optional = false)
    @Column(name = "client_name")
    private String clientName;
    @Column(name = "telephone")
    private String telephone;
    @Basic(optional = false)
    @Column(name = "client_login")
    private String clientLogin;
    @Basic(optional = false)
    @Column(name = "client_password")
    private String clientPassword;
    @Column(name = "e_mail")
    private String eMail;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Collection<Statemate> statemateCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Collection<FindingPet> findingPetCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "client")
    private Collection<CommentsPet> commentsPetCollection;
    
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Collection<CommentsPet> getCommentsPetCollection() {
		return commentsPetCollection;
	}

	public void setCommentsPetCollection(Collection<CommentsPet> commentsPetCollection) {
		this.commentsPetCollection = commentsPetCollection;
	}

	public Client() {
    }

    public Client(Integer id) {
        this.id = id;
    }

    public Client(Integer id, String clientName, String clientLogin, String clientPassword) {
        this.id = id;
        this.clientName = clientName;
        this.clientLogin = clientLogin;
        this.clientPassword = clientPassword;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getClientLogin() {
        return clientLogin;
    }

    public void setClientLogin(String clientLogin) {
        this.clientLogin = clientLogin;
    }

    public String getClientPassword() {
        return clientPassword;
    }

    public void setClientPassword(String clientPassword) {
        this.clientPassword = clientPassword;
    }

    public String getEMail() {
        return eMail;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
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
        return "dto.Client[id=" + id + "]";
    }

}
