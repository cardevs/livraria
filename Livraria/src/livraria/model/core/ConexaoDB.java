package livraria.model.core;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
/*Class usada para abrir e fechar a conexão com a base de Dados*/
public class ConexaoDB {

        //protected Connection conection=null;

        public static Connection getConnection(){
            Connection conection=null;
            try {
            Class.forName("org.sqlite.JDBC");
            conection=DriverManager.getConnection("jdbc:sqlite:database/livraria.db");
            System.out.println("Conectado com sucesso!!");
        } catch (ClassNotFoundException | SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro\n"+erro.getMessage());
        }
            return conection;
    }
        public static void closeConnection(Connection conection) {
            if(conection!=null){
                try {
                    conection.close();           
                }
                catch (SQLException erro){
                    System.out.println("Erro ao tentar fechar o Banco de Dados!");
                    erro.printStackTrace();
                }
            }
        }
        
        public static void closeStatement(Statement stmt) {
        try {
                if (stmt != null) {
                    stmt.close();
                }
            }catch (SQLException erro) {
                erro.printStackTrace();
            }
        }
        public static void closeConnection(Connection  con,Statement stmt,ResultSet rs){
            closeConnection(con);
            closeStatement(stmt);
            if(rs!=null){
                try {
                    rs.close();           
                }
                catch (SQLException erro){
                    System.out.println("Erro ao tentar fechar o Banco de Dados!");
                    erro.printStackTrace();
                }
            }
        
        }
}
