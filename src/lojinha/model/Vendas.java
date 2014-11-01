/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
    @NamedQuery(name = "Vendas.findAll", query = "SELECT v FROM Vendas v"),
    @NamedQuery(name = "Vendas.findByPkvendas", query = "SELECT v FROM Vendas v WHERE v.pkvendas = :pkvendas"),
    @NamedQuery(name = "Vendas.findByDesconto", query = "SELECT v FROM Vendas v WHERE v.desconto = :desconto"),
    @NamedQuery(name = "Vendas.findByComicao", query = "SELECT v FROM Vendas v WHERE v.comicao = :comicao"),
    @NamedQuery(name = "Vendas.findByDataCompra", query = "SELECT v FROM Vendas v WHERE v.dataCompra = :dataCompra"),
    @NamedQuery(name = "Vendas.findByDataVenda", query = "SELECT v FROM Vendas v WHERE v.dataVenda = :dataVenda")})
public class Vendas implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer pkvendas;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal desconto;
    @Basic(optional = false)
    @Column(nullable = false, precision = 10, scale = 2)
    private BigDecimal comicao;
    @Basic(optional = false)
    @Column(name = "data_compra", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataCompra;
    @Basic(optional = false)
    @Column(name = "data_venda", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dataVenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkvendas")
    private Collection<Qtd> qtdCollection;
    @JoinColumn(name = "fkcliente", referencedColumnName = "pkcliente", nullable = false)
    @ManyToOne(optional = false)
    private Cliente fkcliente;
    @JoinColumn(name = "fkvendedores", referencedColumnName = "pkvendedores", nullable = false)
    @ManyToOne(optional = false)
    private Vendedores fkvendedores;

    public Vendas() {
    }

    public Vendas(Integer pkvendas) {
        this.pkvendas = pkvendas;
    }

    public Vendas(Integer pkvendas, BigDecimal desconto, BigDecimal comicao, Date dataCompra, Date dataVenda) {
        this.pkvendas = pkvendas;
        this.desconto = desconto;
        this.comicao = comicao;
        this.dataCompra = dataCompra;
        this.dataVenda = dataVenda;
    }

    public Integer getPkvendas() {
        return pkvendas;
    }

    public void setPkvendas(Integer pkvendas) {
        this.pkvendas = pkvendas;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public BigDecimal getComicao() {
        return comicao;
    }

    public void setComicao(BigDecimal comicao) {
        this.comicao = comicao;
    }

    public Date getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Date getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(Date dataVenda) {
        this.dataVenda = dataVenda;
    }

    @XmlTransient
    public Collection<Qtd> getQtdCollection() {
        return qtdCollection;
    }

    public void setQtdCollection(Collection<Qtd> qtdCollection) {
        this.qtdCollection = qtdCollection;
    }

    public Cliente getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(Cliente fkcliente) {
        this.fkcliente = fkcliente;
    }

    public Vendedores getFkvendedores() {
        return fkvendedores;
    }

    public void setFkvendedores(Vendedores fkvendedores) {
        this.fkvendedores = fkvendedores;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkvendas != null ? pkvendas.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.pkvendas == null && other.pkvendas != null) || (this.pkvendas != null && !this.pkvendas.equals(other.pkvendas))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lojinha.model.Vendas[ pkvendas=" + pkvendas + " ]";
    }
    
}
