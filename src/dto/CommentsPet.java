/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author root
 */
@Entity
@Table(name = "commentsPet")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CommentsPet.findAll", query = "SELECT c FROM CommentsPet c"),
    @NamedQuery(name = "CommentsPet.findById", query = "SELECT c FROM CommentsPet c WHERE c.id = :id"),
    @NamedQuery(name = "CommentsPet.findByCommentText", query = "SELECT c FROM CommentsPet c WHERE c.commentText = :commentText")})
public class CommentsPet extends DtoSuperClass {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "commentText")
    private String commentText;
    @JoinColumn(name = "id_statemate", referencedColumnName = "id")
    @ManyToOne
    private Statemate statemate;
    @JoinColumn(name = "id_finding_pet", referencedColumnName = "id")
    @ManyToOne
    private FindingPet finding_pet;
    @JoinColumn(name = "id_client", referencedColumnName = "id")
    @ManyToOne
    private Client client;

    public CommentsPet() {
    }

    public CommentsPet(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public Statemate getIdStatemate() {
        return statemate;
    }

    public void setIdStatemate(Statemate idStatemate) {
        this.statemate = idStatemate;
    }

    public FindingPet getIdFindingPet() {
        return finding_pet;
    }

    public void setIdFindingPet(FindingPet idFindingPet) {
        this.finding_pet = idFindingPet;
    }

    public Client getIdClient() {
        return client;
    }

    public void setIdClient(Client idClient) {
        this.client = idClient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CommentsPet)) {
            return false;
        }
        CommentsPet other = (CommentsPet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.CommentsPet[ id=" + id + " ]";
    }
    
}
