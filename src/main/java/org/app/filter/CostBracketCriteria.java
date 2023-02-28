package org.app.filter;

import org.app.models.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CostBracketCriteria implements Criteria{
    private List<Integer> costBracket;



    @Override
    public List<Restaurant> meetCriteria(List<Restaurant> Restaurants) {
        if(Objects.isNull(Restaurants)) return Restaurants;
       List<Restaurant> filteredRestaurants = new ArrayList<>();
       for(Restaurant restaurant: Restaurants){
           if(costBracket.contains(restaurant.getCostBracket())){
               filteredRestaurants.add(restaurant);
           }
       }
       return filteredRestaurants;
    }

    public List<Integer> getCostBracket() {
        return costBracket;
    }

    public void setCostBracket(List<Integer> costBracket) {
        this.costBracket = costBracket;
    }
}
