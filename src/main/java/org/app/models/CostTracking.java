package org.app.models;

public class CostTracking {
    private int costBracket;
    private int noOfOrders;

    public CostTracking(int costBracket, int noOfOrders) {
        this.costBracket = costBracket;
        this.noOfOrders = noOfOrders;
    }

    public int getCostBracket() {
        return  costBracket;
    }

    public int getNoOfOrders() {
        return noOfOrders;
    }
}
