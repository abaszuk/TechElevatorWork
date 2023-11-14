package com.techelevator.dao;

import com.techelevator.model.Park;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class JdbcParkDao implements ParkDao {

    private final JdbcTemplate jdbcTemplate;

    public JdbcParkDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public int getParkCount() {
        //step 1 - declare the variable we intent to return
        int numParks = 0;

        //step 2 -write the sql and store it in a string
        String sql = "SELECT COUNT(*) AS park_count\n" +
                "FROM park";

        //step 3 - send sql to the database using the jdbcTemplate
        //          and save the results in a SqlRowSet
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        //step 4 - check if there are results and read them
        while (results.next()){
            numParks = results.getInt("park_count");
        }

        //step 5 - return the variable declared at the beginning
        return numParks;
    }
    
    @Override
    public LocalDate getOldestParkDate() {
        return null;
    }
    
    @Override
    public double getAverageParkArea() {
        return 0.0;
    }
    
    @Override
    public List<String> getParkNames() {
        return new ArrayList<>();
    }
    
    @Override
    public Park getRandomPark() {
        return new Park();
    }

    @Override
    public List<Park> getParksWithCamping() {
        return new ArrayList<>();
    }

    @Override
    public Park getParkById(int parkId) {
        return new Park();
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        //step 1 - declare the variable we want to return
        List<Park> parks = new ArrayList<>();

        //step 2 - write our sql
        String sql = "SELECT park.park_id,park_name,date_established,area,has_camping\n" +
                "FROM park\n" +
                "JOIN park_state ON park.park_id = park_state.park_id\n" +
                "WHERE state_abbreviation = ?;";

        //step 3 - send results to database and store results in sql row set
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,stateAbbreviation);

        //step 4 - check if there is data in the result set and read it
        while(results.next()){
            mapRowToPark(results);
        }
        //step 5 - return our variable we declared at the beginning
        return parks;
    }

    @Override
    public List<Park> getParksByName(String name, boolean useWildCard) { return new ArrayList<>(); }

    private Park mapRowToPark(SqlRowSet results) {
        Park park = new Park();

        int parkId = results.getInt("park_id");
        park.setParkId(parkId);

        String parkName = results.getString("park_name");
        park.setParkName(parkName);

        Double area = results.getDouble("area");
        park.setArea(area);

        boolean hasCamping = results.getBoolean("has_camping");
        park.setHasCamping(hasCamping);

        if (results.getDate("date_established") != null) {
            LocalDate dateEstablished = results.getDate("date_established").toLocalDate();
            park.setDateEstablished(dateEstablished);
        }
        return park;
    }
}
