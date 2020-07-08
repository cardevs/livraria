package livraria.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import livraria.classes.LivrariaStrategy;
import livraria.model.LivroModel;

import java.io.IOException;

public class ControladorLivro {


    @FXML
    private Rectangle capa;

    @FXML
    private Label titulo;

    @FXML
    private Label autor;

    LivroModel livro=null;


    public void initialize(){


    }


    @FXML
    void inserirNaLista(ActionEvent event) {
        System.out.println("Estou a funcionar");
    }

    @FXML
    void verDados(ActionEvent event) {
        try {
            FXMLLoader carregador= new FXMLLoader();
            carregador.setLocation(ControladorLivro
                    .class.getResource("/livraria/views/LivroDetalhes.fxml"));
            Parent livroDetalhes=carregador.load();
            LivroDetalhesController controlador= carregador.getController();
            controlador.carregarDados(livro);//Envia os dados para a View
            Scene cenario= new Scene(livroDetalhes);
            Stage janela= new Stage();
            janela.setTitle("Detalhes do Livro t");
            janela.setScene(cenario);
            janela.show();
        }catch (IOException erro){
            erro.printStackTrace();
        }
    }

    public void carregarDados(LivroModel livroModel) {
        titulo.setText(livroModel.getTitulo());
        autor.setText(livroModel.getAutor());
        capa.setFill(new ImagePattern(new Image(LivrariaStrategy.buscarCapaLivro(livroModel.getCapa()))));
        livro =livroModel;
    }


}
