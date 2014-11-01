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
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pompeu
 */
@Entity
@Table(catalog = "fxlojinha", schema = "public", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"cnpj"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByPkcliente", query = "SELECT c FROM Cliente c WHERE c.pkcliente = :pkcliente"),
    @NamedQuery(name = "Cliente.findByNomeFantasia", query = "SELECT c FROM Cliente c WHERE c.nomeFantasia = :nomeFantasia"),
    @NamedQuery(name = "Cliente.findByRazaoSocial", query = "SELECT c FROM Cliente c WHERE c.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Cliente.findByCnpj", query = "SELECT c FROM Cliente c WHERE c.cnpj = :cnpj")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer pkcliente;
    @Basic(optional = false)
    @Column(name = "nome_fantasia", nullable = false, length = 80)
    private String nomeFantasia;
    @Basic(optional = false)
    @Column(name = "razao_social", nullable = false, length = 80)
    private String razaoSocial;
    @Basic(optional = false)
    @Column(nullable = false, length = 14)
    private String cnpj;
    @JoinColumn(name = "fkendereco", referencedColumnName = "pkendereco", nullable = false)
    @ManyToOne(optional = false)
    private Endereco fkendereco;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcliente")
    private Collection<Telefone> telefoneCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcliente")
    private Collection<Endereco> enderecoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcliente")
    private Collection<Vendas> vendasCollection;

    public Cliente() {
    }

    public Cliente(Integer pkcliente) {
        this.pkcliente = pkcliente;
    }

    public Cliente(Integer pkcliente, String nomeFantasia, String razaoSocial, String cnpj) {
        this.pkcliente = pkcliente;
        this.nomeFantasia = nomeFantasia;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public Integer getPkcliente() {
        return pkcliente;
    }

    public void setPkcliente(Integer pkcliente) {
        this.pkcliente = pkcliente;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getFkendereco() {
        return fkendereco;
    }

    public void setFkendereco(Endereco fkendereco) {
        this.fkendereco = fkendereco;
    }

    @XmlTransient
    public Collection<Telefone> getTelefoneCollection() {
        return telefoneCollection;
    }

    public void setTelefoneCollection(Collection<Telefone> telefoneCollection) {
        this.telefoneCollection = telefoneCollection;
    }

    @XmlTransient
    public Collection<Endereco> getEnderecoCollection() {
        return enderecoCollection;
    }

    public void setEnderecoCollection(Collection<Endereco> enderecoCollection) {
        this.enderecoCollection = enderecoCollection;
    }

    @XmlTransient
    public Collection<Vendas> getVendasCollection() {
        return vendasCollection;
    }

    public void setVendasCollection(Collection<Vendas> vendasCollection) {
        this.vendasCollection = vendasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkcliente != null ? pkcliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.pkcliente == null && other.pkcliente != null) || (this.pkcliente != null && !this.pkcliente.equals(other.pkcliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lojinha.model.Cliente[ pkcliente=" + pkcliente + " ]";
    }
    
}
