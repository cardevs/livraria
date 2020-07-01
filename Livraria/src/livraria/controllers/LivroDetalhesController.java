package livraria.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import livraria.classes.LivrariaStrategy;
import livraria.model.LivroModel;

import javax.swing.*;
import java.io.File;

public class LivroDetalhesController {


    @FXML
    private Rectangle capa;

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

        File ficheiro= new File("recursos/img/unnamed.png");
        System.out.println(ficheiro.getAbsolutePath());
        System.out.println(ficheiro.getPath());
        capa.setFill(new ImagePattern(new Image("file:///"+ficheiro.getAbsolutePath())));

        btnFechar.setOnMouseClicked(event -> {
     Stage janela= (Stage)((Node)event.getSource()).getScene().getWindow();
     janela.close();
 });
        btnAdicionar.setOnMouseClicked(event -> {
            JOptionPane.showMessageDialog(null,"Livro Adicionado com sucesso!");


        });
    }
/*
    public LivroDetalhesController(){

    }
    public LivroDetalhesController(LivroModel livro) {
        this.titulo.setText(livro.getTitulo()); ;
        this.autor.setText(livro.getAutor());
        this.labelDescricao.setText(livro.getDescricao());
        this.labelEditora.setText(livro.getEditora());
      //  this.labelEdicao.setText(livro.getEditora());//Deve se adicionar a edicao;
        this.labelAnoPub.setText(String.valueOf(livro.getAnoDeLancamento()));
        this.labelPaginas.setText(String.valueOf(livro.getPaginas()));
        File ficheiro= new File("recursos/img/"+livro.getCapa());
        capa.setFill(new ImagePattern(new Image("file:///"+ficheiro.getAbsolutePath())));
    }*/

    public void carregarDados(LivroModel livro) {
        titulo.setText(livro.getTitulo());
        autor.setText(livro.getAutor());
        capa.setFill(new ImagePattern(new Image(LivrariaStrategy.buscarCapaLivro(livro.getCapa()))));
        labelDescricao.setText(livro.getDescricao());
        labelEditora.setText(livro.getEditora());
        //labelEdicao.setText(livro.get); ;
        labelAnoPub.setText(String.valueOf(livro.getAnoDeLancamento()));
        labelPaginas.setText(String.valueOf(livro.getPaginas()));
    }
}
