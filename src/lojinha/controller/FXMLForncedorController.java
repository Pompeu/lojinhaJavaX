/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.controller;

import java.net.URL;
import java.util.List;
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
import javafx.scene.input.MouseEvent;
import lojinha.model.EnderecoFornecedor;
import lojinha.model.Estados;
import lojinha.model.Fornecedor;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.TelefoneFornecedor;
import lojinha.model.dao.FornecedorDAO;
import lojinha.model.dao.ICRUD;

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
    private TableView<TelefoneFornecedor> tbTelefone;
    private final ObservableList<TelefoneFornecedor> listaTelefones = FXCollections.observableArrayList();
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
    private Button btnRemoveTelefone;
    @FXML
    private Button btnAddTelefone;
    @FXML
    private TextField tfNumero;
    @FXML
    private Button btnGravar;
    @FXML
    private Button btnBuscar;
    private Fornecedor fornecedor = new Fornecedor();
    private ICRUD<Fornecedor> icrud;
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
                if (refirifcaEnderecoRepetido(tfCep.getText(), tfLogradouro.getText())) {
                    listaEnderecos.add(new EnderecoFornecedor(tfComplemento.getText(),
                            tfLogradouro.getText(), tfCidade.getText(),
                            tfBairro.getText(), tfCep.getText(), cbEstados.getValue().toString(),
                            fornecedor));
                }

                limparCampusEndereco();
            }

            boolean refirifcaEnderecoRepetido(String cpf, String logradouro) {
                for (EnderecoFornecedor endereco : listaEnderecos) {
                    if (endereco.getCep().equals(cpf)) {
                        if (endereco.getLogradouro().equals(logradouro)) {
                            return false;
                        }
                    }
                }
                return true;
            }

        });
        btnRemoveEndereco.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                EnderecoFornecedor ef = tbEnderecos.getSelectionModel().getSelectedItem();
                listaEnderecos.remove(ef);
                fornecedor.getEnderecofornecedorList().remove(ef);
            }
        });

        tbEnderecos.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                tfComplemento.setText(tbEnderecos.getSelectionModel().getSelectedItem().getComplemento());
                tfLogradouro.setText(tbEnderecos.getSelectionModel().getSelectedItem().getLogradouro());
                tfCidade.setText(tbEnderecos.getSelectionModel().getSelectedItem().getCidade());
                tfBairro.setText(tbEnderecos.getSelectionModel().getSelectedItem().getBairro());
                tfCep.setText(tbEnderecos.getSelectionModel().getSelectedItem().getCep());
                cbEstados.setValue(tbEnderecos.getSelectionModel().getSelectedItem().getEstado());
            }
        });
        btnAddTelefone.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (verificarTelefonesRepetidos(tfDDD.getText(), tfNumero.getText())) {
                    listaTelefones.add(new TelefoneFornecedor(tfDDD.getText(), tfNumero.getText(), fornecedor));
                }
            }

            private boolean verificarTelefonesRepetidos(String ddd, String numero) {
                for (TelefoneFornecedor telefone : listaTelefones) {
                    if (telefone.getDdd().equals(ddd)) {
                        if (telefone.getNumero().equals(numero)) {
                            return false;
                        }
                    }
                }
                return true;
            }
        });
        tbTelefone.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                tfDDD.setText(tbTelefone.getSelectionModel().getSelectedItem().getDdd());
                tfNumero.setText(tbTelefone.getSelectionModel().getSelectedItem().getNumero());
            }
        });
        btnRemoveTelefone.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                TelefoneFornecedor tf = tbTelefone.getSelectionModel().getSelectedItem();
                listaTelefones.remove(tf);
                fornecedor.getTelefonefornecedoresList().remove(tf);
            }
        });
        btnGravar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fornecedor.setCnpj(tfCNPJ.getText());
                fornecedor.setNomeFantasia(tfNomeFantasia.getText());
                fornecedor.setRazaoSocial(tfRazaoSocial.getText());
                fornecedor.setEnderecofornecedorList(listaEnderecos);
                fornecedor.setTelefonefornecedoresList(listaTelefones);

                icrud = new FornecedorDAO(new JPAUtil().getManager());
                icrud.create(fornecedor);
            }
        });

        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                icrud = new FornecedorDAO(new JPAUtil().getManager());
                fornecedor = icrud.retriveByCNPJOrCPF(tfCNPJ.getText());
                prencherFormulario(fornecedor);
            }

            private void prencherFormulario(Fornecedor fornecedor) {
                tfRazaoSocial.setText(fornecedor.getRazaoSocial());
                tfNomeFantasia.setText(fornecedor.getNomeFantasia());
                tfCNPJ.setText(fornecedor.getCnpj());
                listaEnderecos.addAll(fornecedor.getEnderecofornecedorList());
                listaTelefones.addAll(fornecedor.getTelefonefornecedoresList());
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

    private void limparCampusEndereco() {
        tfComplemento.setText("");
        tfLogradouro.setText("");
        tfCidade.setText("");
        tfBairro.setText("");
        tfCep.setText("");
        cbEstados.setValue(null);
    }

}
