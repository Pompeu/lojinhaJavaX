/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.DAO;

import java.math.BigDecimal;
import java.util.List;
import lojinha.model.Cliente;
import lojinha.model.Fornecedor;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.Produto;
import lojinha.model.Vendedor;
import lojinha.model.dao.ClienteDAO;
import lojinha.model.dao.ForncedorDAO;
import lojinha.model.dao.ICRUD;
import lojinha.model.dao.ProdutoDAO;
import lojinha.model.dao.VendedorDAO;
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
public class TestesDAO {

    public TestesDAO() {
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
    public void deveRecuperaUmCliente() {
        Cliente c;

        ICRUD<Cliente> clienteDAO = new ClienteDAO();
        c = clienteDAO.retrivetbyId(32);
        assertEquals(c.getNomeFantasia(), "lojinha doida");
        assertEquals(c.getCnpj(), "00001002000278");

    }

    @Test
    public void deveRecuperarTodosClietes() {
        ICRUD<Cliente> clienteDAO = new ClienteDAO();
        List<Cliente> clientes = clienteDAO.retrivetAll();
        assertFalse(clientes.isEmpty());

    }

    @Test
    public void deveRecuperarClientesPeloNome() {
        ICRUD<Cliente> clienteDAO = new ClienteDAO();
        String nome = "doida";

        List<Cliente> clientes = clienteDAO.retriveByName(nome);

        assertFalse(clientes.isEmpty());

    }

    @Test
    public void deveRecuperaUmClientePeloCNPJ() {
        ICRUD<Cliente> clienteDAO = new ClienteDAO();
        String cnpj = "00001002000278";

        Cliente cliente = clienteDAO.retriveByCNPJOrCPF(cnpj);

        
        assertEquals(cliente.getNomeFantasia(), "lojinha doida");
    }

    @Test
    public void deveRetornarUmFornecdorPeloId() {
        ICRUD<Fornecedor> icrud = new ForncedorDAO();
        Fornecedor f = icrud.retrivetbyId(3);
        assertEquals(f.getNomeFantasia(), "CTBC");

    }

    @Test
    public void deveRetornarTodosFornecedores() {
        ICRUD<Fornecedor> icrud = new ForncedorDAO();
        List<Fornecedor> fornecedors = icrud.retrivetAll();

        assertFalse(fornecedors.isEmpty());
    }

    @Test
    public void deveRerTornaUmProdutoPorID() {

        ICRUD<Produto> icrud = new ProdutoDAO();
        //icrud.create(new Produto(new BigDecimal("10.26"), "Melancia Azul", 100));
        Produto p = icrud.retrivetbyId(1);
        assertEquals(p.getValor(), new BigDecimal("10.00"));
    }

    @Test
    public void deveRetornarUmListaProdutos() {
        ICRUD<Produto> icrud = new ProdutoDAO();
        List<Produto> produtos = icrud.retrivetAll();
        assertTrue(produtos.size() > 0);
    }

    @Test
    public void deveRetornarUmProdutoProNome() {
        ICRUD<Produto> icrud = new ProdutoDAO();
        List<Produto> produtos = icrud.retriveByName("Azul");
        assertTrue(produtos.size() > 0);
    }

    @Test
    public void deveRecurarUmVendedor() {
        ICRUD<Vendedor> icrud = new VendedorDAO(new JPAUtil().getManager());
        //icrud.create(new Vendedor("PompeuLimp", "00311920179", "011182"));
        Vendedor vendedor = icrud.retrivetbyId(2);
        assertEquals(vendedor.getPkvendedores(), 2, 0);
    }

    @Test
    public void deveRecucperarUmVendedorPeloNome() {
        ICRUD<Vendedor> icrud = new VendedorDAO(new JPAUtil().getManager());
        //icrud.create(new Vendedor("PompeuLimp", "00311920179", "011182"));
        List<Vendedor> vendedores = icrud.retriveByName("Pompeu");

        assertFalse(vendedores.isEmpty());
    }
}
