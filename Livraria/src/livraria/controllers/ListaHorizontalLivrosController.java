package livraria.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.HBox;
import livraria.views.LivroController;

import java.io.IOException;

public class ListaHorizontalLivrosController {

        @FXML
        private HBox listaHorizontal;

        public ListaHorizontalLivrosController()
        {
            listaHorizontal= new HBox();
        }

        public void initialize(){

        }
    public HBox getListaHorizontal() {
        return listaHorizontal;
    }

    public void setListaHorizontal(HBox listaHorizontal) {
        this.listaHorizontal = listaHorizontal;
    }

public void addLivro(Node elemento){
            listaHorizontal= new HBox();
     listaHorizontal.getChildren().add(elemento);


}


}



