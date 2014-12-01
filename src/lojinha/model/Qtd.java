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
import javax.persistence.FetchType;
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
@Table(name = "qtd")
public class Qtd implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "pk_qtd", sequenceName = "produtos_pk_qtd_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_qtd")
    @Basic(optional = false)
    @Column(name = "pk_qtd", nullable = false)
    private Integer pkQtd;
    @JoinColumn(name = "fkprodutos", referencedColumnName = "pkprodutos", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto fkprodutos;
    @JoinColumn(name = "fkvendas", referencedColumnName = "pkvenda", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vendas fkvendas;

    public Qtd() {
    }

    public Qtd(Integer pkQtd, Produto fkprodutos, Vendas fkvendas) {
        this.pkQtd = pkQtd;
        this.fkprodutos = fkprodutos;
        this.fkvendas = fkvendas;
    }

    public Integer getPkQtd() {
        return pkQtd;
    }

    public void setPkQtd(Integer pkQtd) {
        this.pkQtd = pkQtd;
    }

    public Produto getFkprodutos() {
        return fkprodutos;
    }

    public void setFkprodutos(Produto fkprodutos) {
        this.fkprodutos = fkprodutos;
    }

    public Vendas getFkvendas() {
        return fkvendas;
    }

    public void setFkvendas(Vendas fkvendas) {
        this.fkvendas = fkvendas;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkQtd != null ? pkQtd.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Qtd)) {
            return false;
        }
        Qtd other = (Qtd) object;
        if ((this.pkQtd == null && other.pkQtd != null) || (this.pkQtd != null && !this.pkQtd.equals(other.pkQtd))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lojinha.model.Qtd[ pkQtd=" + pkQtd + " ]";
    }

}
