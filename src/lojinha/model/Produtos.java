/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author pompeu
 */
@Entity
@Table(catalog = "fxlojinha", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Produtos.findAll", query = "SELECT p FROM Produtos p"),
    @NamedQuery(name = "Produtos.findByPkprodutos", query = "SELECT p FROM Produtos p WHERE p.pkprodutos = :pkprodutos"),
    @NamedQuery(name = "Produtos.findByValor", query = "SELECT p FROM Produtos p WHERE p.valor = :valor"),
    @NamedQuery(name = "Produtos.findByDescricao", query = "SELECT p FROM Produtos p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produtos.findByEstoqueMinimo", query = "SELECT p FROM Produtos p WHERE p.estoqueMinimo = :estoqueMinimo")})
public class Produtos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer pkprodutos;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 4, scale = 2)
    private BigDecimal valor;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String descricao;
    @Basic(optional = false)
    @Column(name = "estoque_minimo", nullable = false)
    private int estoqueMinimo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkprodutos")
    private Collection<Qtd> qtdCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkprodutos")
    private Collection<Valor> valorCollection;

    public Produtos() {
    }

    public Produtos(Integer pkprodutos) {
        this.pkprodutos = pkprodutos;
    }

    public Produtos(Integer pkprodutos, BigDecimal valor, String descricao, int estoqueMinimo) {
        this.pkprodutos = pkprodutos;
        this.valor = valor;
        this.descricao = descricao;
        this.estoqueMinimo = estoqueMinimo;
    }

    public Integer getPkprodutos() {
        return pkprodutos;
    }

    public void setPkprodutos(Integer pkprodutos) {
        this.pkprodutos = pkprodutos;
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

    public int getEstoqueMinimo() {
        return estoqueMinimo;
    }

    public void setEstoqueMinimo(int estoqueMinimo) {
        this.estoqueMinimo = estoqueMinimo;
    }

    @XmlTransient
    public Collection<Qtd> getQtdCollection() {
        return qtdCollection;
    }

    public void setQtdCollection(Collection<Qtd> qtdCollection) {
        this.qtdCollection = qtdCollection;
    }

    @XmlTransient
    public Collection<Valor> getValorCollection() {
        return valorCollection;
    }

    public void setValorCollection(Collection<Valor> valorCollection) {
        this.valorCollection = valorCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkprodutos != null ? pkprodutos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtos)) {
            return false;
        }
        Produtos other = (Produtos) object;
        if ((this.pkprodutos == null && other.pkprodutos != null) || (this.pkprodutos != null && !this.pkprodutos.equals(other.pkprodutos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lojinha.model.Produtos[ pkprodutos=" + pkprodutos + " ]";
    }
    
}
