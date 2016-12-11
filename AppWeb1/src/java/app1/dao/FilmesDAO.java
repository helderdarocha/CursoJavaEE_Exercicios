package app1.dao;

import app1.filmes.Filme;
import java.sql.SQLException;
import java.util.List;

public interface FilmesDAO {
    public List<Filme> getFilmes() throws SQLException;
    public Filme getByIMDB(String imdb) throws SQLException;
    
    public void delete(int id) throws SQLException;
    public void update(Filme alterado) throws SQLException;
    public int insert(Filme novo) throws SQLException;

}
