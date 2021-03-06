/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.dao.NAOUSADOS;

import java.util.List;

/**
 *
 * @author pompeu
 * @param <T>
 */
public interface ICRUD<T> {

    public void create(T obj);

    public void delete(T obj);

    public List<T> retrivetAll();

    public T retrivetbyId(Integer id);

    public List<T> retriveByName(String name);

    public T retriveByCNPJOrCPF(String cnpj);
 

}
