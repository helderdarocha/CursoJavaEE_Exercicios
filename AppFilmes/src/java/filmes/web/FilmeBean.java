/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmes.web;
;
import filmes.ejb.FilmeBeanEJB;
import filmes.entity.Filme;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@RequestScoped
@Named
public class FilmeBean {
    private String titulo;
    private String diretor;
    private String imdb;
    private int ano;
    private int duracao;
    
    @EJB
    FilmeBeanEJB dao;
    
    public String criarFilme() {
        Filme filme = new Filme();
        filme.setTitulo(titulo);
        filme.setDiretor(diretor);
        filme.setImdb(imdb);
        filme.setAno(ano);
        filme.setDuracao(duracao);
        
        dao.criar(filme);
        
        return "/ListarFilmes";
    }
    
    public List<Filme> getFilmes() {
        return dao.getAll();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDiretor() {
        return this.diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
    
    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }
    
    public String getImdb() {
        return imdb;
    }

    public void setImdb(String imdb) {
        this.imdb = imdb;
    }
    
}
