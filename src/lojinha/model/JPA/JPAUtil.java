/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pompeu
 */
public class JPAUtil {

    private final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("lojinha");

    public JPAUtil() {
    }

    public EntityManager getManager() {
        return EMF.createEntityManager();
    }

}
