package com.techelevator;

public class ReserveAuction extends Auction{

    private int reservePrice = 0;

    public ReserveAuction(String itemForSale){
        super(itemForSale);
    }
    public ReserveAuction(String itemForSale, int reservePrice){
        this(itemForSale);
        this.reservePrice = reservePrice;
    }

    //Reserve Auction: Must meet a min price
    @Override
    public boolean placeBid(Bid bid){

        boolean isCurrentWinningBid = false;
        if(bid.getBidAmount() >= reservePrice){
            //if we met the reservePrice then its going
            //to behave just like a normal auction
            //which we already have the code for in our parent
            //so we can reference it with the super keyword
            isCurrentWinningBid = super.placeBid(bid);
        }

        return isCurrentWinningBid;

    }
}
