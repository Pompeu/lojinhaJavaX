/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author pompeu
 */
@Entity
public class Fornecedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "pkfornecedores", sequenceName = "fornecedores_pkfornecedores_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pkfornecedores")
    @Column(name = "pkfornecedores", nullable = false)
    @Basic(optional = false)
    private Integer pkfornecedores;
    @Basic(optional = false)
    @Column(name = "razao_social", nullable = false, length = 80)
    private String razaoSocial;
    @Basic(optional = false)
    @Column(nullable = false, length = 15)
    private String cnpj;
    @Basic(optional = false)
    @Column(name = "nome_fantasia", nullable = false, length = 80)
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkFornecedor")
    private List<TelefoneFornecedor> telefonefornecedoresList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkFornecedor")
    private List<EnderecoFornecedor> enderecofornecedorList;

    public Fornecedor() {
    }

    public Fornecedor(String razaoSocial, String cnpj, String nomeFantasia) {
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
        this.nome = nomeFantasia;
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
        return nome;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nome = nomeFantasia;
    }

    public List<TelefoneFornecedor> getTelefonefornecedoresList() {
        return telefonefornecedoresList;
    }

    public void setTelefonefornecedoresList(List<TelefoneFornecedor> telefonefornecedoresList) {
        this.telefonefornecedoresList = telefonefornecedoresList;
    }

    public List<EnderecoFornecedor> getEnderecofornecedorList() {
        return enderecofornecedorList;
    }

    public void setEnderecofornecedorList(List<EnderecoFornecedor> enderecofornecedorList) {
        this.enderecofornecedorList = enderecofornecedorList;
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
        if (!(object instanceof Fornecedor)) {
            return false;
        }
        Fornecedor other = (Fornecedor) object;
        if ((this.pkfornecedores == null && other.pkfornecedores != null) || (this.pkfornecedores != null && !this.pkfornecedores.equals(other.pkfornecedores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Fornecedor{" + "pkfornecedores=" + pkfornecedores + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", nomeFantasia=" + nome + '}';
    }

}
