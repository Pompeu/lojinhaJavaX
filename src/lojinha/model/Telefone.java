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
@Table(catalog = "fxlojinha", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t"),
    @NamedQuery(name = "Telefone.findByPktelefone", query = "SELECT t FROM Telefone t WHERE t.pktelefone = :pktelefone"),
    @NamedQuery(name = "Telefone.findByDdd", query = "SELECT t FROM Telefone t WHERE t.ddd = :ddd"),
    @NamedQuery(name = "Telefone.findByNumero", query = "SELECT t FROM Telefone t WHERE t.numero = :numero")})
public class Telefone implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer pktelefone;
    @Basic(optional = false)
    @Column(nullable = false, length = 3)
    private String ddd;
    @Basic(optional = false)
    @Column(nullable = false, length = 9)
    private String numero;
    @JoinColumn(name = "fkcliente", referencedColumnName = "pkcliente", nullable = false)
    @ManyToOne(optional = false)
    private Cliente fkcliente;

    public Telefone() {
    }

    public Telefone(Integer pktelefone) {
        this.pktelefone = pktelefone;
    }

    public Telefone(Integer pktelefone, String ddd, String numero) {
        this.pktelefone = pktelefone;
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
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.pktelefone == null && other.pktelefone != null) || (this.pktelefone != null && !this.pktelefone.equals(other.pktelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lojinha.model.Telefone[ pktelefone=" + pktelefone + " ]";
    }
    
}
