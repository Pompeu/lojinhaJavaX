/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
public class EnderecoCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "pkendereco", sequenceName = "endereco_pkendereco_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pkendereco")
    @Basic(optional = false)
    @Column(name = "pkendereco")
    private Integer pkendereco;
    @Basic(optional = false)
    @Column(name = "logradouro")
    private String logradouro;
    @Basic(optional = false)
    @Column(name = "estado")
    private String estado;
    @JoinColumn(name = "fk_cliente", referencedColumnName = "pkcliente")
    @ManyToOne
    private Cliente fkCliente;

    public EnderecoCliente() {

    }

    public EnderecoCliente(String logradouro, String estado, Cliente fkCliente) {
        this.fkCliente = fkCliente;
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

    public Cliente getFkCliente() {
        return fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
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
        if (!(object instanceof EnderecoCliente)) {
            return false;
        }
        EnderecoCliente other = (EnderecoCliente) object;
        if ((this.pkendereco == null && other.pkendereco != null) || (this.pkendereco != null && !this.pkendereco.equals(other.pkendereco))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lojinha.model.EnderecoCliente[ pkendereco=" + pkendereco + " ]";
    }

}
