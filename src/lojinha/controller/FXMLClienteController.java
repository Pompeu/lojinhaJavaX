/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import lojinha.model.Estados;

/**
 * FXML Controller class
 *
 * @author pompeu
 */
public class FXMLClienteController implements Initializable {

    @FXML
    private TextField tfRazaSocial;
    @FXML
    private TextField tfNomeFantasia;
    @FXML
    private TextField tfCnpj;
    @FXML
    private Label iMenssage;
    @FXML
    private Button btnSalvarEnderco;
    @FXML
    private Button btnDeletarEndereco;
    @FXML
    private Button btnEdicatarEndereco;
    @FXML
    private TextField tfLogradouro;
    @FXML
    private TableView<?> tableEnderecos;
    @FXML
    private TextField tfNumeroTelefone;
    @FXML
    private Button btnSalvarTelefone;
    @FXML
    private Button btnEdicatarTelefone;
    @FXML
    private Button btnDeletarTelefone;
    @FXML
    private TableView<?> tableTelefone;
    @FXML
    private Button btnGravarCliente;
    @FXML
    private ComboBox cbEstados;
    @FXML
    private TextField tfDDD;
    
     
    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cbEstados.setItems(FXCollections.observableArrayList(Estados.values()));
        initItens();
    }

    private void initItens() {
       
    }
}
