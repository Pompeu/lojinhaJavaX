/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.DAO;

import java.util.ArrayList;
import java.util.List;
import lojinha.model.EnderecoFornecedor;
import lojinha.model.Estados;
import lojinha.model.Fornecedor;
import lojinha.model.TelefoneFornecedor;
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
public class FornecedorDAOTeste {

    public FornecedorDAOTeste() {
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
    public void deveCriarUmFornecedorNoSistema() {
        Fornecedor f = new Fornecedor();
        f.setCnpj("02003002000178");
        f.setNomeFantasia("CTBC");
        f.setRazaoSocial("Algarelecom");
        TelefoneFornecedor tf = new TelefoneFornecedor("64", "34442526", f);
        EnderecoFornecedor ef = new EnderecoFornecedor("Prox", "tal num t", "Uberlandia", "centro",
                "73458963", Estados.Minas_Gerais.name(), f);

//        f.getEnderecofornecedorList().add(ef);
//        f.getTelefonefornecedoresList().add(tf);
        
        System.out.println(f.toString());
        System.out.println(tf.toString());
        System.out.println(ef.toString());
        
        assertEquals(f.getEnderecofornecedorList().size(), 1);
        assertEquals(f.getTelefonefornecedoresList().size(), 1);

    }
}
