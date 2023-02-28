package org.app.models;

public class User {
    private CuisineTracking[]  cuisines;
    private CostTracking[] costBrackets;

    public User(CuisineTracking[] cuisines, CostTracking[] costBrackets) {
        this.cuisines = cuisines;
        this.costBrackets = costBrackets;
    }

    public CuisineTracking[] getCuisines() {
        return cuisines;
    }

    public CostTracking[] getCostBrackets() {
        return costBrackets;
    }
}
