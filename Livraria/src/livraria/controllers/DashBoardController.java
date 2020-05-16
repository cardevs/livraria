package livraria.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import livraria.classes.LivrariaStrategy;

import javax.swing.*;
import javax.swing.text.Style;
import java.io.IOException;

public class DashBoardController {

    @FXML
    private JFXButton btnResumo;

    @FXML
    private AnchorPane ancorCentro;

    @FXML
    void mostrarResumo(ActionEvent event) {


}

@FXML
    void abrirChat(){

    ancorCentro.getChildren().clear();
    try {
        FXMLLoader carregador= new FXMLLoader();
        carregador.setLocation(getClass().getResource("/livraria/views/Chat.fxml"));
    AnchorPane chat=carregador.load();
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


}
