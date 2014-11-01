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
    @NamedQuery(name = "Fornecedores.findAll", query = "SELECT f FROM Fornecedores f"),
    @NamedQuery(name = "Fornecedores.findByPkfornecedores", query = "SELECT f FROM Fornecedores f WHERE f.pkfornecedores = :pkfornecedores"),
    @NamedQuery(name = "Fornecedores.findByRazaoSocial", query = "SELECT f FROM Fornecedores f WHERE f.razaoSocial = :razaoSocial"),
    @NamedQuery(name = "Fornecedores.findByCnpj", query = "SELECT f FROM Fornecedores f WHERE f.cnpj = :cnpj"),
    @NamedQuery(name = "Fornecedores.findByNomeFantasia", query = "SELECT f FROM Fornecedores f WHERE f.nomeFantasia = :nomeFantasia")})
public class Fornecedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer pkfornecedores;
    @Basic(optional = false)
    @Column(name = "razao_social", nullable = false, length = 80)
    private String razaoSocial;
    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    private String cnpj;
    @Basic(optional = false)
    @Column(name = "nome_fantasia", nullable = false, length = 80)
    private String nomeFantasia;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkfornecedores")
    private Collection<TelefoneFornecedores> telefoneFornecedoresCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkfornecedores")
    private Collection<Valor> valorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkfornecedores")
    private Collection<EnderecoFornecedor> enderecoFornecedorCollection;

    public Fornecedores() {
    }

    public Fornecedores(Integer pkfornecedores) {
        this.pkfornecedores = pkfornecedores;
    }

    public Fornecedores(Integer pkfornecedores, String razaoSocial, String cnpj, String nomeFantasia) {
        this.pkfornecedores = pkfornecedores;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.nomeFantasia = nomeFantasia;
    }

    public Integer getPkfornecedores() {
        return pkfornecedores;
    }

    public void setPkfornecedores(Integer pkfornecedores) {
        this.pkfornecedores = pkfornecedores;
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

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    @XmlTransient
    public Collection<TelefoneFornecedores> getTelefoneFornecedoresCollection() {
        return telefoneFornecedoresCollection;
    }

    public void setTelefoneFornecedoresCollection(Collection<TelefoneFornecedores> telefoneFornecedoresCollection) {
        this.telefoneFornecedoresCollection = telefoneFornecedoresCollection;
    }

    @XmlTransient
    public Collection<Valor> getValorCollection() {
        return valorCollection;
    }

    public void setValorCollection(Collection<Valor> valorCollection) {
        this.valorCollection = valorCollection;
    }

    @XmlTransient
    public Collection<EnderecoFornecedor> getEnderecoFornecedorCollection() {
        return enderecoFornecedorCollection;
    }

    public void setEnderecoFornecedorCollection(Collection<EnderecoFornecedor> enderecoFornecedorCollection) {
        this.enderecoFornecedorCollection = enderecoFornecedorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkfornecedores != null ? pkfornecedores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Fornecedores)) {
            return false;
        }
        Fornecedores other = (Fornecedores) object;
        if ((this.pkfornecedores == null && other.pkfornecedores != null) || (this.pkfornecedores != null && !this.pkfornecedores.equals(other.pkfornecedores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lojinha.model.Fornecedores[ pkfornecedores=" + pkfornecedores + " ]";
    }
    
}
