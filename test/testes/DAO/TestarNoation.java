/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testes.DAO;

import java.awt.BorderLayout;
import lojinha.model.Cliente;
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

   
}
