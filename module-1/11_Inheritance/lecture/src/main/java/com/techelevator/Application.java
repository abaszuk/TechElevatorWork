package com.techelevator;

public class Application {

    public static void main(String[] args) {
/*
        Parent p = new Parent();
        p.setParentProperty("Hair Color");
        p.getParentProperty();
        p.whoAmI();

        Child c = new Child();
        c.setParentProperty("Hair Color");
        c.getParentProperty();
        c.setParentProperty("Eye Color");
        c.getChildProperty();
        c.whoAmI();

        Grandchild g = new Grandchild();
        g.setParentProperty("Hair Color");
        g.getParentProperty();
        g.setChildProperty("Eye Color");
        g.getChildProperty();
        g.setGrandChildProperty("Height");
        g.getGrandChildProperty();
        g.whoAmI();

        System.out.println("Is grandchild a child? " + (g instanceof Child));
        System.out.println("Is GrandChild a Parent? " + (g instanceof Parent));

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

    }
}
