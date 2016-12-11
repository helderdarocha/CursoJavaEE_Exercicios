/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app1.filmes.service;

import app1.dao.FilmesDAO;
import app1.dao.FilmesDAOImpl;
import app1.filmes.Filme;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;

/**
 *
 * @author helderdarocha
 */
class ComandoListar implements Comando {

    private DataSource ds;

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FilmesDAO dao = new FilmesDAOImpl(ds);
        try {
            List<Filme> filmes = dao.getFilmes();

            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Lista de Filmes</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Lista de Filmes</h1>");

                out.println("<table border>");
                for (Filme f : filmes) {
                    out.println("<tr>");
                    out.println("<td>" + f.getImdb() + "</td>");
                    out.println("<td>" + f.getTitulo() + "</td>");
                    out.println("<td>" + f.getDiretor() + "</td>");
                    out.println("<td>" + f.getAno() + "</td>");
                    out.println("<td>" + f.getDuracao() + "</td>");
                    out.println("</tr>");
                }
                out.println("</table>");

                out.println("</body>");
                out.println("</html>");
            }

        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    @Override
    public void setDataSource(DataSource ds) {
        this.ds = ds;
    }

}
