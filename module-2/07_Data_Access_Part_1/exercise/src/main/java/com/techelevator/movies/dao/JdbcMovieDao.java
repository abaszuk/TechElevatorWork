package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import com.techelevator.movies.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcMovieDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT movie_id,title,overview,tagline,poster_path,home_page,release_date,length_minutes,director_id,collection_id\n" +
                "FROM movie;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    @Override
    public Movie getMovieById(int id) {
        Movie movie = null;
        String sql = "SELECT movie_id,title,overview,tagline,poster_path,home_page,release_date,length_minutes,director_id,collection_id\n" +
                "FROM movie\n" +
                "WHERE movie_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
        if (results.next()){
            movie = mapRowToMovie(results);
        }
        return movie;
    }

    @Override
    public List<Movie> getMoviesByTitle(String title, boolean useWildCard) {
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT movie_id,title,overview,tagline,poster_path,home_page,release_date,length_minutes,director_id,collection_id\n" +
                "FROM movie\n" +
                "WHERE title ILIKE ?;";
        if (useWildCard){
            title = "%"+title+"%";
        }
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,title);
        while (results.next()){
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    @Override
    public List<Movie> getMoviesByDirectorNameAndBetweenYears(String directorName, int startYear,
                                                              int endYear, boolean useWildCard) {
        LocalDate startDate = LocalDate.of(startYear,1,1);
        LocalDate endDate = LocalDate.of(endYear,12,31);
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT movie.movie_id,movie.title,movie.overview,movie.tagline,movie.poster_path,movie.home_page,movie.release_date,movie.length_minutes,movie.director_id,movie.collection_id\n" +
                "FROM person\n" +
                "JOIN movie ON person.person_id = movie.director_id\n" +
                "WHERE person_name ILIKE ?\n" +
                "\tAND release_date BETWEEN ? AND ?;";
        if (useWildCard) {
            directorName = "%" + directorName + "%";
        }
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,directorName,startDate,endDate);
        while (results.next()){
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }
    private Movie mapRowToMovie(SqlRowSet rowSet) {
        Movie movie = new Movie();
        movie.setId(rowSet.getInt("movie_id"));
        movie.setTitle(rowSet.getString("title"));
        movie.setOverview(rowSet.getString("overview"));
        movie.setTagline(rowSet.getString("tagline"));
        movie.setPosterPath(rowSet.getString("poster_path"));
        movie.setHomePage(rowSet.getString("home_page"));
        movie.setLengthMinutes(rowSet.getInt("length_minutes"));
        movie.setDirectorId(rowSet.getInt("director_id"));
        movie.setCollectionId(rowSet.getInt("collection_id"));

        if(rowSet.getDate("release_date") != null) {
            LocalDate releaseDate = rowSet.getDate("release_date").toLocalDate();
            movie.setReleaseDate(releaseDate);
        }
        return movie;
    }
}
