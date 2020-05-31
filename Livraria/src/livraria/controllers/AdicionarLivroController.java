package livraria.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class AdicionarLivroController {

    @FXML
    private Rectangle capa;

    @FXML
    private JFXTextField tituloLivro;

    @FXML
    private JFXTextField autorLivro;

    @FXML
    private JFXComboBox<?> categoriaLivro;

    @FXML
    private JFXTextField editoraLivro;

    @FXML
    private JFXTextField anoPubLivro;

    @FXML
    private JFXTextField numeroPgLivro;

    @FXML
    private TextArea descricaoLivro;

    @FXML
    private JFXButton btnCancelar;

    @FXML
    private JFXButton btnAdicionar;

    public void initialize(){

        capa.setFill(new ImagePattern(new Image("/livraria/resources/img/addImage.png")));
capa.setStroke(Color.TRANSPARENT);

    }


    @FXML
    void adicionarLivro(ActionEvent event) {
        System.out.println("Funcionando Adicionar!!");
    }

    @FXML
    void cancelar(ActionEvent event) {
        System.out.println("Funcionando Cancelar");
    }

    @FXML
    void inserirImagem(){

        File caminho= new File(String.valueOf(getClass().getResource("/imagens")));
         String caminho2= caminho.getAbsolutePath().replace("null","imagens\\");
      //  System.out.println(caminho.getAbsolutePath());
        System.out.println(caminho2);
        FileChooser escolherFicheiro= new FileChooser();
        escolherFicheiro.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagens","*.png"));
        File ficheiro=escolherFicheiro.showOpenDialog(null);

      try {
          Path source = Paths.get(ficheiro.getAbsolutePath());
          Path destination = Paths.get("/imagens/"+ficheiro.getName());
          Files.copy(source, destination);
      } catch (IOException erro){

          System.out.println(erro.getMessage());
      }
        capa.setFill(new ImagePattern(new Image("/imagens/chima.png")));

    }

}
