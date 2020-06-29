package livraria.controllers;

import com.jfoenix.controls.JFXProgressBar;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import livraria.classes.LivrariaStrategy;

import javax.swing.*;

public class LivroRecenteController {

    @FXML
    private Rectangle img;

    @FXML
    private Label livroTitulo;

    @FXML
    private Label livroAutor;

    @FXML
    private JFXProgressBar progresso;

    @FXML
    private Label percentagem;


    public void initialize(){

        img.setStyle("-fx-background-color: #ffffff");

        img.setOnMouseClicked(event -> {
            JOptionPane.showMessageDialog(null,livroAutor.getText());


        });

    }

    public void adicionarDados(String titulo, String autor, String capa){


        livroTitulo.setText(titulo);
        livroAutor.setText(autor);
        if (!capa.equals("*"))//Caso o livro nao tenha capa
            img.setFill(new ImagePattern(new Image(LivrariaStrategy.buscarCapaLivro(capa))));
    }
}
