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
@Table(catalog = "fxlojinha", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Valor.findAll", query = "SELECT v FROM Valor v"),
    @NamedQuery(name = "Valor.findByPkValor", query = "SELECT v FROM Valor v WHERE v.pkValor = :pkValor")})
public class Valor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "pk_valor", sequenceName = "produtos_pk_valor_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_valor")
    @Basic(optional = false)
    @Column(name = "pk_valor", nullable = false)
    private Integer pkValor;
    @JoinColumn(name = "fkfornecedores", referencedColumnName = "pkfornecedores", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Fornecedor fkfornecedores;
    @JoinColumn(name = "fkprodutos", referencedColumnName = "pkprodutos", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Produto fkprodutos;

    public Valor() {
    }

    public Valor(Integer pkValor) {
        this.pkValor = pkValor;
    }

    public Integer getPkValor() {
        return pkValor;
    }

    public void setPkValor(Integer pkValor) {
        this.pkValor = pkValor;
    }

    public Fornecedor getFkfornecedores() {
        return fkfornecedores;
    }

    public void setFkfornecedores(Fornecedor fkfornecedores) {
        this.fkfornecedores = fkfornecedores;
    }

    public Produto getFkprodutos() {
        return fkprodutos;
    }

    public void setFkprodutos(Produto fkprodutos) {
        this.fkprodutos = fkprodutos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkValor != null ? pkValor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Valor)) {
            return false;
        }
        Valor other = (Valor) object;
        if ((this.pkValor == null && other.pkValor != null) || (this.pkValor != null && !this.pkValor.equals(other.pkValor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Valor{" + "pkValor=" + pkValor + ", fkfornecedores=" + fkfornecedores + ", fkprodutos=" + fkprodutos + '}';
    }

}
