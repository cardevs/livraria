package livraria.controllers;

import com.sun.istack.internal.NotNull;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import livraria.dao.LivrariaDao;
import livraria.model.LivroModel;
import livraria.views.LivroController;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class LivrariaController {

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

                ArrayList<LivroModel> livros= LivrariaDao.buscarLivros();

                if (livros==null)
                {
                    JOptionPane.showMessageDialog(null,"Nenhum livro encontrado!!!");
                }
                else
                {
                    Iterator<LivroModel> iteradorDeLivros=livros.iterator(); //criado para iterar os livros recebidos na base de Dados


                   while (iteradorDeLivros.hasNext())
                   {
                       int i=0;
                       HBox listinha= new HBox();
                       listinha.setSpacing(20.0);
                      while (iteradorDeLivros.hasNext() && i<3)//Para adicionar livro a cada lista horizontal
                       {
                           LivroModel livroModel=iteradorDeLivros.next();
                           FXMLLoader carregador= new FXMLLoader();
                           carregador.setLocation(LivrariaController.class.getResource("/livraria/views/Livro.fxml"));
                           Parent livro=carregador.load();
                           ControladorLivro controladorLivro=carregador.getController();
                          controladorLivro.carregarDados(livroModel);
                           listinha.getChildren().add(livro);
                           i++;
                       }
                       listViewTodos.getChildren().add(listinha);
                    }

                    //   controladorListaaHorizontal.addLivro(livro);

                }


            }catch (IOException erro){

                erro.printStackTrace();
            }

        }



}
