package livraria.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class LivroController {

    @FXML
    private ImageView capa;

    @FXML
    private Label titulo;

    @FXML
    private Label autor;

    @FXML
    void inserirNaLista(ActionEvent event) {
        System.out.println("Estou a funcionar");
    }

    @FXML
    void verDados(ActionEvent event) {
        System.out.println("Estou a funcionar");
    }

}
