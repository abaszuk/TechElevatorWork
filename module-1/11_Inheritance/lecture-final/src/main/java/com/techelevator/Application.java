package com.techelevator;

public class Application {

    public static void main(String[] args) {

        /*
        Parent p = new Parent();
        p.setParentProperty("Hair Color");
        p.getParentProperty();
        p.whoAmI();

        System.out.println("***************");

        Child c = new Child();
        c.setParentProperty("Hair Color");
        c.getParentProperty();
        c.setChildProperty("Eye Color");
        c.getChildProperty();
        c.whoAmI();

        System.out.println("***************");

        Grandchild g = new Grandchild();
        g.setParentProperty("Hair Color");
        g.getParentProperty();
        g.setChildProperty("Eye Color");
        g.getChildProperty();
        g.setGrandchildProperty("Height");
        g.getGrandchildProperty();
        g.whoAmI();

        System.out.println("***************");


        System.out.println("Is Grandchild A Child? " + (g instanceof Child));
        System.out.println("Is Grandchild A Parent? " + (g instanceof Parent));
       // System.out.println("Is Grandchild A String? " + (g instanceof String));

        System.out.println("Is Parent A Child? " + (p instanceof Child));
*/


        // Create a new general auction
        System.out.println("Starting a general auction");
        System.out.println("-----------------");

        Auction generalAuction = new Auction("Tech Elevator t-shirt");

        generalAuction.placeBid(new Bid("Josh", 1));
        generalAuction.placeBid(new Bid("Fonz", 23));
        generalAuction.placeBid(new Bid("Rick Astley", 13));
        //....
        //....
        // This might go on until the auction runs out of time or hits a max # of bids

        ReserveAuction ra = new ReserveAuction("Movie",10);
        ra.placeBid(new Bid("Josh", 1));
    }
}
