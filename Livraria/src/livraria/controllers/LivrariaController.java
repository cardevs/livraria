package livraria.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import livraria.views.LivroController;

import javax.swing.*;
import java.io.IOException;

public class LivrariaController {

    @FXML
    private static VBox listViewTodos;

    public void initialize(){

     //   carregarDados();


    }

    public LivrariaController(VBox listViewTodos) {
        this.listViewTodos = listViewTodos;




    }

    public VBox getListViewTodos() {
        return listViewTodos;
    }

    public void setListViewTodos(VBox listViewTodos) {
        this.listViewTodos = listViewTodos;
    }


    private void carregarDados(){

       try {
           FXMLLoader carregador= new FXMLLoader();
           carregador.setLocation(LivrariaController.class.getResource("/livraria/views/ListaHorizontalLivros.fxml"));
           ListaHorizontalLivrosController contraladorListaaHorizontal=carregador.getController();
           Parent lista1=carregador.load();

           FXMLLoader carregador2= new FXMLLoader();
           carregador.setLocation(LivrariaController.class.getResource("/livraria/views/Livro.fxml"));
           LivroController controllerLivro=carregador.getController();
           Parent livro=carregador.load();
           contraladorListaaHorizontal.getListaHorizontal().getChildren().addAll(livro);
       listViewTodos.getChildren().add(lista1);
       }catch (IOException erro){


           JOptionPane.showMessageDialog(null,"Not possible to show the view!");


       }






//Parent root= FXMLLoader.load(LivrariaController.class.getResource(""))


    }

}
