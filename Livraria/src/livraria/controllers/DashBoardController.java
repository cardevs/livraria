package livraria.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import livraria.classes.LivrariaStrategy;

import javax.swing.*;
import java.io.IOException;

public class DashBoardController {


    @FXML
    private Label nomeUtilizador;

    @FXML
    private JFXButton btnResumo;

    @FXML
    private AnchorPane painelDoCentro;
    @FXML
    private HBox boxMaisRecentes;



    public void initialize(){
        carregarDados();
//ancorCentro.setTopAnchor();
    }


    @FXML
    void mostrarResumo(ActionEvent event) {
        painelDoCentro.getChildren().clear();//Limpa a parte central
            AnchorPane resumo=(AnchorPane)LivrariaStrategy.carregarPainel("Resumo");
           painelDoCentro.setTopAnchor(resumo,0.0);
            painelDoCentro.setLeftAnchor(resumo,0.0);
            painelDoCentro.setRightAnchor(resumo,0.0);
          painelDoCentro.setBottomAnchor(resumo,0.0);
            painelDoCentro.getChildren().add(resumo);

}

@FXML
    void abrirChat(){

        painelDoCentro.getChildren().clear();
        AnchorPane chat=(AnchorPane) LivrariaStrategy.carregarPainel("Chat");
        painelDoCentro.setTopAnchor(chat,0.0);
        painelDoCentro.setLeftAnchor(chat,0.0);
        painelDoCentro.setRightAnchor(chat,0.0);
        painelDoCentro.setBottomAnchor(chat,0.0);
        painelDoCentro.getChildren().add(chat);

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

        painelDoCentro.getChildren().clear();//Para limpar todo conteudo
        AnchorPane biblioteca=(AnchorPane)LivrariaStrategy.carregarPainel("Livraria");
        painelDoCentro.setTopAnchor(biblioteca,0.0);
        painelDoCentro.setLeftAnchor(biblioteca,0.0);
        painelDoCentro.setRightAnchor(biblioteca,0.0);
        painelDoCentro.setBottomAnchor(biblioteca,0.0);
        painelDoCentro.getChildren().add(biblioteca);

    }

}
