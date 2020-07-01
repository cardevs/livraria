/*Esta classe controla a janela de para adicionar livro por parte do utilizador*/



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
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import livraria.dao.ArmarioDAO;
import livraria.classes.Regular_Expressions;
import livraria.model.LivroModel;

import javax.swing.*;
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

    private static File ficheiro;//Ficheiro que armazenara a capa ou imagem do livro temporariamente

    public void initialize(){
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

        boolean testando;
        testando= verificaCamposEmBrancosNoForm(tituloLivro.getText(), autorLivro.getText(),categoriaLivro.getValue(),editoraLivro.getText(),anoPubLivro.getText(), numeroPgLivro.getText());
        //Testa se existe campos vazios.
        if (!testando) {
            if (!testando) {
            //Caso n tenha um campo vazio, testa se o nome do autor comeca com um numero ou caracter especial
                if (verificaNome(autorLivro.getText())) {
                    if (ficheiro!=null) //Verifiva se foi adicionado alguma imagem
                    {
                        try {
                            Path source = Paths.get(ficheiro.getAbsolutePath());
                            Path destination = Paths.get("recursos/img/"+ficheiro.getName());
                            Files.copy(source, destination);//Copia um ficheiro de um lugar para outro
                            LivroModel libro = new LivroModel(tituloLivro.getText(), autorLivro.getText(),categoriaLivro.getValue(),editoraLivro.getText(),Integer.parseInt(anoPubLivro.getText()),Integer.parseInt(numeroPgLivro.getText()), descricaoLivro.getText(), ficheiro.getName());
                            ArmarioDAO armarioDAO=new ArmarioDAO();
                            armarioDAO.addLivros(libro);
                            JOptionPane.showMessageDialog(null,"Livro Adicionado com sucesso");
                            limparCampos();
                        }
                        catch (FileAlreadyExistsException e)/*Caso o ficheiro ja exista ele nao copia*/
                        {
                            LivroModel libro = new LivroModel(tituloLivro.getText(), autorLivro.getText(),categoriaLivro.getValue(),editoraLivro.getText(),Integer.parseInt(anoPubLivro.getText()),Integer.parseInt(numeroPgLivro.getText()), descricaoLivro.getText(), ficheiro.getName());
                            ArmarioDAO armarioDAO=new ArmarioDAO();
                            armarioDAO.addLivros(libro);
                            JOptionPane.showMessageDialog(null,"Livro Adicionado com sucesso");
                            limparCampos();
                        }
                        catch (IOException erro){
                            JOptionPane.showMessageDialog(null,erro.getMessage());
                        erro.printStackTrace();
                        }
                    }
                    else {
                        LivroModel libro = new LivroModel(tituloLivro.getText(), autorLivro.getText(),categoriaLivro.getValue(),editoraLivro.getText(),Integer.parseInt(anoPubLivro.getText()),Integer.parseInt(numeroPgLivro.getText()), descricaoLivro.getText(), "*");
                        ArmarioDAO armarioDAO=new ArmarioDAO();
                        armarioDAO.addLivros(libro);
                        JOptionPane.showMessageDialog(null,"Livro Adicionado com sucesso");
                        limparCampos();
                    }
                }else{
                    System.out.println("Nome Invalido.");
                }

        }else{
            System.out.println("Existe campos vazios.");
        }
        System.out.println("Funcionando Adicionar!!");

    }

        ficheiro=null;//Retira o caminho do ficheiro
    }

    @FXML
    void cancelar(ActionEvent event) {
        Stage janela= (Stage)((Node)event.getSource()).getScene().getWindow();
        janela.close();
    }

    @FXML
    void inserirImagem(){
        ficheiro = new File(".");
        FileChooser escolherFicheiro= new FileChooser();
        escolherFicheiro.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("Imagens","*.png","*.jpg"));
        ficheiro=escolherFicheiro.showOpenDialog(null);
        capa.setFill(new ImagePattern(new Image("file:///"+ficheiro.getAbsolutePath())));
        capa.setStroke(Color.TRANSPARENT);

    }
    /*Metodo que verifica os dados se ha campos em branco no formulario*/
    private boolean verificaNome(String nome){
        boolean resposta= Regular_Expressions.verificaNome(nome);
    return resposta;
    }

    //String tituloLivro.getText(),String autorLivro.getText(),String categoriaLivro.getValue(),String editoraLivro.getText(),String anoPubLivro.getText(),String numeroPgLivro.getText(),String descricaoLivro.getText()
    private boolean verificaCamposEmBrancosNoForm(String titulo,String autor, String categoria, String editora, String anoPub,String numeroPag){
        boolean resultado;
        resultado = (titulo.equalsIgnoreCase(""))||(autor.equalsIgnoreCase(""))||(editora.equalsIgnoreCase(""))||(anoPub.equalsIgnoreCase(""))||(numeroPag.equalsIgnoreCase(""));
    return resultado;
    }

    private void limparCampos(){
        autorLivro.setText("");
        anoPubLivro.setText("");
        editoraLivro.setText("");
        categoriaLivro.setValue(null);
        numeroPgLivro.setText("");
        tituloLivro.setText("");
        descricaoLivro.setText("");
    }
    
}


