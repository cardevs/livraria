
package livraria.model;

import com.sun.net.httpserver.Authenticator;
import javax.security.auth.login.FailedLoginException;

public class PessoaModel {
    private int id_utilizador;
    private String nome;
    private String sobrenome;
    private String email;
    private String aniversario;
    private String senha;
    private String senhaTest;
    //private String senhaTest;//Atributo que recebe a senha para confirmar é mesma

    public PessoaModel() {
    }

    public PessoaModel(String nome, String sobrenome, String email, String aniversario, String senha,String senhaTest) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.aniversario = aniversario;
        this.senha = senha;
        this.senhaTest=senhaTest;
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

    public String getSenhaTest() {
        return senhaTest;
    }

    public void setSenhaTest(String senhaTest) {
        this.senhaTest = senhaTest;
    }
    
}
