package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Newsletter;

public interface NewsletterDao {

    Newsletter createNewsletter(String name);

    boolean subscribe(int newsletterId, int userId);

    boolean unsubscribe(int newsletterId, int userId);

}
