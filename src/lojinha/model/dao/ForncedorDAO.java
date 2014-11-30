/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import lojinha.model.Cliente;
import lojinha.model.Fornecedor;
import lojinha.model.JPA.JPAUtil;

/**
 *
 * @author pompeu
 */
public class ForncedorDAO implements ICRUD<Fornecedor> {

    private final EntityManager em;

    public ForncedorDAO() {
        em = new JPAUtil().getManager();
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
    public List<Fornecedor> retriveByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Fornecedor retriveByCNPJOrCPF(String cnpj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   

    

}
