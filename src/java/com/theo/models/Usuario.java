/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.theo.models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author theo
 */
@Entity
@Table(name = "usuario", catalog = "test", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")
    , @NamedQuery(name = "Usuario.findByUsuIde", query = "SELECT u FROM Usuario u WHERE u.usuIde = :usuIde")
    , @NamedQuery(name = "Usuario.findByUsername", query = "SELECT u FROM Usuario u WHERE u.username = :username")
    , @NamedQuery(name = "Usuario.findByPassword", query = "SELECT u FROM Usuario u WHERE u.password = :password")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usu_ide")
    private Integer usuIde;
    @Column(name = "username")
    private String username;
    @Column(name = "password")
    private String password;

    public Usuario() {
    }

    public Usuario(Integer usuIde) {
        this.usuIde = usuIde;
    }

    public Integer getUsuIde() {
        return usuIde;
    }

    public void setUsuIde(Integer usuIde) {
        this.usuIde = usuIde;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuIde != null ? usuIde.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usuIde == null && other.usuIde != null) || (this.usuIde != null && !this.usuIde.equals(other.usuIde))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.theo.models.Usuario[ usuIde=" + usuIde + " ]";
    }
    
}
