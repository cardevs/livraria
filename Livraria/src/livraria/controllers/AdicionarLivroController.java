package livraria.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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


File ficheiro;//Ficheiro que armazenara a capa ou imagem do livro temporariamente







    public void initialize(){
/*
        capa.setFill(new ImagePattern(new Image("/livraria/resources/img/addImage.png")));
        capa.setStroke(Color.TRANSPARENT);

*/

    }
    @FXML
    void adicionarLivro(ActionEvent event) {
        System.out.println("Funcionando Adicionar!!");

      if (ficheiro!=null)
      {
          try {
              Path source = Paths.get(ficheiro.getAbsolutePath());
              Path destination = Paths.get("recursos/img/"+ficheiro.getName());
              Files.copy(source, destination);//Copia um ficheiro de um lugar para outro
          } catch (IOException erro){

              System.out.println(erro.getMessage());
          }
      }

      /*Codigo para salvar na Base de Dados*/

    }

    @FXML
    void cancelar(ActionEvent event) {
        Stage janela= (Stage)((Node)event.getSource()).getScene().getWindow();
        janela.close();
    }

    @FXML
    void inserirImagem(){

        FileChooser escolherFicheiro= new FileChooser();
        escolherFicheiro.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagens","*.png"));
        ficheiro=escolherFicheiro.showOpenDialog(null);
        capa.setFill(new ImagePattern(new Image("file:///"+ficheiro.getAbsolutePath())));
        capa.setStroke(Color.TRANSPARENT);

    }

}
