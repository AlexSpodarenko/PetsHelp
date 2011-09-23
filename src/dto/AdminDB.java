/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author corwin
 */
@Entity
@Table(name = "admindb")
@NamedQueries({
    @NamedQuery(name = "AdminDB.findAll", query = "SELECT a FROM AdminDB a")})
public class AdminDB extends DtoSuperClass implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "admin_login", nullable = false, length = 2147483647)
    private String adminLogin;
    @Basic(optional = false)
    @Column(name = "admin_password", nullable = false, length = 2147483647)
    private String adminPassword;

    public AdminDB() {
    }

    public AdminDB(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public AdminDB(String adminLogin, String adminPassword) {
        this.adminLogin = adminLogin;
        this.adminPassword = adminPassword;
    }

    public String getAdminLogin() {
        return adminLogin;
    }

    public void setAdminLogin(String adminLogin) {
        this.adminLogin = adminLogin;
    }

    public String getAdminPasswod() {
        return adminPassword;
    }

    public void setAdminPasswod(String adminPasswod) {
        this.adminPassword = adminPasswod;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminLogin != null ? adminLogin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminDB)) {
            return false;
        }
        AdminDB other = (AdminDB) object;
        if ((this.adminLogin == null && other.adminLogin != null) || (this.adminLogin != null && !this.adminLogin.equals(other.adminLogin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dto.AdminDB[adminLogin=" + adminLogin + "]";
    }

}
