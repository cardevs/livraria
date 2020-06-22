package livraria.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.swing.*;

public class LivroDetalhesController {


    @FXML
    private Rectangle capa2;

    @FXML
    private Label titulo;

    @FXML
    private Label autor;

    @FXML
    private Label labelDescricao;

    @FXML
    private Label labelEditora;

    @FXML
    private Label labelEdicao;

    @FXML
    private Label labelAnoPub;

    @FXML
    private Label labelPaginas;

    @FXML
    private Button btnFechar;

    @FXML
    private Button btnAdicionar;

    public void initialize(){

        btnFechar.setOnMouseClicked(event -> {
     Stage janela= (Stage)((Node)event.getSource()).getScene().getWindow();
     janela.close();
 });
        btnAdicionar.setOnMouseClicked(event -> {
            JOptionPane.showMessageDialog(null,"Livro Adicionado com sucesso!");
            Stage janela= (Stage)((Node)event.getSource()).getScene().getWindow();
            janela.close();
        });
    }




}
