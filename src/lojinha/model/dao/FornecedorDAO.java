/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import lojinha.model.Fornecedor;

/**
 *
 * @author pompeu
 */
public class FornecedorDAO implements ICRUD<Fornecedor> {

    private final EntityManager em;

    public FornecedorDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Fornecedor obj) {
        try {
            em.getTransaction().begin();
            if (obj.getPkfornecedores() == null) {
                em.persist(obj);
            } else {
                em.merge(obj);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Fornecedor obj) {
        try {
            em.getTransaction().begin();
            em.remove(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Fornecedor> retrivetAll() {
        String consulta = "select f from Fornecedor f";
        TypedQuery<Fornecedor> query;

        query = em.createQuery(consulta, Fornecedor.class);

        return query.getResultList();
    }

    @Override
    public Fornecedor retrivetbyId(Integer id) {
        return em.find(Fornecedor.class, id);
    }

    @Override
    public List<Fornecedor> retriveByName(String nome) {
        String consulta = "select c from Fornecedor c where c.nomeFantasia like :pNome";

        TypedQuery<Fornecedor> query = em.createQuery(consulta, Fornecedor.class);

        query.setParameter("pNome", "%" + nome + "%");

        return query.getResultList();
    }

    @Override
    public Fornecedor retriveByCNPJOrCPF(String cnpj) {
        String consulta = "select c from Fornecedor c where c.cnpj like :pCnpj";

        TypedQuery<Fornecedor> query = em.createQuery(consulta, Fornecedor.class);

        query.setParameter("pCnpj", "%" + cnpj + "%");

        return query.getSingleResult();
    }

}
