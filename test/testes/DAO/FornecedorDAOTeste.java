/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.DAO;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import lojinha.model.EnderecoFornecedor;
import lojinha.model.Estados;
import lojinha.model.Fornecedor;
import lojinha.model.JPA.JPAUtil;
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
        TelefoneFornecedor tf2 = new TelefoneFornecedor("63", "44263456", f);
        EnderecoFornecedor ef = new EnderecoFornecedor("Prox", "tal num t", "Uberlandia", "centro",
                "73458963", Estados.Minas_Gerais.name(), f);
        
        
        List<TelefoneFornecedor> telefoneFornecedors = new ArrayList<>();
        List<EnderecoFornecedor> enderecoFornecedors = new ArrayList<>();
        
        telefoneFornecedors.add(tf);
        telefoneFornecedors.add(tf2);
        enderecoFornecedors.add(ef);

        f.setTelefonefornecedoresList(telefoneFornecedors);
        f.setEnderecofornecedorList(enderecoFornecedors);

        assertEquals(2,f.getTelefonefornecedoresList().size());
        assertEquals(1,f.getEnderecofornecedorList().size() );
        
        EntityManager em = new JPAUtil().getManager();
        em.getTransaction().begin();
        em.persist(f);
        em.getTransaction().commit();
        em.close();
    }
}
