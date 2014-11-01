/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.dao;

import java.util.List;

/**
 *
 * @author pompeu
 * @param <T>
 */
public interface ICRUD<T> {

    public T create(T obj);

    public T update(T obj);

    public T delete(T obj);

    public List<T> retrivetAll();

    public List<T> retrivetAllbyName(String name);

    public T retrivetbyId(long Id);
}
