package org.app.filter;

import org.app.models.Cuisine;
import org.app.models.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CuisineCriteria implements Criteria{

    private  List<Cuisine> cuisines;


    @Override
    public List<Restaurant> meetCriteria(List<Restaurant> Restaurants) {
        if(Objects.isNull(Restaurants) || Objects.isNull(cuisines) || cuisines.size()==0) return Restaurants;
        List<Restaurant> filteredRestaurants = new ArrayList<>();
        for(Restaurant restaurant: Restaurants){
            if(cuisines.contains(restaurant.getCuisine())){
                filteredRestaurants.add(restaurant);
            }
        }
        return filteredRestaurants;
    }

    public List<Cuisine> getCuisines() {
        return cuisines;
    }

    public void setCuisines(List<Cuisine> cuisines) {
        this.cuisines = cuisines;
    }
}
