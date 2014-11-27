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
import javax.persistence.SequenceGenerator;

/**
 *
 * @author pompeu
 */
@Entity
public class EnderecoFornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "pkendereco_fornecedor", sequenceName = "endereco_fornecedor_pkendereco_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pkendereco_fornecedor")
    @Column(name = "pkendereco_fornecedor", nullable = false)
    @Basic(optional = false)
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
    @JoinColumn(name = "fkFornecedor", referencedColumnName = "pkfornecedores", nullable = false)
    @ManyToOne(optional = false)
    private Fornecedor fkFornecedor;

    public EnderecoFornecedor() {
    }

    public EnderecoFornecedor(String complemento, String logradouro, String cidade, String bairro, String cep, String estado, Fornecedor fkFornecedor) {
        this.complemento = complemento;
        this.logradouro = logradouro;
        this.cidade = cidade;
        this.bairro = bairro;
        this.cep = cep;
        this.estado = estado;
        this.fkFornecedor = fkFornecedor;
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

    public Fornecedor getFkfornecedores() {
        return fkFornecedor;
    }

    public void setFkfornecedores(Fornecedor fkFornecedor) {
        this.fkFornecedor = fkFornecedor;
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
        return "EnderecoFornecedor{" + "complemento=" + complemento + ", logradouro=" + logradouro + ", cidade=" + cidade + ", bairro=" + bairro + ", cep=" + cep + ", estado=" + estado + ", fkfornecedores=" + fkFornecedor + '}';
    }

   

}
