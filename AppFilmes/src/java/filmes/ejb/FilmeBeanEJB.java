/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filmes.ejb;

import filmes.entity.Filme;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Stateless
public class FilmeBeanEJB {
    
    @PersistenceContext(unitName="AppFilmesPU")
    EntityManager em;
    
    public void criarOuEditar(Filme filme) {
        em.merge(filme);
    }
    
    public List<Filme> getAll() {
        TypedQuery<Filme> query = 
                em.createQuery("select x from Filme x", Filme.class);
        return query.getResultList();
    }
    
    public void delete(Filme f) {
        em.remove(em.merge(f));
    }
    
    public void update(Filme f) {
        em.merge(f);
    }
}
