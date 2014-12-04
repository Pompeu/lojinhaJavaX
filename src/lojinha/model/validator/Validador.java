/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.validator;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/**
 *
 * @author pompeu
 */
public class Validador {

    private Validador() {
    }

    public static void Valida(Object object) throws Exception {

        Class<? extends Object> clazz = object.getClass();

        for (Field atributo : clazz.getDeclaredFields()) {
            atributo.setAccessible(true);
            for (Annotation annotation : atributo.getDeclaredAnnotations()) {

                if (annotation.annotationType() == NomeValido.class) {
                    String nome = (String) atributo.get(object);
                    if (!nome.matches("^[a-zA-Z ]+$")) {
                        throw new ValidatorExeption("String Invalida");
                    }
                }
            }
        }
    }
}
