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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import livraria.dao.ArmarioDAO;
import livraria.dao.Regular_Expressions;
import livraria.model.LivroModel;
/*Outros Mambos*/

public class AdicionarLivroController {

    @FXML
    private Rectangle capa;

    @FXML
    private JFXTextField tituloLivro;

    @FXML
    private JFXTextField autorLivro;

    @FXML
    private JFXComboBox<String> categoriaLivro;

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
        
        /*
            Parte onde busca as categorias dos livro na BD e apresenta na app
            Variavel observableTest recebe a lista vinda da base de dados e e converte em uma Lista do 
            tipo Observable para ser apresentado na tela.
            Variavel categoriaLivro variavel do tipo ComboBox.
        */
        ObservableList<String> observableTest;
        observableTest=FXCollections.observableArrayList(ArmarioDAO.buscarCategoriaDoLivro());
        categoriaLivro.setItems(observableTest);


    }
    @FXML
    void adicionarLivro(ActionEvent event) {
        /*Verificando se existe um campo em branco no formulario*/
        boolean testando;
        testando= verificaCamposEmBrancosNoForm(tituloLivro.getText(), autorLivro.getText(),categoriaLivro.getValue(),editoraLivro.getText(),anoPubLivro.getText(), numeroPgLivro.getText());
        //Testa se existe campos vazios.
        if (!testando) {
            //Caso n tenha um campo vazio, testa se o nome do autor comeca com um numero ou caracter especial
                if (verificaNome(autorLivro.getText())) {
                    LivroModel libro = new LivroModel(tituloLivro.getText(), autorLivro.getText(),categoriaLivro.getValue(),editoraLivro.getText(),Integer.parseInt(anoPubLivro.getText()),Integer.parseInt(numeroPgLivro.getText()), descricaoLivro.getText(), "Escuro");
                    ArmarioDAO armarioDAO=new ArmarioDAO();
                    armarioDAO.addLivros(libro);
                }else{
                    System.out.println("Nome Invalido.");
                }
        
        }else{
            System.out.println("Existe campos vazios.");
        }
        
    }

    @FXML
    void cancelar(ActionEvent event) {
        Stage janela= (Stage)((Node)event.getSource()).getScene().getWindow();
        janela.close();
    }

    @FXML
    void inserirImagem(){

        File caminho= new File(String.valueOf(getClass().getResource("/imagens")));
        String caminho2= caminho.getAbsolutePath().replace("null","imagens\\");
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
    /*Metodo que verifica os dados se ha campos em branco no formulario*/
    public boolean verificaNome(String book){
        boolean resposta;
        resposta = Regular_Expressions.verificaNome(book);
    return resposta;
    }
      
    //String tituloLivro.getText(),String autorLivro.getText(),String categoriaLivro.getValue(),String editoraLivro.getText(),String anoPubLivro.getText(),String numeroPgLivro.getText(),String descricaoLivro.getText()
    public boolean verificaCamposEmBrancosNoForm(String titulo,String autor, String categoria, String editora, String anoPub,String numeroPag){
        boolean resultado;
        resultado = (titulo.equalsIgnoreCase(""))||(autor.equalsIgnoreCase(""))||(editora.equalsIgnoreCase(""))||(anoPub.equalsIgnoreCase(""))||(numeroPag.equalsIgnoreCase(""));
    return resultado;
    }

    

}
