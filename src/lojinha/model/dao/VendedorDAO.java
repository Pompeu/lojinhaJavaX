/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import lojinha.model.Vendedor;

/**
 *
 * @author pompeu
 */
public class VendedorDAO implements ICRUD<Vendedor> {

    private final EntityManager em;

    public VendedorDAO(EntityManager em) {
        this.em = em;
    }

    @Override
    public void create(Vendedor obj) {
        try {
            em.getTransaction().begin();
            if (obj.getPkvendedores() == null) {
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
    public void delete(Vendedor obj) {
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
    public List<Vendedor> retrivetAll() {
        String consulta = "select p from Produto p";
        TypedQuery<Vendedor> query;

        query = em.createQuery(consulta, Vendedor.class);

        return query.getResultList();
    }

    @Override
    public Vendedor retrivetbyId(Integer id) {
        return em.find(Vendedor.class, id);
    }

    @Override
    public List<Vendedor> retriveByName(String nome) {
        String consulta = "select p from Produto p where p.nome like :pNome";

        TypedQuery<Vendedor> query = em.createQuery(consulta, Vendedor.class);

        query.setParameter("pNome", "%" + nome + "%");

        return query.getResultList();
    }

}
