package org.app.filter;

import org.app.models.Restaurant;

import java.util.List;

public class AndCriteria implements Criteria{
    private Criteria firstCriteria;
    private Criteria otherCriteria;

    public AndCriteria(Criteria first,Criteria second){
        this.firstCriteria = first;
        this.otherCriteria = second;
    }
    @Override
    public List<Restaurant> meetCriteria(List<Restaurant> Restaurants) {
        List<Restaurant> firstRestaurants = firstCriteria.meetCriteria(Restaurants);
        return otherCriteria.meetCriteria(firstRestaurants);
    }
}
