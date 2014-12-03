/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.DAO;

import java.math.BigDecimal;
import java.util.List;
import lojinha.model.Cliente;
import lojinha.model.EnderecoCliente;
import lojinha.model.Fornecedor;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.Produto;
import lojinha.model.Vendedor;
import lojinha.model.dao.ClienteDAO;
import lojinha.model.dao.FornecedorDAO;
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

    private ICRUD<Cliente> icrudCliente;
    private ICRUD<Fornecedor> icrudFornecedor;

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        icrudCliente = new ClienteDAO(new JPAUtil().getManager());
        icrudFornecedor = new FornecedorDAO(new JPAUtil().getManager());
    }

    @After
    public void tearDown() {
    }

    @Test
    public void deveRecuperaUmCliente() {
        Cliente c;

        
        c = icrudCliente.retrivetbyId(32);
        assertEquals(c.getNomeFantasia(), "lojinha doida");
        assertEquals(c.getCnpj(), "00001002000278");

    }

    @Test
    public void deveRecuperarTodosClietes() {
        
        List<Cliente> clientes = icrudCliente.retrivetAll();
        assertFalse(clientes.isEmpty());

    }

    @Test
    public void deveRecuperarClientesPeloNome() {
        
        String nome = "doida";

        List<Cliente> clientes = icrudCliente.retriveByName(nome);

        assertFalse(clientes.isEmpty());

    }

    @Test
    public void deveRecuperaUmClientePeloCNPJ() {
        
        String cnpj = "00001002000278";

        Cliente cliente = icrudCliente.retriveByCNPJOrCPF(cnpj);

        assertEquals(cliente.getNomeFantasia(), "lojinha doida");
    }

    @Test
    public void deveDeletarUmTelefoneDeUmClienteByPk() {
        
        Cliente c = icrudCliente.retrivetbyId(32);
        List<EnderecoCliente> enderecoClientes = c.getEnderecoClienteList();
        long pkTelefone = 0;
        for (EnderecoCliente enderecoCliente : enderecoClientes) {
            System.out.println(enderecoCliente.toString());
            if (enderecoCliente.getPkendereco() == 113) {
                pkTelefone = enderecoCliente.getPkendereco();
            }
        }

        assertEquals(pkTelefone, 113);

    }

    @Test
    public void deveRetornarUmFornecdorPeloId() {
       
        Fornecedor f = icrudFornecedor.retrivetbyId(3);
        assertEquals(f.getNomeFantasia(), "CTBC");

    }

    @Test
    public void deveRetornarTodosFornecedores() {
        
        List<Fornecedor> fornecedors = icrudFornecedor.retrivetAll();
        assertFalse(fornecedors.isEmpty());
    }

    @Test
    public void deveRetornarUmFornecedorPeloNome() {
        
        List<Fornecedor> fornecedors = icrudFornecedor.retriveByName("Cascarinha Solution");
        assertFalse(fornecedors.isEmpty());
    }

    @Test
    public void deveRetornarUmFornecedorPeloCNPJ() {
        
        Fornecedor fornecedor = icrudFornecedor.retriveByCNPJOrCPF("02003002000178");
        assertEquals(fornecedor.getNomeFantasia(), "OI");
    }

    @Test
    public void deveRerTornaUmProdutoPorID() {

        ICRUD<Produto> icrud = new ProdutoDAO();
        //icrud.create(new Produto(new BigDecimal("10.26"), "Melancia Azul", 100));
        Produto p = icrud.retrivetbyId(41);
        assertEquals(p.getValor(), new BigDecimal("2.80"));
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
        List<Produto> produtos = icrud.retriveByName("Arroz");
        assertTrue(produtos.size() > 0);
    }

    @Test
    public void deveRecurarUmVendedor() {
        ICRUD<Vendedor> icrud = new VendedorDAO(new JPAUtil().getManager());
        //icrud.create(new Vendedor("PompeuLimp", "00311920179", "011182"));
        Vendedor vendedor = icrud.retrivetbyId(5);
        assertEquals(vendedor.getPkvendedores(), 5, 0);
    }

    @Test
    public void deveRecucperarUmVendedorPeloNome() {
        ICRUD<Vendedor> icrud = new VendedorDAO(new JPAUtil().getManager());
        //icrud.create(new Vendedor("PompeuLimp", "00311920179", "011182"));
        List<Vendedor> vendedores = icrud.retriveByName("Pompeu");

        assertFalse(vendedores.isEmpty());
    }

}
