/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.DAO;

import java.util.Iterator;
import lojinha.model.Cliente;
import lojinha.model.Fornecedor;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.Produto;
import lojinha.model.Vendedor;
import lojinha.model.dao.DAO;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author pompeu
 */
public class TesteDAOGenerico {

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

    public void deveGravarVendedor() {
        DAO<Vendedor> dao = new DAO<>(Vendedor.class, new JPAUtil().getManager());

        Vendedor v = new Vendedor("Jose Maria", "01102200312", "011182");

        dao.create(v);
    }

    @Test
    public void deveRetornarTodosVendedores() {
        DAO<Vendedor> dao = new DAO<>(Vendedor.class, new JPAUtil().getManager());

        assertFalse(dao.retrivetAll().isEmpty());
    }

    @Test
    public void deveRetornarTodosForncedores() {
        DAO<Fornecedor> dao = new DAO<>(Fornecedor.class, new JPAUtil().getManager());

        assertFalse(dao.retrivetAll().isEmpty());
    }

    @Test
    public void deveRetornarTodosClietes() {
        DAO<Cliente> dao = new DAO<>(Cliente.class, new JPAUtil().getManager());

        assertFalse(dao.retrivetAll().isEmpty());
    }

    @Test
    public void deveRetornarTodosProdotos() {
        DAO<Produto> dao = new DAO<>(Produto.class, new JPAUtil().getManager());
        for (Iterator<Produto> it = dao.retrivetAll().iterator(); it.hasNext();) {
            System.out.println(it.next());
        }

        assertFalse(dao.retrivetAll().isEmpty());
    }

    @Test
    public void deveRecuperarUmVendedor() {
        DAO<Vendedor> dao = new DAO<>(Vendedor.class, new JPAUtil().getManager());
        assertEquals(dao.retrivetbyId(14).getNome(), "Jose Maria");
    }

    @Test
    public void deveRecuperarUmVendedorPeloCPF() {
        DAO<Vendedor> dao = new DAO<>(Vendedor.class, new JPAUtil().getManager());
        assertEquals(dao.retriveByCNPJOrCPF("00311960179").getCpf(), "00311960179");
    }

    @Test
    public void deveRecuperaUmVendedorPeloNome() {
        DAO<Vendedor> dao = new DAO<>(Vendedor.class, new JPAUtil().getManager());
        assertFalse(dao.retriveByName("Pompeu").isEmpty());
    }
}
