package livraria;

import java.io.IOException;
import java.sql.Connection;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.swing.*;
import livraria.classes.LivrariaStrategy;
import livraria.controllers.Login;
import livraria.model.core.ConexaoDB;


/* @author CarneirosDev
 */
public class Main extends Application{
   public static Stage janelaPrincipal;
    
    public void start(Stage stage){
        
      janelaPrincipal=stage;
      try{
          // JOptionPane.showMessageDialog(null, "We are CarneirosDev!!!!!");
          Parent raiz=FXMLLoader.load(getClass().getResource("/livraria/views/DashBoard.fxml"));
          Scene cenario= new Scene(raiz);
          janelaPrincipal.setScene(cenario);
          LivrariaStrategy.selecionarIcon(janelaPrincipal);
          janelaPrincipal.setTitle("CarnBook- Login");
          janelaPrincipal.show();
              
      }catch(IOException erro){
          
          JOptionPane.showMessageDialog(null,"Erro a tentar abrir a View"+erro.getMessage());
      }
    }
   
    
    
    public static void main(String[] args) {
        Connection conn=null;
        conn=ConexaoDB.getConnection();
        launch(args);
       
        
    }
    
}
