/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.classes;

import livraria.model.LivroModel;

/**
 *
 * @author Adamastor Chimalange
 */
public abstract class Regular_Expressions {
   //String olaString="";
    //String emailRegex="([\\w]+[\\w\\-.]*)@([a-zA-Z0-9]+\\.[a-zA-Z0-9\\-.]+)";
    //Pattern pattern= Pattern.compile(emailRegex);
   
    //private final String senhaRegex="";
    
    /*Verifica se o ano introduzido no formulario e valido*/
    public static boolean verificaAno(String numberString)
    {
        final String condicao= "([1-2])[0-9]{3}";
        return numberString.matches(condicao);
    }
    

    public static boolean verificaNome(String book)
    {/*^[a-zA-Z]{2,}[\w]* esta expressao regular verifica se o nome do autor comeca
      com uma letra e tem no minino dois caracteres  
        */
        final String condicao="^[a-zA-Z]{2,}[\\w]*";
        return book.matches(condicao);
    }
}
