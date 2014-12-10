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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lojinha.controller.validator.Validador;
import lojinha.model.EnderecoFornecedor;
import lojinha.model.Estados;
import lojinha.model.Fornecedor;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.TelefoneFornecedor;
import lojinha.model.dao.DAO;

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
    private DAO<Fornecedor> icrud;
    private DAO<TelefoneFornecedor> icrudTDao;
    private DAO<EnderecoFornecedor> icrudEDao;

    @FXML
    private TableView<Fornecedor> tbFonecedores;
    private final ObservableList<Fornecedor> listaFonercedores = FXCollections.observableArrayList();
    private List<Fornecedor> fornecedores;
    @FXML
    private TableColumn tcNome;
    @FXML
    private TextField tfBuscar;
    @FXML
    private Button btnBuscarRazao;

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
        validarCampus();
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

                limparCampus();
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
                icrudEDao = new DAO<EnderecoFornecedor>(EnderecoFornecedor.class, new JPAUtil().getManager());
                icrudEDao.delete(ef);
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
                icrudTDao = new DAO<TelefoneFornecedor>(TelefoneFornecedor.class, new JPAUtil().getManager());
                icrudTDao.delete(tf);
            }
        });
        btnGravar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                fornecedor.setCnpj(tfCNPJ.getText());
                fornecedor.setNome(tfNomeFantasia.getText());
                fornecedor.setRazaoSocial(tfRazaoSocial.getText());
                fornecedor.setEnderecofornecedorList(listaEnderecos);
                fornecedor.setTelefonefornecedoresList(listaTelefones);

                icrud = new DAO(Fornecedor.class, new JPAUtil().getManager());
                if (fornecedor.getPkfornecedores() == null) {
                    icrud.create(fornecedor);
                } else {
                    icrud.update(fornecedor);
                }
            }
        });

        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                icrud = new DAO(Fornecedor.class, new JPAUtil().getManager());
                fornecedor = icrud.retriveByCNPJOrCPF(tfCNPJ.getText());
                limparCampus();
                prencherFormulario(fornecedor);
            }

        });

        tfBuscar.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        icrud = new DAO<>(Fornecedor.class, new JPAUtil().getManager());
                        fornecedores = icrud.retriveByName(tfBuscar.getText());
                        listaFonercedores.setAll(fornecedores);
                    }
                }).start();
            }
        });
        tbFonecedores.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                fornecedor = tbFonecedores.getSelectionModel().getSelectedItem();
                limparCampus();
                prencherFormulario(fornecedor);
                listaFonercedores.clear();
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

        tcNome.setCellValueFactory(new PropertyValueFactory("nome"));

        tbFonecedores.setItems(listaFonercedores);
        tbEnderecos.setItems(listaEnderecos);
        tbTelefone.setItems(listaTelefones);
    }

    private void limparCampus() {
        tfComplemento.clear();
        tfLogradouro.clear();
        tfCidade.clear();
        tfBairro.clear();
        tfCep.clear();
        cbEstados.setValue(null);

        tfNumero.clear();
        tfDDD.clear();

        listaEnderecos.clear();
        listaTelefones.clear();
        listaFonercedores.clear();
    }

    private void prencherFormulario(Fornecedor fornecedor) {
        tfRazaoSocial.setText(fornecedor.getRazaoSocial());
        tfNomeFantasia.setText(fornecedor.getNome());
        tfCNPJ.setText(fornecedor.getCnpj());
        listaEnderecos.addAll(fornecedor.getEnderecofornecedorList());
        listaTelefones.addAll(fornecedor.getTelefonefornecedoresList());
    }

    private void validarCampus() {

        tfNomeFantasia.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(30));
        tfRazaoSocial.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(30));
        tfCNPJ.addEventFilter(KeyEvent.KEY_TYPED, Validador.numeros(14));

        tfComplemento.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(30));
        tfLogradouro.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(30));
        tfCidade.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(30));
        tfBairro.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(30));
        tfCep.addEventFilter(KeyEvent.KEY_TYPED, Validador.numeros(8));

        tfDDD.addEventFilter(KeyEvent.KEY_TYPED, Validador.numeros(3));
        tfNumero.addEventFilter(KeyEvent.KEY_TYPED, Validador.numeros(9));

        tfBuscar.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(20));
    }

}
