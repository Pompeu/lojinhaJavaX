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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.Vendedor;
import lojinha.model.dao.ICRUD;
import lojinha.model.dao.VendedorDAO;

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
    private Button btnBuscar;
    @FXML
    private TextField tfBusca;
    private ICRUD<Vendedor> icrud;
    private Vendedor vendedor;
    private List<Vendedor> venderes;

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
                        && verificarCaposValidos(tfNome.getText(), tfCPF.getText(), tfNascimento.getText())) {

                    vendedor = new Vendedor(tfNome.getText(), tfCPF.getText(), tfNascimento.getText());
                    icrud = new VendedorDAO(new JPAUtil().getManager());
                    icrud.create(vendedor);
                    listVendedores.add(vendedor);
                } else if (!verificaVendedorRepetidos(tfCPF.getText())
                        && verificarCaposValidos(tfNome.getText(), tfCPF.getText(), tfNascimento.getText())) {

                    vendedor = new Vendedor(tfNome.getText(), tfCPF.getText(), tfNascimento.getText());
                    vendedor.setPkvendedores(tbVendedor.getSelectionModel().getSelectedItem().getPkvendedores());
                    icrud = new VendedorDAO(new JPAUtil().getManager());
                    icrud.create(vendedor);
                }

            }

        });

        btnDeletar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                icrud = new VendedorDAO(new JPAUtil().getManager());
                vendedor = new Vendedor(tfNome.getText(), tfCPF.getText(), tfNascimento.getText());
                vendedor.setPkvendedores(tbVendedor.getSelectionModel().getSelectedItem().getPkvendedores());
                icrud.delete(vendedor);
                listVendedores.remove(tbVendedor.getSelectionModel().getSelectedItem());
            }
        });

        btnBuscar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                icrud = new VendedorDAO(new JPAUtil().getManager());
                venderes = icrud.retriveByName(tfBusca.getText());
                listVendedores.setAll(venderes);
            }
        });

        tfBusca.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                listVendedores.clear();
            }
        });

        tbVendedor.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (!tbVendedor.getSelectionModel().isEmpty()) {
                    tfNome.setText(tbVendedor.getSelectionModel().getSelectedItem().getNome());
                    tfCPF.setText(tbVendedor.getSelectionModel().getSelectedItem().getCpf());
                    tfNascimento.setText(tbVendedor.getSelectionModel().getSelectedItem().getNascimento());
                }
            }
        });
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
}
