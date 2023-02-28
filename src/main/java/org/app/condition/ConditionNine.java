package org.app.condition;

import org.app.filter.AndCriteria;
import org.app.models.Cuisine;
import org.app.models.Restaurant;
import org.app.sorter.CostBracketIdentifier;
import org.app.sorter.CuisineSorter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//All restaurants of any cuisine, any cost bracket

public class ConditionNine extends BaseCondition{
    @Override
    public void executeCondition(List<Restaurant> availableRestaurants, List<Restaurant> res, CuisineSorter cuisineIdentifier, CostBracketIdentifier bracketIdentifier) {

        //Setting all type of cuisines and all cost bracket as the criteria
            cuisineCriteria.setCuisines(cuisineIdentifier.getAllCuisines());
            costBracketCriteria.setCostBracket(bracketIdentifier.getAllCostBrackets());

            AndCriteria a1 = new AndCriteria(cuisineCriteria,costBracketCriteria);
            a1.meetCriteria(availableRestaurants);
    }
}
