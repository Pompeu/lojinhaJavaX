/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.model;

/**
 *
 * @author pompeu
 */
public enum Estados {

    Acre, Alagoas, Amapa,
    Amazonas, Bahia, Ceara, Distrito_Federal,
    Espirito_Santo, Goias, Maranhao, Mato_Grosso,
    Mato_Grosso_do_Sul, Minas_Gerais,
    Para, Paraiba, Parana, Pernambuco, Piaui,
    Rio_de_Janeiro, Rio_Grande_do_Norte,
    Rio_Grande_do_Sul, Rondonia, Roraima,
    Santa_Catarina, Sao_Paulo, Sergipe, Tocantins;

    public static String[] names() {
        String[] names = new String[values().length];
        int index = 0;

        for (Estados state : values()) {
            names[index++] = state.name();
        }

        return names;
    }
}
