package org.app.filter;

import org.app.models.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FeaturedCriteria implements Criteria{
    @Override
    public List<Restaurant> meetCriteria(List<Restaurant> Restaurants) {
        if(Objects.isNull(Restaurants)) return Restaurants;
        List<Restaurant> featuredRestaurants = new ArrayList<>();

        for(Restaurant restaurant : Restaurants){
            if(restaurant.isRecommended()){
                featuredRestaurants.add(restaurant);
            }
        }
        return featuredRestaurants;
    }
}
