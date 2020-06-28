/*
Esta classe é Responsavel por Executar todos os metódos e função do processo de 
Login de um usuário.
*/
package livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import livraria.model.core.ConexaoDB;

/**
 *
 * @author Adamastor Chimalange
 * @author Adolfo Quende
 * @author Edson Kay
 */
public class LoginDAO {
/*Método responsavél por verificar a senha e nome do Usuario na Base de Dados*/
     public boolean entrar( String usuarioEmail, String usuarioPass)
    {
        Connection conn=ConexaoDB.getConnection();//Abertura da conexão com a base de Dados
        PreparedStatement statement=null;//Variavel de preparação de statement
        ResultSet resultSet=null;//Variavel que guarda os resultados que vêm da da BD
        boolean checkLogin=false;
        try {
            statement=conn.prepareStatement("SELECT * FROM login WHERE email_login=? and password=?");
            statement.setString(1, usuarioEmail);
            statement.setString(2, usuarioPass);
            resultSet=statement.executeQuery();
            
            if (resultSet.next()) {
                checkLogin=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConexaoDB.closeConnection(conn,statement,resultSet);
        }
        return checkLogin;
    }
}
