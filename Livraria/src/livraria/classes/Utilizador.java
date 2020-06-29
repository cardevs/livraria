/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.classes;

/**
 *
 * @author Carneiro Dev
 */
public class Utilizador {

    private Integer id;
    private String nomeUtilizador;
    private String senha;

    public Utilizador(Integer id, String nomeUtilizador, String senha) {
        this.id = id;
        this.nomeUtilizador = nomeUtilizador;
        this.senha = senha;
    }

    public Utilizador(String nomeUtilizador, String senha) {
        this.nomeUtilizador = nomeUtilizador;
        this.senha = senha;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeUtilizador() {
        return nomeUtilizador;
    }

    public void setNomeUtilizador(String nomeUtilizador) {
        this.nomeUtilizador = nomeUtilizador;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
