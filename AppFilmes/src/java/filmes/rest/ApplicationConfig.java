package filmes.rest;

import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("restapi")
public class ApplicationConfig extends Application {
/*
    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        resources.add(filmes.ejb.FilmeBeanEJB.class);
        return resources;
    }
    */
}
