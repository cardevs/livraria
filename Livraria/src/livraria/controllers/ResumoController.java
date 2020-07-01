package livraria.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import livraria.dao.ArmarioDAO;
import livraria.dao.LivrariaDao;
import livraria.model.LivroModel;

import java.io.IOException;
import java.util.ArrayList;

/*
* Controlador responsavel pela parte do resumo diario de um utilizador
*
* */


public class ResumoController {

    @FXML
    private HBox boxMaisRecentes;


    public void initialize(){
        carregarDados();

    }

    private void carregarDados()//Esta funcao carrega dados dos livros do Utilizador

    {       boxMaisRecentes.getChildren().clear();
            ArrayList<LivroModel> livrosDoArmario= new ArrayList<>();
            livrosDoArmario= LivrariaDao.buscarLivros();//Devera ser alterado para ArmarioDAO

            for (LivroModel livroModel : livrosDoArmario) //Itera Array com livros do armario

                {

            try {
                FXMLLoader carregador= new FXMLLoader();
                carregador.setLocation(getClass().getResource("/livraria/views/LivroRecente.fxml"));
                Parent livro=carregador.load();
                LivroRecenteController controller= carregador.getController();
                controller.adicionarDados(livroModel.getTitulo(),livroModel.getAutor(),livroModel.getCapa());
                boxMaisRecentes.getChildren().add(livro);
            }
            catch (IOException erro){
                System.out.println("Erro ao tentar adicionar Livro Mais recente");
            }
        }

}

@FXML
    public void mostrarDetalhes(){


    System.out.println("Clicou em mostrar detalhes");
}


}
