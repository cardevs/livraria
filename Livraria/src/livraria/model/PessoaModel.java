
package livraria.model;

import com.sun.net.httpserver.Authenticator;
import java.sql.Date;
import java.time.LocalDate;
import javax.security.auth.login.FailedLoginException;

public class PessoaModel {
    private int id_utilizador;
    private String nome;
    private String sobrenome;
    private String email;
    private String aniversario;
    private String senha;
    //private String senhaTest;//Atributo que recebe a senha para confirmar é mesma

    public PessoaModel() {
    }

    public int getId_utilizador() {
        return id_utilizador;
    }

    public void setId_utilizador(int id_utilizador) {
        this.id_utilizador = id_utilizador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
}
