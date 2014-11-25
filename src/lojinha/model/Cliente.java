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
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "pkcliente", sequenceName = "cliente_pkcliente_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pkcliente")
    @Column(name = "pkcliente", nullable = false)
    private Integer pkcliente;
    @Basic(optional = false)
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Basic(optional = false)
    @Column(name = "razao_social")
    private String razaoSocial;
    @Basic(optional = false)
    @Column(name = "cnpj")
    private String cnpj;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkcliente")
    private List<TelefoneCliente> telefoneClienteList;
    @OneToMany(mappedBy = "fkCliente")
    private List<EnderecoCliente> enderecoClienteList;

    public Cliente() {
    }

    public Cliente(String cnpj,String nomeFantasia, String razaoSocial ) {
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

    public List<TelefoneCliente> getTelefoneClienteList() {
        return telefoneClienteList;
    }

    public void setTelefoneClienteList(List<TelefoneCliente> telefoneClienteList) {
        this.telefoneClienteList = telefoneClienteList;
    }

    public List<EnderecoCliente> getEnderecoClienteList() {
        return enderecoClienteList;
    }

    public void setEnderecoClienteList(List<EnderecoCliente> enderecoClienteList) {
        this.enderecoClienteList = enderecoClienteList;
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
