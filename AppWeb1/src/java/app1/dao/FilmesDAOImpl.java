package app1.dao;

import app1.filmes.Filme;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.sql.DataSource;

public class FilmesDAOImpl implements FilmesDAO {
    
    private DataSource ds;
    
    public FilmesDAOImpl(DataSource ds) {
        this.ds = ds;
    }

    @Override
    public List<Filme> getFilmes() {
        return null;
    }

    @Override
    public Filme getByIMDB(String imdb) {
        return null;
    }

    @Override
    public void delete(int id) {
    }

    @Override
    public void update(Filme alterado) {
    }

    @Override
    public int insert(Filme novo) throws SQLException {
        Connection con = ds.getConnection();
        PreparedStatement stmt = con.prepareStatement("INSERT INTO Filme (id, titulo, diretor, imdb, ano, duracao) VALUES (?,?,?,?,?,?)");
        stmt.setInt(1, nextID());
        stmt.setString(2, "The Godfather");
        stmt.setString(3, "???");
        stmt.setString(4, "tt333333333");
        stmt.setString(5, "1970");
        stmt.setString(6, "200");
        stmt.executeUpdate();
        return 0;
    }
    
    private int nextID() throws SQLException {
        Connection con = ds.getConnection();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM Filme");
        if(rs.next()) {
            return rs.getInt(1);
        }
        return 1;
    }
}
