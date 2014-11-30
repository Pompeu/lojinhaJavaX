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
import lojinha.model.JPA.JPAUtil;

/**
 *
 * @author pompeu
 */
public class ClienteDAO implements ICRUD<Cliente> {

    private final EntityManager em;
    
    public ClienteDAO() {

        this.em = new JPAUtil().getManager();
    }

    @Override
    public void create(Cliente cliente) {
        try {
            em.getTransaction().begin();
            if (cliente.getPkcliente() == null) {
                em.persist(cliente);
            } else {
                em.merge(cliente);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    public void delete(Cliente c) {

        try {
            em.getTransaction().begin();
            c = em.find(Cliente.class, c.getPkcliente());
            em.remove(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Cliente> retrivetAll() {
        String consulta = "select c from Cliente c";
        TypedQuery<Cliente> query;

        query = em.createQuery(consulta, Cliente.class);

        return query.getResultList();
    }

    
    @Override
    public Cliente retrivetbyId(Integer id) {
        return em.find(Cliente.class, id);
    }

    @Override
    public List<Cliente> retriveByName(String nome) {
        String consulta = "select c from Cliente c where c.nomeFantasia like :pNome";
        
        TypedQuery<Cliente>  query = em.createQuery(consulta, Cliente.class);
        
        query.setParameter("pNome", "%"+nome+"%");

        return query.getResultList();
    }

    @Override
    public Cliente retriveByCNPJOrCPF(String cnpj) {
         String consulta = "select c from Cliente c where c.cnpj like :pCnpj";
        
        TypedQuery<Cliente>  query = em.createQuery(consulta, Cliente.class);
        
        query.setParameter("pCnpj", "%"+cnpj+"%");

        return query.getSingleResult();
    }
}
