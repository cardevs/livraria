package livraria.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import livraria.classes.LivrariaStrategy;

import javax.swing.*;
import java.io.IOException;

public class DashBoardController {

    @FXML
    private JFXButton btnResumo;

    @FXML
    private AnchorPane ancorCentro;
    @FXML
    private HBox boxMaisRecentes;



    public void initialize(){
        carregarDados();
//ancorCentro.setTopAnchor();
    }


    @FXML
    void mostrarResumo(ActionEvent event) {
        ancorCentro.getChildren().clear();//Limpa a parte central
        try {
            FXMLLoader carregador= new FXMLLoader();
            carregador.setLocation(getClass().getResource("/livraria/views/Resumo.fxml"));
            AnchorPane resumo=carregador.load();
            /*
            * O setTopAnchor e outros serve para definir como sera a responsividade
            * */
           ancorCentro.setTopAnchor(resumo,0.0);
            ancorCentro.setLeftAnchor(resumo,0.0);
            ancorCentro.setRightAnchor(resumo,0.0);
          ancorCentro.setBottomAnchor(resumo,0.0);
            ancorCentro.getChildren().add(resumo);
        }catch (IOException erro){
            System.out.println("Erro a tentar mostrar a View!!\n"+erro.getMessage());
        }

}

@FXML
    void abrirChat(){

    ancorCentro.getChildren().clear();
    try {
        FXMLLoader carregador= new FXMLLoader();
        carregador.setLocation(getClass().getResource("/livraria/views/Chat.fxml"));
    AnchorPane chat=carregador.load();


        ancorCentro.setTopAnchor(chat,0.0);
        ancorCentro.setLeftAnchor(chat,0.0);
        ancorCentro.setRightAnchor(chat,0.0);
        ancorCentro.setBottomAnchor(chat,0.0);
    ancorCentro.getChildren().add(chat);
    }catch (IOException erro){
        System.out.println("Erro a tentar mostrar a View!!\n"+erro.getMessage());
}
}
@FXML
    void adicionarLivro(){

        try{

            FXMLLoader carregador= new FXMLLoader();
            carregador.setLocation(getClass().getResource("/livraria/views/AdicionarLivro.fxml"));
            Parent parent= carregador.load();
            Scene cenario= new Scene(parent);
            Stage janela= new Stage();
            janela.setTitle("Adicionar Livro");
            LivrariaStrategy.selecionarIcon(janela);
            janela.setScene(cenario);
            janela.setResizable(false);
            janela.show();

        }catch (IOException erro){

            System.out.println("Erro ao tentar mostrar a View!!\n"+erro
            .getMessage());
            JOptionPane.showMessageDialog(null, "Erro ao tentar mostrar a view\n"+erro.getMessage());
        }


    }

    public HBox getBoxMaisRecentes() {
        return boxMaisRecentes;
    }
    public void setBoxMaisRecentes(HBox boxMaisRecentes) {
        this.boxMaisRecentes = boxMaisRecentes;
    }

    private void carregarDados()//Esta funcao carrega dados da Base de Dados na DashBoard
    {
        System.out.println("Funcionando!!!");
    }

    @FXML
    void mostrarBiblioteca(){

        ancorCentro.getChildren().clear();//Para limpar todo conteudo
        try {
            FXMLLoader carregador= new FXMLLoader();
            carregador.setLocation(getClass().getResource("/livraria/views/Livraria.fxml"));
            AnchorPane biblioteca=carregador.load();

            /*
            * A seguir tem o codigo para definir as constraint que permitem a Responsividade
            *
            * */
            ancorCentro.setTopAnchor(biblioteca,0.0);
            ancorCentro.setLeftAnchor(biblioteca,0.0);
            ancorCentro.setRightAnchor(biblioteca,0.0);
            ancorCentro.setBottomAnchor(biblioteca,0.0);
            ancorCentro.getChildren().add(biblioteca);
        }catch (IOException erro){
            System.out.println("Erro a tentar mostrar a View!!\n"+erro.getMessage());
            erro.printStackTrace();
        }




    }

}
