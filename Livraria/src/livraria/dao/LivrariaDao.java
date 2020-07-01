/*Classe responsavel por tratar dos livros da Livraria na Base de Dados*/


package livraria.dao;

import livraria.model.LivroModel;
import livraria.model.core.ConexaoDB;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class LivrariaDao {

    public static ArrayList<LivroModel> buscarLivros(){


        ArrayList<LivroModel> livros= new ArrayList<>();
        try {
            String query="Select * from book";
            Connection conexao= ConexaoDB.getConnection();
            PreparedStatement stm=conexao.prepareStatement(query);
            ResultSet resultado=stm.executeQuery();
            if (resultado==null)
                return null;
            else {
                while (resultado.next()){
                    livros.add(new LivroModel(
                            resultado.getInt("id_book")
                            ,resultado.getString("title")
                            ,resultado.getString("author")
                            ,resultado.getInt("page_number")
                            ,resultado.getString("category")
                            ,resultado.getString("publishing_company")
                            ,resultado.getString("cover")
                            ,resultado.getString("description")
                            ,resultado.getInt("release_year")));
                }
                return livros;
            }


        }catch (SQLException erro){

            JOptionPane.showMessageDialog(null,"Erro ao tentar buscar os livros!");
        }


        return null;
    }




}
