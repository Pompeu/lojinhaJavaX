/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model;

import java.io.Serializable;
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
 * @author pompeu
 */
@Entity
@Table(name = "endereco_fornecedor", catalog = "fxlojinha", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EnderecoFornecedor.findAll", query = "SELECT e FROM EnderecoFornecedor e"),
    @NamedQuery(name = "EnderecoFornecedor.findByPkendereco", query = "SELECT e FROM EnderecoFornecedor e WHERE e.pkendereco = :pkendereco"),
    @NamedQuery(name = "EnderecoFornecedor.findByComplemento", query = "SELECT e FROM EnderecoFornecedor e WHERE e.complemento = :complemento"),
    @NamedQuery(name = "EnderecoFornecedor.findByLogradouro", query = "SELECT e FROM EnderecoFornecedor e WHERE e.logradouro = :logradouro"),
    @NamedQuery(name = "EnderecoFornecedor.findByCidade", query = "SELECT e FROM EnderecoFornecedor e WHERE e.cidade = :cidade"),
    @NamedQuery(name = "EnderecoFornecedor.findByBairro", query = "SELECT e FROM EnderecoFornecedor e WHERE e.bairro = :bairro"),
    @NamedQuery(name = "EnderecoFornecedor.findByCep", query = "SELECT e FROM EnderecoFornecedor e WHERE e.cep = :cep"),
    @NamedQuery(name = "EnderecoFornecedor.findByEstado", query = "SELECT e FROM EnderecoFornecedor e WHERE e.estado = :estado")})
public class EnderecoFornecedor implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer pkendereco;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String complemento;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String logradouro;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String cidade;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String bairro;
    @Basic(optional = false)
    @Column(nullable = false, length = 8)
    private String cep;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String estado;
    @JoinColumn(name = "fkfornecedores", referencedColumnName = "pkfornecedores", nullable = false)
    @ManyToOne(optional = false)
    private Fornecedores fkfornecedores;

    public EnderecoFornecedor() {
    }

    public EnderecoFornecedor(Integer pkendereco) {
        this.pkendereco = pkendereco;
    }

    public EnderecoFornecedor(Integer pkendereco, String complemento, String logradouro, String cidade, String bairro, String cep, String estado) {
        this.pkendereco = pkendereco;
        this.complemento = complemento;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
    }

    public Integer getPkendereco() {
        return pkendereco;
    }

    public void setPkendereco(Integer pkendereco) {
        this.pkendereco = pkendereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Fornecedores getFkfornecedores() {
        return fkfornecedores;
    }

    public void setFkfornecedores(Fornecedores fkfornecedores) {
        this.fkfornecedores = fkfornecedores;
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
        if (!(object instanceof EnderecoFornecedor)) {
            return false;
        }
        EnderecoFornecedor other = (EnderecoFornecedor) object;
        if ((this.pkendereco == null && other.pkendereco != null) || (this.pkendereco != null && !this.pkendereco.equals(other.pkendereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lojinha.model.EnderecoFornecedor[ pkendereco=" + pkendereco + " ]";
    }
    
}
