package org.neo4j.movies.movieimport;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.neo4j.movies.domain.Actor;
import org.neo4j.movies.domain.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

/**
 * @author mh
 * @since 13.03.11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/movies-test-context.xml"})
@Transactional
public class MovieDbImportServiceTest {

    @Autowired
    MovieDbImportService importService;

    @Test
    public void testImportMovie() throws Exception {
        Movie movie = importService.importMovie("2");
        assertEquals("movie-id",2, movie.getId());
        assertEquals("movie-title","Ariel", movie.getTitle());
    }

    @Test
    public void testImportPerson() throws Exception {
        Actor actor = importService.importPerson("105955", new Actor());
        assertEquals("movie-id",105955, actor.getId());
        assertEquals("movie-title","George M. Williamson", actor.getName());
    }
}
