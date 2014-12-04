/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.DAO;

import javax.persistence.EntityManager;
import lojinha.model.Cliente;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.dao.RefletionObjeto;
import lojinha.model.validator.Validador;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pompeu
 */
public class TestarNoation {

    @Test(expected = Exception.class)
    public void oNomeDeveSeralido() throws Exception {
        Cliente c = new Cliente();
        c.setNomeFantasia("Pompeu12 li2mp");
        Validador.Valida(c);
        assertEquals(c, c);
    }

    @Test
    public void nomeValido() throws Exception {
        Cliente c = new Cliente();
        c.setNomeFantasia("Jose Euripedes Silva");
        Validador.Valida(c);
        assertEquals(c.getNomeFantasia(), "Jose Euripedes Silva");
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
        
        assertEquals(41, RefletionObjeto.getIdObjeto(c), 0.000000001);
        assertEquals(32, RefletionObjeto.getIdObjeto(c2), 0.000000001);
        assertEquals(37, RefletionObjeto.getIdObjeto(c3), 0.000000001);
    }

}
