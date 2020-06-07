package livraria.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import livraria.views.LivroController;

import javax.swing.*;
import java.io.IOException;

public class Livraria {

    @FXML
    private VBox listViewTodos;


    public void initialize(){

       // listViewTodos=new VBox();
          carregarDados();
    }


    public VBox getListViewTodos() {
        return listViewTodos;
    }

    public void setListViewTodos(VBox listViewTodos) {
        this.listViewTodos = listViewTodos;
    }


    private void carregarDados()
/*
* Esta funcao carrega todos os livros da base de dados
* */
    {


            listViewTodos.getChildren().clear();//Limpa a view onde sera apresentada a lista
            try {

                for (int j=0; j<5; j++)//Para criar uma lista horizontal
                {
                    HBox listinha= new HBox();
                    listinha.setSpacing(20.0);
                    for (int i=0; i<3; i++)//Para adicionar livro a cada lista horizontal
                    {
                        FXMLLoader carregador2= new FXMLLoader();
                        carregador2.setLocation(Livraria.class.getResource("/livraria/views/Livro.fxml"));
                        LivroController controllerLivro=carregador2.getController();
                        Parent livro=carregador2.load();
                        listinha.getChildren().add(livro);
                    }
                    listViewTodos.getChildren().add(listinha);
                }

          //   controladorListaaHorizontal.addLivro(livro);


            }catch (IOException erro){

                erro.printStackTrace();
            }

        }



}
