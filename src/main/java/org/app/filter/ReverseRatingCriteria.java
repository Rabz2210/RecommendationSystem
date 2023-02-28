package org.app.filter;

import org.app.models.Restaurant;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ReverseRatingCriteria implements Criteria{
    float rating;

    @Override
    public List<Restaurant> meetCriteria(List<Restaurant> Restaurants) {
        if(Objects.isNull(Restaurants)) return Restaurants;
        List<Restaurant> filteredRestaurants = new ArrayList<>();
        for(Restaurant restaurant:Restaurants){
            if(restaurant.getRating()<this.rating){
                filteredRestaurants.add(restaurant);
            }
        }
        return filteredRestaurants;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
