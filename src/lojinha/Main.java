/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lojinha;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author pompeu
 */
public class Main extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/lojinha/view/MainFXML.fxml"));
        FXMLLoader.load(getClass().getResource("/lojinha/view/FXMLClienteView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Menu Principal");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    public void cadastroCliente(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lojinha/view/FXMLClienteView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Cadastro Clientes");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void cadastroProduto(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lojinha/view/FXMLProdutoView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Cadastro Produtos");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void cadastroVendedor(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lojinha/view/FXMLVendedorView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Cadastro Vendedor");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void cadastroFornecedor(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("/lojinha/view/FXMLForncedorView.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Cadastro Forncedor");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
}
