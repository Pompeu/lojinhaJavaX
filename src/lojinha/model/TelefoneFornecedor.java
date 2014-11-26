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
import javax.persistence.SequenceGenerator;

/**
 *
 * @author pompeu
 */
@Entity

public class TelefoneFornecedor implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "pktelefone", sequenceName = "telefone_fornecedores_pktelefone_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pktelefone")
    @Column(name = "pktelefone", nullable = false)
    @Basic(optional = false)
    private Integer pktelefone;
    @Basic(optional = false)
    @Column(nullable = false, length = 3)
    private String ddd;
    @Basic(optional = false)
    @Column(nullable = false, length = 9)
    private String numero;
    @JoinColumn(name = "fkfornecedores", referencedColumnName = "pkfornecedores", nullable = false)
    @ManyToOne(optional = false)
    private Fornecedor fkFornecedor;

    public TelefoneFornecedor() {
    }

    public TelefoneFornecedor(String ddd, String numero, Fornecedor fkFornecedor) {
        this.ddd = ddd;
        this.numero = numero;
        this.fkFornecedor = fkFornecedor;
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

    public Fornecedor getFkfornecedores() {
        return fkFornecedor;
    }

    public void setFkfornecedores(Fornecedor fkFornecedor) {
        this.fkFornecedor = fkFornecedor;
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
        if (!(object instanceof TelefoneFornecedor)) {
            return false;
        }
        TelefoneFornecedor other = (TelefoneFornecedor) object;
        if ((this.pktelefone == null && other.pktelefone != null) || (this.pktelefone != null && !this.pktelefone.equals(other.pktelefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TelefoneFornecedor{" + "ddd=" + ddd + ", numero=" + numero + ", fkfornecedores=" + fkFornecedor + '}';
    }

   

}
