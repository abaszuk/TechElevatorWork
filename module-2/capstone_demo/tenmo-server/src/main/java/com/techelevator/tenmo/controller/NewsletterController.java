package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.NewsletterDao;
import com.techelevator.tenmo.dao.UserDao;
import com.techelevator.tenmo.model.Newsletter;
import com.techelevator.tenmo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@PreAuthorize("isAuthenticated()")
public class NewsletterController {

    @Autowired
    private NewsletterDao newsletterDao;

    @Autowired
    private UserDao userDao;

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(path="/newsletter", method= RequestMethod.POST)
    public Newsletter create(@RequestParam String name){
        return newsletterDao.createNewsletter(name);
    }

    @RequestMapping(path="/subscribe/{newsletterId}", method=RequestMethod.POST)
    public boolean subscribe(@PathVariable int newsletterId, Principal principal){

        String username = principal.getName();
        User user = userDao.getUserByUsername(username);

        return newsletterDao.subscribe(newsletterId, user.getId());
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @RequestMapping(path="/unsubscribe/{newsletterId}", method=RequestMethod.DELETE)
    public void unsubscribe(@PathVariable int newsletterId, Principal principal){

        String username = principal.getName();
        User user = userDao.getUserByUsername(username);

        newsletterDao.unsubscribe(newsletterId, user.getId());
    }
}
