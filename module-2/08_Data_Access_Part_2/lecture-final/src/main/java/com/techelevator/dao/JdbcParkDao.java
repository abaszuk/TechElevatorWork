package com.techelevator.dao;

import com.techelevator.exception.DaoException;
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
        int parkCount = 0;
        String sql = "SELECT COUNT(*) AS count FROM park;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		if (results.next()) {
			parkCount = results.getInt("count");
		} 
        return parkCount;
    }
    
    @Override
    public List<String> getParkNames() {
        List<String> parkNames = new ArrayList<>();
        String sql = "SELECT park_name FROM park ORDER by park_name ASC;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            parkNames.add(results.getString("park_name"));
        }
        return parkNames;
    }
    
    @Override
    public Park getRandomPark() {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park ORDER BY RANDOM() LIMIT 1;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        if (results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksWithCamping() {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE has_camping = true;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }
        return parks;
    }

    @Override
    public Park getParkById(int parkId) {
        Park park = null;
        String sql = "SELECT park_id, park_name, date_established, area, has_camping " +
                     "FROM park " +
                     "WHERE park_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkId);
        if (results.next()) {
            park = mapRowToPark(results);
        }
        return park;
    }

    @Override
    public List<Park> getParksByState(String stateAbbreviation) {
        List<Park> parks = new ArrayList<>();
        String sql = "SELECT p.park_id, park_name, date_established, area, has_camping " +
                     "FROM park p " +
                     "JOIN park_state ps ON p.park_id = ps.park_id " +
                     "WHERE state_abbreviation = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, stateAbbreviation);
        while (results.next()) {
            parks.add(mapRowToPark(results));
        }
        return parks;
    }

    @Override
    public Park createPark(Park park) {
       //Step 1 - declare the variable we want to return
        Park newPark = null;

        //Step 2 - write the sql
        String sql = "INSERT INTO park(park_name, date_established, area, has_camping)\n" +
                "VALUES( ?, ?, ?, ?) RETURNING park_id;";

        try{

            //Step 3 - send the sql to the database
            int parkId = jdbcTemplate.queryForObject(sql, int.class,  park.getParkName(),
                   park.getDateEstablished(), park.getArea(), park.getHasCamping() );

           //Step 4 - read the data
            newPark = getParkById(parkId);

        } catch(Exception ex){
            System.out.println("Something went wrong");
        }

        //Step 5
        return newPark;
    }

    @Override
    public Park updatePark(Park park) {
        //Step 1
        Park updatedPark = null;

        //Step 2
        String sql = "UPDATE park SET park_name = ?, date_established=?, area=?, has_camping=? WHERE park_id = ?";

        try{

            //Step 3
            int numRows = jdbcTemplate.update(sql, park.getParkName(), park.getDateEstablished(), park.getArea()
                    , park.getHasCamping(), park.getParkId());

            if(numRows == 0) {
                throw new DaoException("Zero rows affected, expected at least 1");
            } else {
                updatedPark = getParkById(park.getParkId());
            }

        } catch(Exception ex){
            System.out.println("Something went wrong");
        }

        return updatedPark;
    }

    @Override
    public int deleteParkById(int parkId) {
        //Step 1
        int numDeleted = 0;

        //Step 2
        String sql = "BEGIN TRANSACTION;\n" +
                "DELETE\n" +
                "FROM park_state\n" +
                "WHERE park_id = ?;\n" +
                "DELETE\n" +
                "FROM park\n" +
                "WHERE park_id = ?;\n" +
                "COMMIT;";

        try{
            //Step 3
            numDeleted = jdbcTemplate.update(sql, parkId, parkId);

        } catch(Exception ex) {
            System.out.println("Something went wrong");
        }

        //Step 5
        return numDeleted;
    }

    @Override
    //This is inserting a new row into the park_state table
    public void linkParkState(int parkId, String stateAbbreviation) {

        String sql = "INSERT INTO park_state(park_id, state_abbreviation) " +
                    "VALUES( ?, ?)";

        try{

            int rowAffected = jdbcTemplate.update(sql, parkId, stateAbbreviation);

            if(rowAffected == 0){
                throw new DaoException("Zero rows affected, expected at least one");
            }

        } catch(Exception ex) {

        }

    }

    private Park mapRowToPark(SqlRowSet rowSet) {
        Park park = new Park();
        park.setParkId(rowSet.getInt("park_id"));
        park.setParkName(rowSet.getString("park_name"));
        park.setDateEstablished(rowSet.getDate("date_established").toLocalDate());
        park.setArea(rowSet.getDouble("area"));
        park.setHasCamping(rowSet.getBoolean("has_camping"));
        return park;
    }
}
