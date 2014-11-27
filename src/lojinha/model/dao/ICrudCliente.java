/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.dao;

import java.util.List;
import lojinha.model.Cliente;

/**
 *
 * @author pompeu
 */
public interface ICrudCliente {
    public void create(Cliente  cliente);

    public void delete(long id);

    public List<Cliente> retrivetAll();

    public Cliente retrivetbyId(Cliente cliente);
}
