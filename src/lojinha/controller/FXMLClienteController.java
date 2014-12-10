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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import lojinha.controller.validator.Validador;
import lojinha.model.Cliente;
import lojinha.model.EnderecoCliente;
import lojinha.model.Estados;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.TelefoneCliente;
import lojinha.model.dao.NAOUSADOS.ClienteDAO;
import lojinha.model.dao.DAO;

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
    private Button btnDeletarTelefone;
    @FXML
    private TableView<TelefoneCliente> tableTelefone;
    private final ObservableList<TelefoneCliente> listaTelefones = FXCollections.observableArrayList();
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
    @FXML
    private Button btnBuscar;
    private DAO<Cliente> crudCliente;
    private Cliente cliente = new Cliente();
    @FXML
    private AnchorPane AchorPaneCliente;
    @FXML
    private Button btnBuscarRazao;
    @FXML
    private TextField tfBucar;
    @FXML
    private TableView<Cliente> tbCliente;
    private final ObservableList<Cliente> listaClientes = FXCollections.observableArrayList();
    private List<Cliente> clientes;
    @FXML
    private TableColumn tcRazao;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableItens();
        initActionItens();
        validarCampus();

    }

    private void initActionItens() {

        btnSalvarEnderco.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                if (verificaEnderecoRepetidos(tfLogradouro.getText(), cbEstados.getValue().toString())) {
                    listaEnderecos.add(new EnderecoCliente(tfLogradouro.getText(), cbEstados.getValue().toString(), cliente));
                }
                cliente.setEnderecoClienteList(listaEnderecos);

                tfLogradouro.setText("");
                cbEstados.setValue(null);
            }

            private boolean verificaEnderecoRepetidos(String logradouro, String estado) {
                for (EnderecoCliente eCliente : listaEnderecos) {
                    if (eCliente.getLogradouro().equals(logradouro)
                            && eCliente.getEstado().equals(estado)) {
                        return false;
                    }
                }
                return true;
            }

        });
        btnDeletarEndereco.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                EnderecoCliente ec = tableEnderecos.getSelectionModel().getSelectedItem();
                listaEnderecos.remove(ec);
                cliente.getEnderecoClienteList().remove(ec);
            }
        });

        tableEnderecos.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                tfLogradouro.setText(tableEnderecos.getSelectionModel().getSelectedItem().getLogradouro());
                cbEstados.setValue(tableEnderecos.getSelectionModel().getSelectedItem().getEstado());
            }

        });
        btnSalvarTelefone.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (verificaTelefonesRepetidos(tfDDD.getText(), tfNumeroTelefone.getText())) {
                    listaTelefones.add(new TelefoneCliente(tfDDD.getText(), tfNumeroTelefone.getText(), cliente));
                }
                cliente.setTelefoneClienteList(listaTelefones);
                if (listaTelefones.size() > 0) {
                    btnGravarCliente.setDisable(false);
                }
                tfDDD.setText("");
                tfNumeroTelefone.setText("");
            }

            private boolean verificaTelefonesRepetidos(String ddd, String telefone) {
                for (TelefoneCliente telefoneCliente : listaTelefones) {
                    if (telefoneCliente.getDdd().equals(ddd)
                            && telefoneCliente.getNumero().equals(telefone)) {
                        return false;
                    }
                }
                return true;
            }
        });

        btnDeletarTelefone.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                TelefoneCliente tc = tableTelefone.getSelectionModel().getSelectedItem();
                listaTelefones.remove(tc);
                cliente.getTelefoneClienteList().remove(tc);
            }
        });
        tableTelefone.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                tfDDD.setText(tableTelefone.getSelectionModel().getSelectedItem().getDdd());
                tfNumeroTelefone.setText(tableTelefone.getSelectionModel().getSelectedItem().getNumero());
            }

        });
        btnGravarCliente.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                cliente.setCnpj(tfCnpj.getText());
                cliente.setNome(tfNomeFantasia.getText());
                cliente.setRazaoSocial(tfRazaSocial.getText());

                crudCliente = new DAO<>(Cliente.class, new JPAUtil().getManager());
                if (cliente.getPkcliente() == null) {
                    crudCliente.create(cliente);
                } else {
                    crudCliente.update(cliente);
                }

            }
        });
        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                crudCliente = new DAO<>(Cliente.class, new JPAUtil().getManager());
                cliente = crudCliente.retriveByCNPJOrCPF(tfCnpj.getText());
                limparCampus();
                prencherFormulario(cliente);

            }

        });
        tfBucar.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        crudCliente = new DAO<>(Cliente.class, new JPAUtil().getManager());
                        clientes = crudCliente.retriveByName(tfBucar.getText());
                        listaClientes.clear();
                        listaClientes.addAll(clientes);
                    }
                }).start();
            }
        });

    

        tbCliente.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (!tbCliente.getSelectionModel().isEmpty()) {
                    cliente = tbCliente.getSelectionModel().getSelectedItem();
                    limparCampus();
                    prencherFormulario(cliente);
                    listaClientes.clear();
                }
            }

        });

    }

    private void initTableItens() {
        cbEstados.setItems(FXCollections.observableArrayList(Estados.values()));

        tcDDD.setCellValueFactory(new PropertyValueFactory("ddd"));
        tcNumero.setCellValueFactory(new PropertyValueFactory("numero"));

        tcEstado.setCellValueFactory(new PropertyValueFactory("estado"));
        tcLogradouro.setCellValueFactory(new PropertyValueFactory("logradouro"));

        tcRazao.setCellValueFactory(new PropertyValueFactory("nome"));

        tbCliente.setItems(listaClientes);
        tableEnderecos.setItems(listaEnderecos);
        tableTelefone.setItems(listaTelefones);
    }

    private void validarCampus() {
        tfRazaSocial.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(30));
        tfLogradouro.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(30));
        tfNomeFantasia.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(30));

        tfCnpj.addEventFilter(KeyEvent.KEY_TYPED, Validador.numeros(14));
        tfDDD.addEventFilter(KeyEvent.KEY_TYPED, Validador.numeros(2));
        tfNumeroTelefone.addEventFilter(KeyEvent.KEY_TYPED, Validador.numeros(9));

        tfBucar.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(15));

    }

    private void prencherFormulario(Cliente cliente) {

        tfNomeFantasia.setText(cliente.getNome());
        tfCnpj.setText(cliente.getCnpj());
        tfRazaSocial.setText(cliente.getRazaoSocial());
        listaEnderecos.addAll(cliente.getEnderecoClienteList());
        listaTelefones.addAll(cliente.getTelefoneClienteList());
    }

    private void limparCampus() {
        listaEnderecos.clear();
        listaTelefones.clear();

    }
}
