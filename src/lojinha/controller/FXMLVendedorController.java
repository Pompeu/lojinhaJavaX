/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lojinha.model.Vendedor;

/**
 * FXML Controller class
 *
 * @author pompeu
 */
public class FXMLVendedorController implements Initializable {

    @FXML
    private TextField tfNome;
    @FXML
    private TextField tfCPF;
    @FXML
    private TextField tfNascimento;
    @FXML
    private TableView<Vendedor> tbVendedor;
    private final ObservableList<Vendedor> listVendedores = FXCollections.observableArrayList();
    @FXML
    private TableColumn tcNome;
    @FXML
    private TableColumn tcCPF;
    @FXML
    private TableColumn tcNascimento;
    @FXML
    private Button btnGravar;
    @FXML
    private Button btnVendedor;
    @FXML
    private Button btnBuscar;
    @FXML
    private TextField tfBusca;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      initTableIntens();
    }

    private void initTableIntens() {
        tcCPF.setCellValueFactory(new PropertyValueFactory("cpf"));
        tcNascimento.setCellValueFactory(new PropertyValueFactory("nascimento"));
        tcNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tbVendedor.setItems(listVendedores);
    }

}
