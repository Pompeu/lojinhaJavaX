/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author pompeu
 */
@Entity
@Table(name = "produtos")
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "pkprodutos", sequenceName = "produtos_pkprodutos_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pkprodutos")
    @Basic(optional = false)
    @Column(name = "pkprodutos", nullable = false)
    private Integer pkProdutos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 6, scale = 2)
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "estoque_minimo", nullable = false)
    private Integer estoque;

    public Produto() {
    }

    public Produto(Integer pkProdutos) {
        this.pkProdutos = pkProdutos;
    }

    public Produto(BigDecimal valor, String descricao, Integer estoque) {
        this.valor = valor;
        this.descricao = descricao;
        this.estoque = estoque;
    }

    public Integer getPkprodutos() {
        return pkProdutos;
    }

    public void setPkprodutos(Integer pkProdutos) {
        this.pkProdutos = pkProdutos;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getEstoqueMinimo() {
        return estoque;
    }

    public void setEstoqueMinimo(Integer estoque) {
        this.estoque = estoque;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkProdutos != null ? pkProdutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.pkProdutos == null && other.pkProdutos != null) || (this.pkProdutos != null && !this.pkProdutos.equals(other.pkProdutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produto{" + "pkprodutos=" + pkProdutos + ", valor=" + valor + ", descricao=" + descricao + ", estoque=" + estoque + '}';
    }

}
