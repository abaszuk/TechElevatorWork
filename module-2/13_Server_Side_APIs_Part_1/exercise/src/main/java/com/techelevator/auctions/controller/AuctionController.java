package com.techelevator.auctions.controller;

import com.techelevator.auctions.dao.AuctionDao;
import com.techelevator.auctions.dao.MemoryAuctionDao;
import com.techelevator.auctions.model.Auction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private AuctionDao auctionDao;

    public AuctionController() {
        this.auctionDao = new MemoryAuctionDao();
    }

    @RequestMapping(path = "", method = RequestMethod.GET)
    public List<Auction> list(@RequestParam(required = false) String title_like, @RequestParam(defaultValue = "0", value = "currentBid_lte") double currentBidLTE) {
        if (title_like != null && currentBidLTE != 0){
            return auctionDao.getAuctionsByTitleAndMaxBid(title_like, currentBidLTE);
        } else if (title_like != null){
            return auctionDao.getAuctionsByTitle(title_like);
        } else if (currentBidLTE != 0){
            return auctionDao.getAuctionsByMaxBid(currentBidLTE);
        }
        return auctionDao.getAuctions();
    }
    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Auction get(@PathVariable int id) {
        return auctionDao.getAuctionById(id);
    }
    @RequestMapping(path="", method=RequestMethod.POST)
    public Auction createAuction(@RequestBody Auction newAuction){
        return auctionDao.createAuction(newAuction);
    }

}
