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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author pompeu
 */
@Entity

public class TelefoneCliente implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "pktelefone", sequenceName = "telefone_pktelefone_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pktelefone")
    @Basic(optional = false)
    @Column(name = "pktelefone")
    private Integer pktelefone;
    @Basic(optional = false)
    @Column(name = "ddd")
    private String ddd;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @JoinColumn(name = "fkcliente", referencedColumnName = "pkcliente")
    @ManyToOne(optional = false)
    private Cliente fkcliente;

    public TelefoneCliente() {
    }

    public TelefoneCliente(String ddd, String numero, Cliente fkCliente) {
        this.fkcliente = fkCliente;
        this.ddd = ddd;
        this.numero = numero;
    }

    public Integer getPktelefone() {
        return pktelefone;
    }

    public void setPktelefone(Integer pktelefone) {
        this.pktelefone = pktelefone;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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
        hash += (pktelefone != null ? pktelefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefoneCliente)) {
            return false;
        }
        TelefoneCliente other = (TelefoneCliente) object;
        if ((this.pktelefone == null && other.pktelefone != null) || (this.pktelefone != null && !this.pktelefone.equals(other.pktelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lojinha.model.TelefoneCliente[ pktelefone=" + pktelefone + " ]";
    }

}
