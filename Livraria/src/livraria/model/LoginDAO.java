/*
Esta classe é Responsavel por Executar todos os metódos e função do processo de 
Login de um usuário.
*/
package livraria.model;

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
/*Metódo responsavél por verificar a senha e nome do Usuario na Base de Dados*/
     public boolean entrar( String usuarioName, String usuarioPass)
    {
        Connection conn=ConexaoDB.getConnection();//Abertura da conexão com a base de Dados
        PreparedStatement statement=null;//Variavel de preparação de statement
        ResultSet resultSet=null;//Variavel que guarda os resultados que vêm da da BD
        boolean checkLogin=false;
        try {
            statement=conn.prepareStatement("SELECT * FROM login WHERE username=? and password=?");
            statement.setString(1, usuarioName);
            statement.setString(2, usuarioPass);
            resultSet=statement.executeQuery();
            
            if (resultSet.next()) {
                checkLogin=true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            ConexaoDB.closeConnection(conn);
            ConexaoDB.closeStatement(statement);
        }
        return checkLogin;
    }
}
