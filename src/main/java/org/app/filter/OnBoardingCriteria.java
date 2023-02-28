package org.app.filter;

import org.app.models.Restaurant;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class OnBoardingCriteria implements Criteria{

    int noOfHours;

    @Override
    public List<Restaurant> meetCriteria(List<Restaurant> Restaurants) {
        Instant now = Instant.now();
        List<Restaurant> restaurantsInLastXHours = new ArrayList<>();
        for(Restaurant restaurant: Restaurants){
            Boolean isWithinPriorXHours =
                    ( ! restaurant.getOnboardedTime().toInstant().isBefore( now.minus( this.noOfHours , ChronoUnit.HOURS) ) )
                            &&
                            ( restaurant.getOnboardedTime().toInstant().isBefore( now )
                            ) ;
            if(isWithinPriorXHours) restaurantsInLastXHours.add(restaurant);
        }
        return restaurantsInLastXHours;
    }

    public int getNoOfHours() {
        return noOfHours;
    }

    public void setNoOfHours(int noOfHours) {
        this.noOfHours = noOfHours;
    }
}
