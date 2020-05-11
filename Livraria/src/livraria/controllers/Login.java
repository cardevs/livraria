package livraria.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Login {

     @FXML
    private ImageView btnFacebook;

    @FXML
    private ImageView btnInstagram;

    @FXML
    private ImageView btnTwitter;

    @FXML
    private Pane painel1;

    @FXML
    private Pane painel2;

    @FXML
    private Pane painel3;

    @FXML
    private Pane painelLogin;

    @FXML
    private JFXTextField usernameLogin;

    @FXML
    private JFXPasswordField passwordLogin;

    @FXML
    private JFXButton btnLogin;

    @FXML
    private Label btnRegistarSe;

    @FXML
    private Pane painelRegisto;

    @FXML
    private JFXTextField usernameRegisto;

    @FXML
    private JFXPasswordField senhaRegisto;

    @FXML
    private JFXTextField sobrenomeRegisto;

    @FXML
    private JFXTextField emailRegisto;

    @FXML
    private JFXDatePicker dataAniversarioRegisto;

    @FXML
    private JFXPasswordField rSenhaRegisto;

    @FXML
    private Label btnEntrar2;

    @FXML
    private JFXButton btnRegistar;

 
    public void initialize(){

       // painel1.setStyle("-fx-background-image: url(\"/livraria/resources/img/livro1.png\")");
        painel1.setStyle("-fx-background-image: url(\"/livraria/resources/img/livros3.jpg\"); -fx-background-position: center; -fx-background-size: cover;");/*Define o fundo*/
        painel2.setStyle("-fx-background-image: url(\"/livraria/resources/img/livros6.jpg\"); -fx-background-position: center;-fx-background-size: cover;"); 
      transicoes();



        btnRegistarSe.setOnMouseClicked(event->{
            TranslateTransition transition1= new TranslateTransition(Duration.seconds(0.3),painelLogin);
            transition1.setByX(600);
            transition1.play();
            painelRegisto.setTranslateX(600);
            transition1.setOnFinished(event1->{
                painelRegisto.setVisible(true);
                TranslateTransition transition2= new TranslateTransition(Duration.seconds(0.2),painelRegisto);
                transition2.setByX(-600);
                transition2.play();
            });
        });

        btnEntrar2.setOnMouseClicked(event->{
            TranslateTransition transition1= new TranslateTransition(Duration.seconds(0.3),painelRegisto);
            transition1.setByX(600);
            transition1.play();
            painelLogin.setTranslateX(600);
            transition1.setOnFinished(event1->{
                painelLogin.setVisible(true);
                TranslateTransition transition2= new TranslateTransition(Duration.seconds(0.2),painelLogin);
                transition2.setByX(-600);
                transition2.play();
            });
        });



      
      
      
      
               
    }
    
    private void transicoes()/*Esta funcao faz as trancicoes das imagens */
    {
         painel2.setVisible(false);
        FadeTransition transicao1= new FadeTransition(Duration.seconds(10),painel1);
        transicao1.setFromValue(1);//Comeca da opacidade 100%
        transicao1.setToValue(0);//Ate 0%
        transicao1.play();
        painel2.setVisible(true);
          FadeTransition transicao2= new FadeTransition(Duration.seconds(15),painel2);
        transicao2.setFromValue(0);
        transicao2.setToValue(1);
        transicao2.play(); 
          transicao2.setOnFinished(event->{
               transicoes();//Recursividade
        });
        
    }
    
      @FXML
    void fazerLogin(ActionEvent event) {
          System.out.println("Funcionando!!");
    }

    @FXML
    void registar(ActionEvent event) {

        System.out.println("Funcionando!");
    }
    

}
