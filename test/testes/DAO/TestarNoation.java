/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.DAO;

import javax.persistence.EntityManager;
import lojinha.model.Cliente;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.dao.PegarPkKeyTempoExecucao;
import org.junit.Test;
import static org.junit.Assert.*;
import validadores.Validador;

/**
 *
 * @author pompeu
 */
public class TestarNoation {

    @Test(expected = Exception.class)
    public void testarNomeClienteInvalido() throws Exception {
        Cliente c = new Cliente();
        c.setNome("Pompeu12 li2mp");
        Validador.valida(c);
        
    }

    @Test
    public void testarNomeClienteValido() throws Exception {
        Cliente c = new Cliente();
        c.setNome("Jose Euripedes Silva");
        c.setCnpj("18457207000155");
        Validador.valida(c);
        assertEquals(c.getNome(), "Jose Euripedes Silva");
    }

    @Test
    public void deveRetornarAtribultoIDdeUmaEntity() {
        EntityManager em = new JPAUtil().getManager();

        Cliente c = em.find(Cliente.class, 41);
        Cliente c2 = em.find(Cliente.class, 32);
        Cliente c3 = em.find(Cliente.class, 37);

        assertEquals(c.getPkcliente(), 41, 0.000000001);
        assertEquals(c2.getPkcliente(), 32, 0.000000001);
        assertEquals(c3.getPkcliente(), 37, 0.000000001);
        
        assertEquals(41, PegarPkKeyTempoExecucao.getIdObjeto(c), 0.000000001);
        assertEquals(32, PegarPkKeyTempoExecucao.getIdObjeto(c2), 0.000000001);
        assertEquals(37, PegarPkKeyTempoExecucao.getIdObjeto(c3), 0.000000001);
    }

}
