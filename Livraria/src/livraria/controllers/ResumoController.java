package livraria.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ResumoController {

    @FXML
    private HBox boxMaisRecentes;


    public void intialize(){

        carregarDados();
    }

    private void carregarDados()//Esta funcao carrega dados da Base de Dados na DashBoard

    {

        for (int i=0; i<10; i++) //Teste para adicionar Livros Recentes
        {

            try {
                FXMLLoader carregador= new FXMLLoader();
                carregador.setLocation(getClass().getResource("/livraria/views/LivroRecente.fxml"));
                Parent livro=carregador.load();
                LivroRecenteController controller= carregador.getController();
                controller.adicionarDados(String.valueOf(i),String.valueOf(i));
                boxMaisRecentes.getChildren().add(livro);
            }
            catch (IOException erro){

                System.out.println("Erro ao tentar adicionar Livro Mais recente");
            }


        }

}


}
