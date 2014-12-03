/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author pompeu
 * @param <T>
 */
public class DAO<T> implements Serializable {

    private final Class<T> classe;

    private final EntityManager em;

    public DAO(Class<T> classe, EntityManager em) {
        this.classe = classe;
        this.em = em;

    }

    public void create(T obj) {
        em.getTransaction().begin();
        em.persist(obj);
        em.getTransaction().commit();
        em.close();
    }

    public void delete(T obj) {
        em.getTransaction().begin();
        em.remove(obj);
        em.getTransaction().commit();
        em.close();

    }

    public void update(T obj) {
        em.getTransaction().begin();
        em.merge(obj);
        em.getTransaction().commit();
        em.close();
    }

    public List<T> retrivetAll() {
        CriteriaQuery query = em.getCriteriaBuilder().createQuery(classe);
        query.from(classe);
        return em.createQuery(query).getResultList();
    }

    public T retrivetbyId(Integer id) {
        return em.find(classe, id);
    }

    public List retriveByName(String name) {

        String consulta = "select c from " + classe.getName() + " c where c.nome like :pNome";

        TypedQuery<Class> query = em.createQuery(consulta, Class.class);

        query.setParameter("pNome", "%" + name + "%");

        return query.getResultList();
    }

    public T retriveByCNPJOrCPF(String numero) {
        String cpfCnpj = null;
        if (numero.length() == 11) {
            cpfCnpj = "cpf";
        } else if ((numero.length() == 14)) {
            cpfCnpj = "cnpj";
        }
        String consulta = "select c from " + classe.getName() + " c where c." + cpfCnpj + " like :pCpfCnpj";

        TypedQuery<Class> query = em.createQuery(consulta, Class.class);

        query.setParameter("pCpfCnpj", "%" + numero + "%");

        return (T) query.getSingleResult();
    }

}
