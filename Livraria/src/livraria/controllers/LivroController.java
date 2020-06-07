package livraria.views;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import livraria.controllers.LivroDetalhesController;

import java.io.IOException;

public class LivroController {

    @FXML
    private ImageView capa;

    @FXML
    private Label titulo;

    @FXML
    private Label autor;


    @FXML
    private Rectangle capa2;

    @FXML
    private Label labelDescricao;

    @FXML
    private Label labelEditora;

    @FXML
    private Label labelEdicao;

    @FXML
    private Label labelAnoPub;

    @FXML
    private Label labelPaginas;

    @FXML
    private Button btnFechar;

    @FXML
    private Button btnAdicionar;

    @FXML
    void inserirNaLista(ActionEvent event) {
        System.out.println("Estou a funcionar");
    }

    @FXML
    void verDados(ActionEvent event) {
   try {
       FXMLLoader carregador= new FXMLLoader();
       carregador.setLocation(LivroController.class.getResource("/livraria/views/LivroDetalhes.fxml"));
       Parent livroDetalhes=carregador.load();
       LivroDetalhesController controlador= new LivroDetalhesController();
       Scene cenario= new Scene(livroDetalhes);
       Stage janela= new Stage();
       janela.setTitle("Detalhes do Livro");
       janela.setScene(cenario);
       janela.show();
   }catch (IOException erro){
       erro.printStackTrace();
   }
    }

}
