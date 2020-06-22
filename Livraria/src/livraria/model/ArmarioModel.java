/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import livraria.model.core.ConexaoDB;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Adamastor Chimalange
 */
public class ArmarioModel {
  private List <LivroModel> livros= new ArrayList();

    public ArmarioModel() {
    }

    public List<LivroModel> getLivros() {
        return livros;
    }

    public void setLivros(List<LivroModel> livros) {
        this.livros = livros;
    }
  
  public void mostrarCategoriaDoLivro(){
      Connection connector=ConexaoDB.getConnection();
      String sql="Select * from bookCategory";
      Statement statement=null;
      try {
          statement=connector.prepareStatement(sql);
      } catch (Exception e) {
      }
  
  }
}
