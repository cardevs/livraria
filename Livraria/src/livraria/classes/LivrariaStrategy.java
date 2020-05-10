
package livraria.classes;

import javafx.scene.image.Image;
import javafx.stage.Stage;


/*Nesta classe usou-se o conceito de Design Pattern Strategy para nao repetir codigo*/

public class LivrariaStrategy {
  
    private static final String ICON="/livraria/resources/img/logo.png";
    
    
    
    public static void selecionarIcon(Stage janela)/*Esta funcao define o icone para Todas a janelas passada pelo Prametro*/
    {
        
       janela.getIcons().add(new Image(ICON));
        
    }
    
    
}
