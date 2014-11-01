/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model;

import java.io.Serializable;
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
    @NamedQuery(name = "Vendedores.findAll", query = "SELECT v FROM Vendedores v"),
    @NamedQuery(name = "Vendedores.findByPkvendedores", query = "SELECT v FROM Vendedores v WHERE v.pkvendedores = :pkvendedores"),
    @NamedQuery(name = "Vendedores.findByNome", query = "SELECT v FROM Vendedores v WHERE v.nome = :nome"),
    @NamedQuery(name = "Vendedores.findByCpf", query = "SELECT v FROM Vendedores v WHERE v.cpf = :cpf"),
    @NamedQuery(name = "Vendedores.findByNascimento", query = "SELECT v FROM Vendedores v WHERE v.nascimento = :nascimento")})
public class Vendedores implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(nullable = false)
    private Integer pkvendedores;
    @Basic(optional = false)
    @Column(nullable = false, length = 80)
    private String nome;
    @Basic(optional = false)
    @Column(nullable = false, length = 11)
    private String cpf;
    @Basic(optional = false)
    @Column(nullable = false, length = 6)
    private String nascimento;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "fkvendedores")
    private Collection<Vendas> vendasCollection;

    public Vendedores() {
    }

    public Vendedores(Integer pkvendedores) {
        this.pkvendedores = pkvendedores;
    }

    public Vendedores(Integer pkvendedores, String nome, String cpf, String nascimento) {
        this.pkvendedores = pkvendedores;
        this.nome = nome;
        this.cpf = cpf;
        this.nascimento = nascimento;
    }

    public Integer getPkvendedores() {
        return pkvendedores;
    }

    public void setPkvendedores(Integer pkvendedores) {
        this.pkvendedores = pkvendedores;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNascimento() {
        return nascimento;
    }

    public void setNascimento(String nascimento) {
        this.nascimento = nascimento;
    }

    @XmlTransient
    public Collection<Vendas> getVendasCollection() {
        return vendasCollection;
    }

    public void setVendasCollection(Collection<Vendas> vendasCollection) {
        this.vendasCollection = vendasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkvendedores != null ? pkvendedores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedores)) {
            return false;
        }
        Vendedores other = (Vendedores) object;
        if ((this.pkvendedores == null && other.pkvendedores != null) || (this.pkvendedores != null && !this.pkvendedores.equals(other.pkvendedores))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lojinha.model.Vendedores[ pkvendedores=" + pkvendedores + " ]";
    }
    
}
