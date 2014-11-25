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
import lojinha.model.EnderecoCliente;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.TelefoneCliente;

/**
 *
 * @author pompeu
 */
public class ClienteDAO implements ICrudCliente {

    private final EntityManager em;

    public ClienteDAO() {
        this.em = JPAUtil.getManager();
    }

    @Override
    public void create(Cliente cliente, EnderecoCliente enderecoCliente, TelefoneCliente telefoneCliente) {
        try {
            em.getTransaction().begin();
            if (cliente.getPkcliente() == null) {
                em.persist(enderecoCliente);
                em.persist(telefoneCliente);
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
    public void delete(Cliente obj) {
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
    public List<Cliente> retrivetAll() {
        String consulta = "select c from Cliente c";
        TypedQuery<Cliente> query = em.createQuery(consulta, Cliente.class);
        return query.getResultList();
    }

    @Override
    public Cliente retrivetbyId(long id) {
        return em.find(Cliente.class, id);
    }

}
