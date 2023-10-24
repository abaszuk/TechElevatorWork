package com.techelevator;

public class ReserveAuction extends Auction {

    private int reservePrice = 0;

    public ReserveAuction(String itemForSale, int reservePrice){
        //super is calling the parent constructor
        //super is similar to this. but is used to call from the parent class
        super(itemForSale);
        this.reservePrice = reservePrice;
    }

    //Reserve auction : must meet a min price
    @Override
    //override is using the parent placeBid method but changing it? unsure
    public boolean placeBid(Bid offeredBid){
        boolean isCurrentWinningBid = false;
        if (offeredBid.getBidAmount() >= reservePrice){
            //if we met the reserve price then its going
            //to behave just like a normal auction
            //which we already have the code for in our parent
            //so we can reference it with the super keyword.
            isCurrentWinningBid = super.placeBid(offeredBid);
        }
        return isCurrentWinningBid;
    }

}
