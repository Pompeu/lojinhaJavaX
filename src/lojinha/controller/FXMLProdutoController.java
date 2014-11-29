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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lojinha.model.Produto;

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
    private final ObservableList<Produto> produtos = FXCollections.observableArrayList();
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
    private TextField tfEstoque1;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initListItens();
    }

    private void initListItens() {
        tcValor.setCellValueFactory(new PropertyValueFactory("valor"));
        tcDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        tcEstoque.setCellValueFactory(new PropertyValueFactory("Estoque"));
        tbProdutos.setItems(produtos);
    }

}
