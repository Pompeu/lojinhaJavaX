/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pompeu
 */
@Entity
@Table(catalog = "fxlojinha", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e"),
    @NamedQuery(name = "Endereco.findByPkendereco", query = "SELECT e FROM Endereco e WHERE e.pkendereco = :pkendereco"),
    @NamedQuery(name = "Endereco.findByLogradouro", query = "SELECT e FROM Endereco e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "Endereco.findByEstado", query = "SELECT e FROM Endereco e WHERE e.estado = :estado")})
public class Endereco implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer pkendereco;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String logradouro;
    @Basic(optional = false)
    @Column(nullable = false, length = 2)
    private String estado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkendereco")
    private Collection<Cliente> clienteCollection;
    @JoinColumn(name = "fkcliente", referencedColumnName = "pkcliente", nullable = false)
    @ManyToOne(optional = false)
    private Cliente fkcliente;

    public Endereco() {
    }

    public Endereco(Integer pkendereco) {
        this.pkendereco = pkendereco;
    }

    public Endereco(Integer pkendereco, String logradouro, String estado) {
        this.pkendereco = pkendereco;
        this.logradouro = logradouro;
        this.estado = estado;
    }

    public Integer getPkendereco() {
        return pkendereco;
    }

    public void setPkendereco(Integer pkendereco) {
        this.pkendereco = pkendereco;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Cliente getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(Cliente fkcliente) {
        this.fkcliente = fkcliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkendereco != null ? pkendereco.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.pkendereco == null && other.pkendereco != null) || (this.pkendereco != null && !this.pkendereco.equals(other.pkendereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lojinha.model.Endereco[ pkendereco=" + pkendereco + " ]";
    }
    
}
