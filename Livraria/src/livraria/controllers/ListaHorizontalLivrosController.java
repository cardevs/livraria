package livraria.controllers;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.HBox;

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



