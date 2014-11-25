/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.DAO;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import lojinha.model.Cliente;
import lojinha.model.EnderecoCliente;

import lojinha.model.Estados;
import lojinha.model.JPA.JPAUtil;

import lojinha.model.TelefoneCliente;
import lojinha.model.dao.ClienteDAO;
import lojinha.model.dao.ICRUD;
import lojinha.model.dao.ICrudCliente;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author pompeu
 */
public class ClienteDAOteste {

    private Cliente cliente;
    private ICrudCliente clienteDAO;

    public ClienteDAOteste() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() {
        this.cliente = new Cliente("00001002000178", "lojinha doida", "lojinha doida LTDA");
        this.clienteDAO = new ClienteDAO();
    }

    @After
    public void tearDown() {
    }

    @Test(expected = RuntimeException.class)
    public void deveGravarumClienteNoBanco() {

        EnderecoCliente endereco = new EnderecoCliente("Rua Tal", Estados.Goias.name(), cliente);
        List<EnderecoCliente> enderecos = new ArrayList<>();
        enderecos.add(endereco);

        cliente.setEnderecoClienteList(enderecos);

        List<TelefoneCliente> telefones = new ArrayList<>();

        TelefoneCliente telefone = new TelefoneCliente("64", "34442526", cliente);

        telefones.add(telefone);
        cliente.setTelefoneClienteList(telefones);

        ICrudCliente clienteDAO = new ClienteDAO();
        clienteDAO.create(cliente, endereco, telefone);

    }

    @Test
    public void deveAtualizarUCliente() {

    }
}
