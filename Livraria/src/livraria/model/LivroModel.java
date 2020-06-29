/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package livraria.model;

/**
 *
 * @author Adamastor Chimalange
 */
public class LivroModel {
   private int id;
    private String titulo;
    private String autor;
    private int paginas;
    private String categoria;
    private String editora;
    private String capa;
    private String descricao;
    private int anoDeLancamento;

    public LivroModel(String titulo,String autor,String categoria,String editora,int anoDeLancamento,int paginas,String descricao,String capa) {
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.categoria = categoria;
        this.editora = editora;
        this.capa = capa;
        this.anoDeLancamento=anoDeLancamento;
        this.descricao = descricao;
    }

    public LivroModel(int id, String titulo, String autor, int paginas, String categoria, String editora, String capa, String descricao, int anoDeLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.paginas = paginas;
        this.categoria = categoria;
        this.editora = editora;
        this.capa = capa;
        this.descricao = descricao;
        this.anoDeLancamento = anoDeLancamento;
    }

    public int getAnoDeLancamento() {
        return anoDeLancamento;
    }

    public void setAnoDeLancamento(int anoDeLancamento) {
        this.anoDeLancamento = anoDeLancamento;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getPaginas() {
        return paginas;
    }

    public void setPaginas(int paginas) {
        this.paginas = paginas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String edicao) {
        this.editora = edicao;
    }

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    @Override
    public String toString(){
        return titulo+"\n"+autor+"\n"+paginas+"\n"+categoria+"\n"+editora+"\n"+descricao+"\n"+anoDeLancamento+"\n"+capa;
    }
}
    
