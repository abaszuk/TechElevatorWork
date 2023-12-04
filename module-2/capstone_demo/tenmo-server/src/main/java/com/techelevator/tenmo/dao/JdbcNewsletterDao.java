package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Newsletter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class JdbcNewsletterDao implements NewsletterDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public Newsletter createNewsletter(String name) {

        //Step 1 - declare what we want to return
        Newsletter createdNewsletter = null;

        //Step 2 - write our sql
        String sql = "INSERT INTO newsletter(newsletter_name)\n" +
                "VALUES(?) RETURNING newsletter_id;";

        //Step 3 - send the sql to the database
        try{

            int newsLetterId = jdbcTemplate.queryForObject(sql, int.class, name);

            //Step 4 - create the object from data
            createdNewsletter = new Newsletter();
            createdNewsletter.setNewsletterId(newsLetterId);
            createdNewsletter.setNewsletterName(name);

        } catch(Exception ex){
            System.out.println("Something went wrong");
        }

        //Step 5 - return what we declared in step 1
        return createdNewsletter;
    }

    @Override
    public boolean subscribe(int newsletterId, int userId) {
        //Step 1, declare what we want to return
        boolean successful = false;

        //Step 2 - write the sql
        String sql = "INSERT INTO newsletter_subscribers(newsletter_id, user_id)\n" +
                "VALUES(?, ?);";

        //Step 3 - send to the database
        try{
            jdbcTemplate.update(sql, newsletterId, userId);

            //Step 4 - prepping return object
            successful = true;

        } catch(Exception ex){
            System.out.println("Something went wrong");
        }

        return successful;
    }

    @Override
    public boolean unsubscribe(int newsletterId, int userId) {
        //Step 1, declare what we want to return
        boolean successful = false;

        //Step 2 - write the sql
        String sql = "DELETE\n" +
                "FROM newsletter_subscribers\n" +
                "WHERE newsletter_id = ? and user_id = ?;";

        //Step 3 - send to the database
        try{
            jdbcTemplate.update(sql, newsletterId, userId);

            //Step 4 - prepping return object
            successful = true;

        } catch(Exception ex){
            System.out.println("Something went wrong");
        }

        return successful;
    }
}
