package livraria.controllers;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;

public class LivrariaController {

    @FXML
    private VBox listViewTodos;

    public void initialize(){

        carregarDados();


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




    }

}
