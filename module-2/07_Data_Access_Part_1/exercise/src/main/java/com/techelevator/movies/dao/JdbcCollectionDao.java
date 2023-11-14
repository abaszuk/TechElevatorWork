package com.techelevator.movies.dao;

import com.techelevator.movies.model.Collection;
import com.techelevator.movies.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao{

    private final JdbcTemplate jdbcTemplate;

    public JdbcCollectionDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public List<Collection> getCollections() {
        List<Collection> collections = new ArrayList<>();
        String sql = "SELECT collection_id,collection_name\n" +
                "FROM collection;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()){
            collections.add(mapRowToCollection(results));
        }
        return collections;
    }

    @Override
    public Collection getCollectionById(int id) {
        //step 1 declare the variable we want to return
        Collection collection = null;

        //step 2 - write the sql
        String sql = "SELECT collection_id,collection_name\n" +
                "FROM collection\n" +
                "WHERE collection_id = ?";

        //step 3 - send to the database
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);

        //step 4 - while there is data to read, read it
        while(results.next()){
            collection = new Collection();

            int collectionId = results.getInt("collection_id");
            collection.setId(collectionId);

            String name = results.getString("collection_name");
            collection.setName(name);
        }
        //step 5 - return the variable we declared in step 1
        return collection;
    }

    @Override
    public List<Collection> getCollectionsByName(String name, boolean useWildCard) {
        List<Collection> collections = new ArrayList<>();
        String sql ="SELECT collection_id, collection_name\n" +
                "FROM collection\n" +
                "WHERE collection_name ILIKE ?";
        if (useWildCard){
            name = "%"+name+"%";
        }
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,name);
        while (results.next()){
            collections.add(mapRowToCollection(results));
        }
        return collections;
    }

    private Collection mapRowToCollection(SqlRowSet rowSet) {
        Collection collection = new Collection();
        collection.setName(rowSet.getString("collection_name"));
        collection.setId(rowSet.getInt("collection_id"));
        return collection;
    }
}
