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
@Table(name = "telefone_fornecedores", catalog = "fxlojinha", schema = "public")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TelefoneFornecedores.findAll", query = "SELECT t FROM TelefoneFornecedores t"),
    @NamedQuery(name = "TelefoneFornecedores.findByPktelefone", query = "SELECT t FROM TelefoneFornecedores t WHERE t.pktelefone = :pktelefone"),
    @NamedQuery(name = "TelefoneFornecedores.findByDdd", query = "SELECT t FROM TelefoneFornecedores t WHERE t.ddd = :ddd"),
    @NamedQuery(name = "TelefoneFornecedores.findByNumero", query = "SELECT t FROM TelefoneFornecedores t WHERE t.numero = :numero")})
public class TelefoneFornecedores implements Serializable {
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
    @JoinColumn(name = "fkfornecedores", referencedColumnName = "pkfornecedores", nullable = false)
    @ManyToOne(optional = false)
    private Fornecedores fkfornecedores;

    public TelefoneFornecedores() {
    }

    public TelefoneFornecedores(Integer pktelefone) {
        this.pktelefone = pktelefone;
    }

    public TelefoneFornecedores(Integer pktelefone, String ddd, String numero) {
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

    public Fornecedores getFkfornecedores() {
        return fkfornecedores;
    }

    public void setFkfornecedores(Fornecedores fkfornecedores) {
        this.fkfornecedores = fkfornecedores;
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
        if (!(object instanceof TelefoneFornecedores)) {
            return false;
        }
        TelefoneFornecedores other = (TelefoneFornecedores) object;
        if ((this.pktelefone == null && other.pktelefone != null) || (this.pktelefone != null && !this.pktelefone.equals(other.pktelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "lojinha.model.TelefoneFornecedores[ pktelefone=" + pktelefone + " ]";
    }
    
}
