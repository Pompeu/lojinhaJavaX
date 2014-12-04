/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lojinha.controller.validator.Validador;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.Vendedor;
import lojinha.model.dao.DAO;

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
    private TableView<Vendedor> tbVendedor;
    private final ObservableList<Vendedor> listVendedores = FXCollections.observableArrayList();
    @FXML
    private TableColumn tcpkKey;
    @FXML
    private TableColumn tcNome;
    @FXML
    private TableColumn tcCPF;
    @FXML
    private TableColumn tcNascimento;
    @FXML
    private Button btnGravar;
    @FXML
    private Button btnDeletar;
    @FXML
    private TextField tfBusca;
    private DAO<Vendedor> icrud;
    private Vendedor vendedor;
    private List<Vendedor> venderes;
    @FXML
    private Button btnLimpar;
    @FXML
    private TextField tfData;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableIntens();
        initItens();
        validarCampos();
    }

    private void initTableIntens() {
        tcCPF.setCellValueFactory(new PropertyValueFactory("cpf"));
        tcNascimento.setCellValueFactory(new PropertyValueFactory("nascimento"));
        tcNome.setCellValueFactory(new PropertyValueFactory("nome"));
        tbVendedor.setItems(listVendedores);

    }

    private void initItens() {
        btnGravar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (verificaVendedorRepetidos(tfCPF.getText())
                        && verificarCaposValidos(tfNome.getText(), tfCPF.getText(), tfData.getText())) {

                    vendedor = new Vendedor(tfNome.getText(), tfCPF.getText(), tfData.getText());
                    icrud = new DAO<>(Vendedor.class, new JPAUtil().getManager());

                    icrud.create(vendedor);
                    listVendedores.add(vendedor);
                } else if (!verificaVendedorRepetidos(tfCPF.getText())
                        && verificarCaposValidos(tfNome.getText(), tfCPF.getText(), tfData.getText())) {

                    vendedor = new Vendedor(tfNome.getText(), tfCPF.getText(), tfData.getText());
                    vendedor.setPkvendedores(tbVendedor.getSelectionModel().getSelectedItem().getPkvendedores());
                    icrud = new DAO<>(Vendedor.class, new JPAUtil().getManager());
                    limparCampus();
                    icrud.update(vendedor);
                }

            }

        });

        btnDeletar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                icrud = new DAO<>(Vendedor.class, new JPAUtil().getManager());
                vendedor = new Vendedor(tfNome.getText(), tfCPF.getText(), tfData.getText());
                vendedor.setPkvendedores(tbVendedor.getSelectionModel().getSelectedItem().getPkvendedores());
                icrud.delete(vendedor);
                listVendedores.remove(tbVendedor.getSelectionModel().getSelectedItem());
            }
        });

        tfBusca.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        icrud = new DAO<>(Vendedor.class, new JPAUtil().getManager());
                        venderes = icrud.retriveByName(tfBusca.getText());
                        listVendedores.setAll(venderes);
                    }
                }).start();

            }
        });
        btnLimpar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                limparCampus();
            }

        });
        tbVendedor.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (!tbVendedor.getSelectionModel().isEmpty()) {
                    tfNome.setText(tbVendedor.getSelectionModel().getSelectedItem().getNome());
                    tfCPF.setText(tbVendedor.getSelectionModel().getSelectedItem().getCpf());
                    tfData.setText(tbVendedor.getSelectionModel().getSelectedItem().getNascimento());

                }
            }
        });
    }

    private void limparCampus() {
        tfBusca.clear();
        tfCPF.clear();
        tfNome.clear();
        tfData.clear();
        listVendedores.clear();
    }

    private boolean verificaVendedorRepetidos(String cpf) {
        for (Vendedor vendedor : listVendedores) {
            if (vendedor.getCpf().equals(cpf)) {
                return false;
            }
        }
        return true;
    }

    private boolean verificarCaposValidos(String nome, String cpf, String nacimento) {
        return !(nome.matches("\\[a-zA-Z ]+")
                && cpf.matches("\\d{11}")
                && nacimento.matches("\\d{6}"));
    }

    private void validarCampos() {
        tfData.addEventFilter(KeyEvent.KEY_TYPED, Validador.numeros(8));
        tfCPF.addEventFilter(KeyEvent.KEY_TYPED, Validador.numeros(11));
        tfNome.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(30));
        tfBusca.addEventFilter(KeyEvent.KEY_TYPED, Validador.nome(30));
    }

}
