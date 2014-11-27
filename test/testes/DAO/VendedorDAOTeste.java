/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.DAO;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.Vendedor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pompeu
 */
public class VendedorDAOTeste {
    
    public VendedorDAOTeste() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

  @Test
  public void deveCricarUmVendedor(){
      Vendedor vendedor = new Vendedor("Pompeu", "00311920179", "011182");
      EntityManager em = new JPAUtil().getManager();
      em.getTransaction().begin();
      em.persist(vendedor);
      em.getTransaction().commit();
      em.close();
      assertTrue(!em.isOpen());
  }
}
