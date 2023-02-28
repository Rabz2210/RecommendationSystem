package org.app.condition;

import org.app.models.Restaurant;
import org.app.sorter.CostBracketIdentifier;
import org.app.sorter.CuisineSorter;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//Top 4 newly created restaurants by rating

public class ConditionFive extends BaseCondition{

    int NoOfHours;
    int NoOfTopRestaurants;
    public ConditionFive(int NoOfHours,int NoOfTopRestaurants){

        this.NoOfHours = NoOfHours;
        this.NoOfTopRestaurants = NoOfTopRestaurants;
    }

    @Override
    public void executeCondition(List<Restaurant> availableRestaurants, List<Restaurant> res, CuisineSorter cuisineIdentifier, CostBracketIdentifier bracketIdentifier) {

        //setting no of hours for onboarding
        onBoardingCriteria.setNoOfHours(this.NoOfHours);
        List<Restaurant> r1 = onBoardingCriteria.meetCriteria(availableRestaurants);

        //Sorting to get the top 4
        r1.sort(Comparator.comparing(Restaurant::getRating).reversed());

        if(this.NoOfTopRestaurants==0 || r1.size()==0)return;
        r1 = r1.size()<=this.NoOfTopRestaurants?r1:r1.subList(0,this.NoOfTopRestaurants);
        addToResult(res,r1.subList(0,this.NoOfTopRestaurants));
    }
}
