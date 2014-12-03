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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import lojinha.model.JPA.JPAUtil;
import lojinha.model.Produto;
import lojinha.model.dao.DAO;

/**
 * FXML Controller class
 *
 * @author pompeu
 */
public class FXMLProdutoController implements Initializable {

    @FXML
    private TextField tfDescricao;
    @FXML
    private TextField tfValor;
    @FXML
    private TextField tfEstoque;
    @FXML
    private Button btnGravar;
    @FXML
    private Button btnDeletar;
    @FXML
    private TableView<Produto> tbProdutos;
    private final ObservableList<Produto> listaProdutos = FXCollections.observableArrayList();
    @FXML
    private TableColumn tcDescricao;
    @FXML
    private TableColumn tcEstoque;
    @FXML
    private TableColumn tcValor;
    @FXML
    private TableColumn tcpkKey;
    @FXML
    private TextField tfBusca;
    private Button btnBucar;
    private Produto produto = new Produto();
    private List<Produto> produtos;
    private DAO<Produto> icrud;
    @FXML
    private Button btnLimpar;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initTableItens();
        initItens();
    }

    private void initTableItens() {
        tcDescricao.setCellValueFactory(new PropertyValueFactory("descricao"));
        tcValor.setCellValueFactory(new PropertyValueFactory("valor"));
        tcEstoque.setCellValueFactory(new PropertyValueFactory("estoque"));

        tbProdutos.setItems(listaProdutos);
    }

    private void initItens() {
        tfBusca.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                listaProdutos.clear();
            }
        });
        btnGravar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (verificarProdutoValidos()
                        && verificarCampusIdenticos()) {
                    produto = new Produto(tfDescricao.getText(), new BigDecimal(tfValor.getText()), Integer.parseInt(tfEstoque.getText()));
                    limparCampus();
                    listaProdutos.add(produto);
                    icrud = new DAO<>(Produto.class, new JPAUtil().getManager());
                    icrud.create(produto);
                } else if (tbProdutos.getSelectionModel().getSelectedItem().getPkprodutos() != null) {
                    produto = new Produto(tfDescricao.getText(), new BigDecimal(tfValor.getText()), Integer.parseInt(tfEstoque.getText()));
                    produto.setPkprodutos(tbProdutos.getSelectionModel().getSelectedItem().getPkprodutos());
                    limparCampus();
                    listaProdutos.add(produto);
                    icrud = new DAO<>(Produto.class, new JPAUtil().getManager());
                    icrud.update(produto);
                }
            }

        });
        btnDeletar.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                produto = new Produto(tfDescricao.getText(), new BigDecimal(tfValor.getText()), Integer.parseInt(tfEstoque.getText()));
                produto.setPkprodutos(tbProdutos.getSelectionModel().getSelectedItem().getPkprodutos());
                icrud = new DAO<>(Produto.class, new JPAUtil().getManager());
                produto = icrud.retrivetbyId(produto.getPkprodutos());
                listaProdutos.remove(tbProdutos.getSelectionModel().getSelectedItem());
                icrud.delete(produto);

            }
        });
        tbProdutos.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle(MouseEvent event) {
                if (!tbProdutos.getSelectionModel().isEmpty()) {
                    tfValor.setText(tbProdutos.getSelectionModel().getSelectedItem().getValor().toString());
                    tfDescricao.setText(tbProdutos.getSelectionModel().getSelectedItem().getDescricao());
                    tfEstoque.setText(tbProdutos.getSelectionModel().getSelectedItem().getEstoque().toString());
                }
            }
        });
        tfBusca.setOnKeyPressed(new EventHandler<KeyEvent>() {

            @Override
            public void handle(KeyEvent event) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        icrud = new DAO<>(Produto.class, new JPAUtil().getManager());                       
                        produtos = icrud.retriveByName(tfBusca.getText());
                        listaProdutos.setAll(produtos);
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
    }

    private boolean verificarProdutoValidos() {
        return !(tfValor.getText().matches("^\\d{1,2}\\.\\d{2}$")
                && tfDescricao.getText().matches("^\\w+$")
                && tfEstoque.getText().matches("^\\d{2,3} $"));

    }

    private boolean verificarCampusIdenticos() {
        for (Produto produto : listaProdutos) {
            if (produto.getDescricao().equals(tfDescricao.getText())) {
                return false;
            }
        }

        return true && tbProdutos.getSelectionModel().getSelectedIndex() == -1;
        //return !listaProdutos.stream().noneMatch((produto) -> (produto.getDescricao().equals(tfDescricao.getText())));
    }

    private void limparCampus() {
        listaProdutos.clear();
        tfBusca.clear();
        tfDescricao.clear();
        tfEstoque.clear();
        tfValor.clear();
    }
}
