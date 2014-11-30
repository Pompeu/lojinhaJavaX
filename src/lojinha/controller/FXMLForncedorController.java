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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lojinha.model.EnderecoCliente;
import lojinha.model.EnderecoFornecedor;
import lojinha.model.Estados;
import lojinha.model.Fornecedor;
import lojinha.model.TelefoneCliente;

/**
 * FXML Controller class
 *
 * @author pompeu
 */
public class FXMLForncedorController implements Initializable {

    @FXML
    private TextField tfCNPJ;
    @FXML
    private ComboBox cbEstados;
    @FXML
    private TableView<EnderecoFornecedor> tbEnderecos;
    private final ObservableList<EnderecoFornecedor> listaEnderecos = FXCollections.observableArrayList();
    @FXML
    private TableColumn tcComplemento;
    @FXML
    private TableColumn tcLogradouro;
    @FXML
    private TableColumn tcCidade;
    @FXML
    private TableColumn tcBairro;
    @FXML
    private TableColumn tcCep;
    @FXML
    private TableColumn tcEsdado;
    @FXML
    private TableView<TelefoneCliente> tbTelefone;
    private final ObservableList<TelefoneCliente> listaTelefones = FXCollections.observableArrayList();
    @FXML
    private TableColumn tcDDD;
    @FXML
    private TableColumn tcNumero;
    @FXML
    private TextField tfRazaoSocial;
    @FXML
    private TextField tfNomeFantasia;
    @FXML
    private TextField tfCidade;
    @FXML
    private TextField tfComplemento;
    @FXML
    private TextField tfLogradouro;
    @FXML
    private TextField tfCep;
    @FXML
    private TextField tfBairro;
    @FXML
    private Button btnAddEndereco;
    @FXML
    private Button btnRemoveEndereco;
    @FXML
    private TextField tfDDD;
    @FXML
    private TextField tdNumero;
    @FXML
    private Button btnRemoveTelefone;
    @FXML
    private Button btnAddTelefone;
    private Fornecedor fornecedor;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initItensList();
        initItens();
    }

    private void initItens() {
        btnAddEndereco.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                listaEnderecos.add(new EnderecoFornecedor(tfComplemento.getText(),
                        tfLogradouro.getText(), tfCidade.getText(),
                        tfBairro.getText(), tfCep.getText(), cbEstados.getValue().toString(),
                        fornecedor));

                fornecedor.setEnderecofornecedorList(listaEnderecos);
            }
        });
    }

    private void initItensList() {
        cbEstados.setItems(FXCollections.observableArrayList(Estados.values()));

        tcDDD.setCellValueFactory(new PropertyValueFactory("ddd"));
        tcNumero.setCellValueFactory(new PropertyValueFactory("numero"));

        tcLogradouro.setCellValueFactory(new PropertyValueFactory("logradouro"));
        tcBairro.setCellValueFactory(new PropertyValueFactory("bairro"));
        tcCep.setCellValueFactory(new PropertyValueFactory("cep"));
        tcCidade.setCellValueFactory(new PropertyValueFactory("cidade"));
        tcEsdado.setCellValueFactory(new PropertyValueFactory("estado"));
        tcComplemento.setCellValueFactory(new PropertyValueFactory("complemento"));

        tbEnderecos.setItems(listaEnderecos);
        tbTelefone.setItems(listaTelefones);
    }

}
