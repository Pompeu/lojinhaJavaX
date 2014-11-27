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
public class Vendedor implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @SequenceGenerator(name = "pkvendedores", sequenceName = "vendedores_pkvendedores_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pkvendedores")
    @Column(name = "pkvendedores", nullable = false)
    @Basic(optional = false)
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

    public Vendedor() {
    }

    public Vendedor( String nome, String cpf, String nascimento) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pkvendedores != null ? pkvendedores.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vendedor)) {
            return false;
        }
        Vendedor other = (Vendedor) object;
        if ((this.pkvendedores == null && other.pkvendedores != null) || (this.pkvendedores != null && !this.pkvendedores.equals(other.pkvendedores))) {
            return false;
        }
        return true;
    }



    @Override
    public String toString() {
        return "Vendedor{" + "pkvendedores=" + pkvendedores + ", nome=" + nome + ", cpf=" + cpf + ", nascimento=" + nascimento + '}';
    }
    
    
}
