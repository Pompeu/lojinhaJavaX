/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.JPA;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.jpa.config.Entity;

/**
 *
 * @author pompeu
 */
public class JPAUtil {
    private static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("LojinhaPU");
    private static final EntityManager EM = EMF.createEntityManager();

    private JPAUtil() {
    }
    
    public static EntityManager getManager(){
        return EM;
    }
    
}
