/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
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
    @NamedQuery(name = "Vendas.findByPkvenda", query = "SELECT v FROM Vendas v WHERE v.pkvenda = :pkvenda"),
    @NamedQuery(name = "Vendas.findByDesconto", query = "SELECT v FROM Vendas v WHERE v.desconto = :desconto"),
    @NamedQuery(name = "Vendas.findByComicao", query = "SELECT v FROM Vendas v WHERE v.comicao = :comicao"),
    @NamedQuery(name = "Vendas.findByDataCompra", query = "SELECT v FROM Vendas v WHERE v.dataCompra = :dataCompra"),
    @NamedQuery(name = "Vendas.findByDataVenda", query = "SELECT v FROM Vendas v WHERE v.dataVenda = :dataVenda")})
public class Vendas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @SequenceGenerator(name = "pkvenda", sequenceName = "produtos_pkvenda_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pkvenda")
    @Basic(optional = false)
    @Column(name = "pkvenda", nullable = false)
    private Integer pkvenda;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkvendas", fetch = FetchType.LAZY)
    private List<Qtd> qtdList;
    @JoinColumn(name = "fkcliente", referencedColumnName = "pkcliente", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cliente fkcliente;
    @JoinColumn(name = "fkvendedor", referencedColumnName = "pkvendedores", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Vendedor fkvendedor;

    public Vendas() {
    }

    public Vendas(BigDecimal desconto, BigDecimal comicao, Date dataCompra, Date dataVenda, List<Qtd> qtdList, Cliente fkcliente, Vendedor fkvendedor) {
        this.desconto = desconto;
        this.comicao = comicao;
        this.dataCompra = dataCompra;
        this.dataVenda = dataVenda;
        this.qtdList = qtdList;
        this.fkcliente = fkcliente;
        this.fkvendedor = fkvendedor;
    }

    public Integer getPkvenda() {
        return pkvenda;
    }

    public void setPkvenda(Integer pkvenda) {
        this.pkvenda = pkvenda;
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
    public List<Qtd> getQtdList() {
        return qtdList;
    }

    public void setQtdList(List<Qtd> qtdList) {
        this.qtdList = qtdList;
    }

    public Cliente getFkcliente() {
        return fkcliente;
    }

    public void setFkcliente(Cliente fkcliente) {
        this.fkcliente = fkcliente;
    }

    public Vendedor getFkvendedor() {
        return fkvendedor;
    }

    public void setFkvendedor(Vendedor fkvendedor) {
        this.fkvendedor = fkvendedor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkvenda != null ? pkvenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendas)) {
            return false;
        }
        Vendas other = (Vendas) object;
        if ((this.pkvenda == null && other.pkvenda != null) || (this.pkvenda != null && !this.pkvenda.equals(other.pkvenda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Vendas{" + "pkvenda=" + pkvenda + ", desconto=" + desconto + ", comicao=" + comicao + ", dataCompra=" + dataCompra + ", dataVenda=" + dataVenda + ", qtdList=" + qtdList + ", fkcliente=" + fkcliente + ", fkvendedor=" + fkvendedor + '}';
    }

}
