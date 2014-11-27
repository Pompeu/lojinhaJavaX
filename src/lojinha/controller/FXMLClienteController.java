/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.controller;


import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lojinha.model.EnderecoCliente;
import lojinha.model.Estados;
import lojinha.model.TelefoneCliente;

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
    private TableView<EnderecoCliente> tableEnderecos;
    private final ObservableList<EnderecoCliente> listaEnderecos = FXCollections.observableArrayList();
    @FXML
    private TableColumn tcLogradouro;
    @FXML
    private TableColumn tcEstado;
    @FXML
    private TextField tfNumeroTelefone;
    @FXML
    private Button btnSalvarTelefone;
    @FXML
    private Button btnEdicatarTelefone;
    @FXML
    private Button btnDeletarTelefone;
    @FXML
    private TableView<TelefoneCliente> tableTelefone;
    private final ObservableList<TelefoneCliente> listaTelefones =  FXCollections.observableArrayList();
    @FXML
    private TableColumn tcDDD;
    @FXML
    private TableColumn tcNumero;
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
        initItens();
    }

    private void initItens() {
        cbEstados.setItems(FXCollections.observableArrayList(Estados.values()));

        tcDDD.setCellValueFactory(new PropertyValueFactory("ddd"));
        tcNumero.setCellValueFactory(new PropertyValueFactory("numero"));

        tcEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        tcLogradouro.setCellValueFactory(new PropertyValueFactory("logradouro"));

        tableEnderecos.setItems(listaEnderecos);
        tableTelefone.setItems(listaTelefones);

        btnSalvarTelefone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                listaTelefones.add(new TelefoneCliente(tfDDD.getText(), tfNumeroTelefone.getText(),null));
            }
        });
        
        btnSalvarEnderco.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                listaEnderecos.add(new EnderecoCliente(tfLogradouro.getText(), cbEstados.getValue().toString(), null));
            }
        });
        tableTelefone.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
               tfDDD.setText(tableTelefone.getSelectionModel().getSelectedItem().getDdd());
               tfNumeroTelefone.setText(tableTelefone.getSelectionModel().getSelectedItem().getNumero());
            }
            
        });
        tableEnderecos.setOnMouseClicked(new EventHandler<MouseEvent>(){

            @Override
            public void handle(MouseEvent event) {
                tfLogradouro.setText(tableEnderecos.getSelectionModel().getSelectedItem().getLogradouro());
                cbEstados.setValue(tableEnderecos.getSelectionModel().getSelectedItem().getEstado());
            }
            
        });
    }
}
