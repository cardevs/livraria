/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import livraria.model.LivroModel;
import livraria.model.core.ConexaoDB;
/**
 *
 * @author Adamastor Chimalange
 */
public class ArmarioDAO {
    
    //protected List <LivroModel> livros= new ArrayList();
    
    public void addLivros( LivroModel book){
        Connection connection=ConexaoDB.getConnection();
        PreparedStatement pStatement=null;
        try {
                String query="Insert into book(id_book,title,author,category,publishing_company,release_year,page_number,description,cover)values(null,?,?,?,?,?,?,?,?)";
                pStatement=connection.prepareStatement(query);
                pStatement.setString(1, book.getTitulo());
                pStatement.setString(2, book.getAutor());
                pStatement.setString(3, book.getCategoria());
                pStatement.setString(4, book.getEditora());
                pStatement.setInt(5, book.getAnoDeLancamento());
                pStatement.setInt(6, book.getPaginas());
                pStatement.setString(7, book.getDescricao());
                pStatement.setString(8, book.getCapa());
                pStatement.execute();
        } catch (Exception e) {
            
        }finally{
            ConexaoDB.closeConnection(connection);
            ConexaoDB.closeStatement(pStatement);
        }
    }   
    
    /*Classe responsavel pr pegar as categorias na base de Dados*/
    public static List<String> buscarCategoriaDoLivro(){
      List<String> categoriasLivros=new ArrayList<>();
      Connection connector=ConexaoDB.getConnection();
      String sql="Select category from bookCategory";
      Statement statement=null;
      ResultSet rs=null;
      String nome;
      try {
          statement=connector.createStatement();
          rs=statement.executeQuery(sql);
          while (rs.next()) {
              nome=rs.getString("category");
              categoriasLivros.add(nome);
          }
          
      } catch (Exception e) {
        
      }finally{
          ConexaoDB.closeConnection(connector, statement, rs);
  }
      return categoriasLivros;
}   
    //Metodo inacabado
    public void pega(){
        Connection connector=ConexaoDB.getConnection();
        Statement stmt=null;
        ResultSet rs=null;
        String query="SELECT id_book, title FROM book";
        try {
            stmt=connector.createStatement();
            rs=stmt.executeQuery(query);
            rs.last();
        } catch (Exception e) {
        }finally{ConexaoDB.closeConnection(connector, stmt, rs);}
        
    
    }
}
