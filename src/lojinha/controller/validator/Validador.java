/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.controller.validator;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

/**
 *
 * @author pompeu
 */
public class Validador {

    private Validador() {
    }

    public static EventHandler numeros(final Integer max_Lengh) {
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                keyHandle((KeyEvent) event);
            }

            public void keyHandle(KeyEvent event) {
                TextField txt_TextField = (TextField) event.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    event.consume();
                }
                if (event.getCharacter().matches("[0-9]")) {
                } else {
                    event.consume();
                }
            }

        };
    }

    public static EventHandler nome(final Integer max_Lengh) {
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                keyHandle((KeyEvent) event);
            }

            public void keyHandle(KeyEvent e) {
                TextField txt_TextField = (TextField) e.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    e.consume();
                }
                if (e.getCharacter().matches("[a-zA-Z ]")) {

                } else {
                    e.consume();
                }
            }
        };
    }
    
    public static EventHandler valores(final Integer max_Lengh) {
        return new EventHandler() {
            @Override
            public void handle(Event event) {
                keyHandle((KeyEvent) event);
            }

            public void keyHandle(KeyEvent event) {
                TextField txt_TextField = (TextField) event.getSource();
                if (txt_TextField.getText().length() >= max_Lengh) {
                    event.consume();
                }
                if (event.getCharacter().matches("[0-9.]")) {
                } else {
                    event.consume();
                }
            }

        };
    }
}
