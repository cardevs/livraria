package livraria.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

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
chat.autosize();
    }catch (IOException erro){
        System.out.println("Erro a tentar mostrar a View!!\n"+erro.getMessage());
}
}


}
