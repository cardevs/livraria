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
    public boolean registrarPessoa( PessoaModel pessoa)
    {
        boolean test=false;
        int lastId =0;
        boolean check=false;
        Connection conector=ConexaoDB.getConnection();
        PreparedStatement statement=null;
        try {
            if ((verificaEmail(pessoa.getEmail()))&&(verificaSenhas(pessoa.getSenha(), pessoa.getSenhaTest()))) {
                String sql="INSERT INTO user (id_user,name,surname,email,birthday,password)VALUES (null,?,?,?,?,?)";
                statement=conector.prepareStatement(sql);//Essa linha
                statement.setString(1, pessoa.getNome());
                statement.setString(2, pessoa.getSobrenome());
                statement.setString(3, pessoa.getEmail());
                statement.setString(4,pessoa.getAniversario());
                statement.setString(5, pessoa.getSenha());
                statement.execute();
                cadastrarLogin(pessoa);
                return true;
            }
           
        } catch (SQLException erroRegistrar) {
            erroRegistrar.printStackTrace();
        }finally{
            ConexaoDB.closeConnection(conector);
            ConexaoDB.closeStatement(statement);
        }
        return false;
    }
    
    public boolean cadastrarLogin(PessoaModel pessoa)
     {
         Connection connection= ConexaoDB.getConnection();
         PreparedStatement stmt=null;
         String sql="INSERT INTO login (email_login,password)VALUES (?,?)";
         
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
    //Metodo que verifica se as senhas sao iguais
    public static boolean verificaSenhas(String senha1, String senha2)
    {
        return senha1.equals(senha2);
    }
    //Metodo que verifica se o email cumpre com a Regular Expression
    public static boolean verificaEmail(String email)
    {
        String emailRegex="([\\w]+[\\w\\-.]*)@([a-zA-Z0-9]+\\.[a-zA-Z0-9\\-.]+)";
        return email.matches(emailRegex);
    }
}

