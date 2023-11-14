package com.techelevator.movies.dao;

import com.techelevator.movies.model.Genre;
import com.techelevator.movies.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcPersonDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Person> getPersons() {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM person;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            persons.add(mapRowToPerson(results));
        }
        return persons;
    }

    @Override
    public Person getPersonById(int id) {
        Person person = null;
        String sql = "SELECT *\n" +
                "FROM person\n" +
                "WHERE person_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);
        if (results.next()){
            person = mapRowToPerson(results);
        }
        return person;
    }

    @Override
    public List<Person> getPersonsByName(String name, boolean useWildCard) {
        List<Person> persons = new ArrayList<>();
        String sql = "SELECT *\n" +
                "FROM person\n" +
                "WHERE person_name ILIKE ?;";
        if (useWildCard){
            name = "%"+name+"%";
        }
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,name);
        while(results.next()){
            persons.add(mapRowToPerson(results));
        }
        return persons;
    }

    @Override
    public List<Person> getPersonsByCollectionName(String collectionName, boolean useWildCard) {
        return null;
    }
    private Person mapRowToPerson(SqlRowSet rowSet) {
        Person person = new Person();
        person.setId(rowSet.getInt("person_id"));
        person.setName(rowSet.getString("person_name"));
        person.setBiography(rowSet.getString("biography"));
        person.setProfilePath(rowSet.getString("profile_path"));
        person.setHomePage(rowSet.getString("home_page"));


        return person;
    }
}
