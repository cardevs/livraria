package livraria.classes;

public class CapaLivro {
    private int id;
    private String nome;
    private String url;

    public CapaLivro(String nome, String url) {
        this.nome = nome;
        this.url = url;
    }

    public CapaLivro(int id, String nome, String url) {
        this.id = id;
        this.nome = nome;
        this.url = url;
    }

    public CapaLivro(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.url="recursos/img/"+nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
