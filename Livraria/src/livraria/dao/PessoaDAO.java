/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
//import static java.sql.Statement.RETURN_GENERATED_KEYS;
import livraria.model.PessoaModel;
import livraria.model.core.ConexaoDB;
/**
 *
 * @author Adamastor Chimalange
 */
public class PessoaDAO {
    public void registrarPessoa( PessoaModel pessoa)
    {
        boolean test=false;
        int lastId =0;
        boolean check=false;
        Connection conector=ConexaoDB.getConnection();
        PreparedStatement statement=null;
        try {
            
            String sql="INSERT INTO pessoa (id,nome,sobre_nome,email,aniversario,senha)VALUES (null,?,?,?,?,?)";
            statement=conector.prepareStatement(sql);//Essa linha
            statement.setString(1, pessoa.getNome());
            statement.setString(2, pessoa.getSobrenome());
            statement.setString(3, pessoa.getEmail());
            statement.setString(4,pessoa.getAniversario());
            statement.setString(5, pessoa.getSenha());
            statement.execute();
            
            /*if (check) {
                ResultSet codigos;
                codigos=statement.getGeneratedKeys();
                while (codigos.next()) {
                    lastId=codigos.getInt(1);
                }
            }*/
            cadastrarLogin(pessoa);
        
        } catch (SQLException erroRegistrar) {
            erroRegistrar.printStackTrace();
        }finally{
            ConexaoDB.closeConnection(conector);
            ConexaoDB.closeStatement(statement);
        } 
    }
    
    public boolean cadastrarLogin(PessoaModel pessoa)
     {
         Connection connection= ConexaoDB.getConnection();
         PreparedStatement stmt=null;
         String sql="INSERT INTO login (username,password)VALUES (?,?)";
         
         try {
             stmt=connection.prepareStatement(sql);
             stmt.setString(1, pessoa.getEmail());
             stmt.setString(2, pessoa.getSenha());
             stmt.execute();
         } catch (Exception e) {
             e.printStackTrace();
         }finally{
             ConexaoDB.closeConnection(connection);
             ConexaoDB.closeStatement(stmt);
         }
     return false;
     }
}

