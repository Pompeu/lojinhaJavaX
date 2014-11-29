/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.Produto;

/**
 *
 * @author pompeu
 */
public class ProdutoDAO implements ICRUD<Produto> {

    private final EntityManager em;

    public ProdutoDAO() {
        em = new JPAUtil().getManager();
    }

    @Override
    public void create(Produto obj) {
        try {
            em.getTransaction().begin();
            if (obj.getPkprodutos() == null) {
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
    public void delete(Produto obj) {
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
    public List<Produto> retrivetAll() {
        String consulta = "select p from Produto p";
        TypedQuery<Produto> query;

        query = em.createQuery(consulta, Produto.class);

        return query.getResultList();
    }

    @Override
    public Produto retrivetbyId(Integer id) {
        return em.find(Produto.class, id);
    }

    @Override
    public List<Produto> retriveByName(String descricao) {
        String consulta = "select p from Produto p where p.descricao like :pDescricao";

        TypedQuery<Produto> query = em.createQuery(consulta, Produto.class);

        query.setParameter("pDescricao", "%" + descricao + "%");

        return query.getResultList();
    }

}
