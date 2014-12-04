/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model.validator;

import java.io.Serializable;

/**
 *
 * @author pompeu
 */
class ValidatorExeption extends Exception implements Serializable {

    public ValidatorExeption(String string_Invalida) {
        super(string_Invalida);
    }


}
