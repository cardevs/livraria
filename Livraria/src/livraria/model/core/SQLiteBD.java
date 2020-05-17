package livraria.model.core;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class SQLiteBD {

        protected Connection conection=null;
        public Connection conectar() {
            try{
                conection= DriverManager.getConnection("jdbc:sqlite:database/livraria.db");
                System.out.println(conection);
                return conection;
            }
            catch (SQLException erro){
                JOptionPane.showMessageDialog(null, "Erro\n"+erro.getMessage());
                erro.printStackTrace();
            }
            return null;
        }
        public void desconectar() {
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


}
