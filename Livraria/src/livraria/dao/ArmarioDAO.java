/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.dao;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Iterator;
//import livraria.model.core.ConexaoDB;
import livraria.model.LivroModel;
/**
 *
 * @author Adamastor Chimalange
 */
public class ArmarioDAO {
    
    protected List <LivroModel> livros= new ArrayList();
    public void addLivros( LivroModel book){
        livros.add(book);
    }
    public void mostrarLivros(){
       Iterator<LivroModel> itr=livros.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next() + "");
            System.out.println();
            
        }
    }
}
