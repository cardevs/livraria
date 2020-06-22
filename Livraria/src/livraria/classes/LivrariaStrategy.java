
package livraria.classes;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Modality;
import javafx.stage.Stage;
import livraria.Main;

import javax.swing.*;
import java.io.IOException;
import java.sql.SQLException;

/*Nesta classe usou-se o conceito de Design Pattern Strategy para nao repetir codigo*/
public class LivrariaStrategy {
  
    private static final String ICON="/livraria/resources/img/logo.png";
    
    public static void selecionarIcon(Stage janela)/*Esta funcao define o icone para Todas a janelas passada pelo Prametro*/
    {
       janela.getIcons().add(new Image(ICON));
    }
    public static Stage mostrarView(String nome){

        try {
            FXMLLoader carregador= new FXMLLoader();
            carregador.setLocation(LivrariaStrategy.class.getResource("/livraria/views/"+nome+".fxml"));
            Parent painel=carregador.load();
            Scene cenario= new Scene(painel);
            Stage janela=new Stage();
            janela.initOwner(Main.janelaPrincipal);
            janela.initModality(Modality.WINDOW_MODAL);
            janela.setTitle(nome);
            janela.setScene(cenario);
            //janela.
            return janela;
        }catch (IOException erro){
            JOptionPane.showMessageDialog(null,"Erro ao carregar a view\n"+erro.getMessage());

        }
        return null;
    }
    public static Parent carregarPainel(String nome){

        try {
            FXMLLoader carregador= new FXMLLoader();
            carregador.setLocation(LivrariaStrategy.class.getResource("/livraria/views/"+nome+".fxml"));
            Parent painel=carregador.load();
            return painel;
        }catch (IOException erro){

            JOptionPane.showMessageDialog(null,"Erro ao tentar carregar o painel\n"+erro.getMessage());
        }
return null;
    }
}
