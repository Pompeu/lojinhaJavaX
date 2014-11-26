/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.DAO;

import java.util.ArrayList;
import java.util.List;
import lojinha.model.Cliente;
import lojinha.model.EnderecoCliente;

import lojinha.model.Estados;

import lojinha.model.TelefoneCliente;
import lojinha.model.dao.ClienteDAO;
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
    private int i = 0;
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
        this.cliente = new Cliente("00001002000278", "lojinha doida", "lojinha doida LTDA");
        this.clienteDAO = new ClienteDAO();
        
        System.out.println(i++);
    }

    @After
    public void tearDown() {
    }

    @Test(expected = RuntimeException.class)
    public void deveGravarumClienteNoBanco() {

        EnderecoCliente endereco = new EnderecoCliente("Rua Tal 1", Estados.Goias.name(), cliente);
        EnderecoCliente endereco2 = new EnderecoCliente("Rua Tal 2", Estados.Minas_Gerais.name(), cliente);
        EnderecoCliente endereco3 = new EnderecoCliente("Rua Tal 3", Estados.Sao_Paulo.name(), cliente);
        List<EnderecoCliente> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        enderecos.add(endereco2);
        enderecos.add(endereco3);

        cliente.setEnderecoClienteList(enderecos);

        List<TelefoneCliente> telefones = new ArrayList<>();

        TelefoneCliente telefone = new TelefoneCliente("64", "34441126", cliente);
        TelefoneCliente telefone2 = new TelefoneCliente("62", "34443326", cliente);
        TelefoneCliente telefone3 = new TelefoneCliente("11", "34444426", cliente);

        telefones.add(telefone);
        telefones.add(telefone2);
        telefones.add(telefone3);

        cliente.setTelefoneClienteList(telefones);

        clienteDAO = new ClienteDAO();
        clienteDAO.create(cliente);

    }

    @Test
    public void deveAtualizarUCliente() {

        EnderecoCliente endereco = new EnderecoCliente("Rua Tal 11", Estados.Goias.name(), cliente);
        endereco.setPkendereco(5);
        EnderecoCliente endereco2 = new EnderecoCliente("Rua Tal 12", Estados.Minas_Gerais.name(), cliente);
        endereco2.setPkendereco(6);
        EnderecoCliente endereco3 = new EnderecoCliente("Rua Tal 23", Estados.Sao_Paulo.name(), cliente);
        endereco3.setPkendereco(7);
        List<EnderecoCliente> enderecos = new ArrayList<>();
        enderecos.add(endereco);
        enderecos.add(endereco2);
        enderecos.add(endereco3);

        cliente.setEnderecoClienteList(enderecos);

        List<TelefoneCliente> telefones = new ArrayList<>();

        TelefoneCliente telefone = new TelefoneCliente("64", "34442222", cliente);
        telefone.setPktelefone(5);
        TelefoneCliente telefone2 = new TelefoneCliente("62", "34443333", cliente);
        telefone2.setPktelefone(6);
        TelefoneCliente telefone3 = new TelefoneCliente("11", "34444444", cliente);
        telefone3.setPktelefone(7);
        telefones.add(telefone);
        telefones.add(telefone2);
        telefones.add(telefone3);

        cliente.setTelefoneClienteList(telefones);
        cliente.setPkcliente(3);

        clienteDAO = new ClienteDAO();
        clienteDAO.create(cliente);
    }

    @Test
    public void deveDeletarUmCliente() {
        
        System.out.println(clienteDAO.retrivetbyId(3).toString());
    }
}
