package org.app.filter;

import org.app.condition.*;
import org.app.models.Cuisine;
import org.app.models.Restaurant;
import org.app.sorter.CostBracketIdentifier;
import org.app.sorter.CuisineSorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DefaultCriteriaSet implements CriteriaSet{

    List<BaseCondition> baseConditions;

    public DefaultCriteriaSet(){
        baseConditions = new ArrayList<>();
        baseConditions.add(new ConditionOne());
        baseConditions.add(new ConditionTwo(4));
        baseConditions.add(new ConditionThree(4.5f));
        baseConditions.add(new ConditionFour(4.5f));
        baseConditions.add(new ConditionFive(48,4));
        baseConditions.add(new ConditionSix(4f));
        baseConditions.add(new ConditionSeven(4.5f));
        baseConditions.add(new ConditionEight(4.5f));
        baseConditions.add(new ConditionNine());
    }

    @Override
    public List<String> execute(List<Restaurant> availRest, CuisineSorter cuisineIdentifier, CostBracketIdentifier bracketIdentifier) {

        List<Restaurant> result = new ArrayList<>();
        for(BaseCondition condition:baseConditions){
            condition.executeCondition(availRest,result,cuisineIdentifier,bracketIdentifier);
        }

        List<String> restaurantIds = new ArrayList<String>();
        for(Restaurant restaurant:result){
            if(!restaurantIds.contains(restaurant.getRestaurantId())){
                restaurantIds.add(restaurant.getRestaurantId());
            }
        }

        return restaurantIds.size()<=100?restaurantIds:restaurantIds.subList(0,100);
    }
}
