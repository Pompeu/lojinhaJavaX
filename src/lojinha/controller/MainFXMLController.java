/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import lojinha.Main;

/**
 * FXML Controller class
 *
 * @author pompeu
 */
public class MainFXMLController implements Initializable {
    
    @FXML
    private Menu mCadastro;
    @FXML
    private MenuItem mFechar;
    @FXML
    private Menu mCadastros;
    @FXML
    private MenuItem mCadCliente;
    @FXML
    private MenuItem mCadVendedor;
    @FXML
    private MenuItem mCadFornecedor;
    @FXML
    private MenuItem mCadProduto;
    @FXML
    private Menu mMovimentacao;
    @FXML
    private MenuItem mVendas;
    private final Main main = new Main();
    @FXML
    private MenuItem mVendas2;
    @FXML
    private MenuItem mVendas3;
    @FXML
    private Menu mHelp;
    @FXML
    private MenuItem mAboutUs;
    @FXML
    private MenuItem mCompras;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initItens();
    }    
    
    private void initItens() {
        mFechar.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.exit(0);
            }
        });
        
        mCadCliente.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    main.cadastroCliente(new Stage());
                } catch (IOException ex) {
                    Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        mCadFornecedor.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    main.cadastroFornecedor(new Stage());
                } catch (IOException ex) {
                    Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        mCadVendedor.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                try {
                    main.cadastroVendedor(new Stage());
                } catch (IOException ex) {
                    Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        mCadProduto.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                try {
                    main.cadastroProduto(new Stage());
                } catch (IOException ex) {
                    Logger.getLogger(MainFXMLController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
}
