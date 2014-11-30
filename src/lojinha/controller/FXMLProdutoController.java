/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha.controller;

import java.math.BigDecimal;
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
import lojinha.model.Produto;
import lojinha.model.dao.ICRUD;


/**
 * FXML Controller class
 *
 * @author pompeu
 */
public class FXMLProdutoController implements Initializable {

    @FXML
    private TextField tfValor;
    @FXML
    private TextField tfDescricao;
    @FXML
    private TextField tfEstoque;
    @FXML
    private TableView<Produto> tbProdutos;
    private final ObservableList<Produto> listaProdutos = FXCollections.observableArrayList();
    @FXML
    private TableColumn tcDescricao;
    @FXML
    private TableColumn tcValor;
    @FXML
    private TableColumn tcEstoque;
    @FXML
    private Button btnAddProduto;
    @FXML
    private Button btnRemoveProduto;
    @FXML
    private Button btnBuscarProduto;
    @FXML
    private TextField tfBuscar;
    private ICRUD<Produto> icrud;
    private List<Produto> produtos;
    private Produto produto;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initListItens();
        initItens();
    }

    private void initListItens() {
        tcValor.setCellValueFactory(new PropertyValueFactory("valor"));
        tcDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        tcEstoque.setCellValueFactory(new PropertyValueFactory("estoque"));

        tbProdutos.setItems(listaProdutos);
    }

    private void initItens() {
        btnAddProduto.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (campusValidos(tfValor.getText(), tfDescricao.getText(), tfEstoque.getText())) {

                    produto = new Produto(new BigDecimal(tfValor.getText()),
                            tfDescricao.getText(), Integer.parseInt(tfEstoque.getText()));
                    System.out.println(produto.toString());
                    listaProdutos.add(produto);
                }
            }
        });

    }

    private boolean campusValidos(String tfValor, String tfDescricao, String tfEstoque) {
        return !(tfValor.matches("^\\d{1,2}\\.\\d{2}$")
                && tfDescricao.matches("^\\w+$")
                && tfEstoque.matches("^\\d{1,3}$"));
    }
}
