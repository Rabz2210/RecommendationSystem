package org.app.condition;

import org.app.filter.AndCriteria;
import org.app.models.Restaurant;
import org.app.sorter.CostBracketIdentifier;
import org.app.sorter.CuisineSorter;

import java.util.ArrayList;
import java.util.List;

//All restaurants of secondary cuisine, primary cost bracket with rating >= 4.5

public class ConditionFour extends BaseCondition{

    float rating;
    public ConditionFour(float rating){
        this.rating = rating;
    }

    @Override
    public void executeCondition(List<Restaurant> availableRestaurants, List<Restaurant> res, CuisineSorter cuisineIdentifier, CostBracketIdentifier bracketIdentifier) {
        //setting secondary cusine condition
        cuisineCriteria.setCuisines(cuisineIdentifier.getSecondaryPrefferedCuisines());

        //setting primary cost bracket
        costBracketCriteria.setCostBracket(bracketIdentifier.getPrimaryCostBracket());

        //setting rating
        ratingCriteria.setRating(this.rating);

        AndCriteria a1 = new AndCriteria(cuisineCriteria,costBracketCriteria);
        AndCriteria a2 = new AndCriteria(a1,ratingCriteria);

        List<Restaurant> result = new ArrayList<>();
        result = a2.meetCriteria(availableRestaurants);
        addToResult(res,result);
    }
}
