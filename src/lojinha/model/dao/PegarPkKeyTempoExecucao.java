/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.dao;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Id;

/**
 *
 * @author pompeu
 */
public class PegarPkKeyTempoExecucao {

    private PegarPkKeyTempoExecucao() {
    }
    
    public static Integer getIdObjeto(Object object) {
        Class<? extends Object> clazz = object.getClass();
        Integer id = null;
        for(Field atributo : clazz.getDeclaredFields()){
            atributo.setAccessible(true);
            for (Annotation annotation : atributo.getDeclaredAnnotations()){
                if(annotation.annotationType() == Id.class){
                    try {
                        id = (Integer) atributo.get(object);
                    } catch (IllegalArgumentException | IllegalAccessException ex) {
                        Logger.getLogger(PegarPkKeyTempoExecucao.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        return id;
    }
}
