package org.app.condition;

import org.app.filter.AndCriteria;
import org.app.models.Restaurant;
import org.app.sorter.CostBracketIdentifier;
import org.app.sorter.CuisineSorter;

import java.util.List;


//All restaurants of secondary cuisine, primary cost bracket with rating < 4.5

public class ConditionEight extends BaseCondition{

    float rating;

    public ConditionEight(float rating){
        this.rating = rating;
    }
    @Override
    public void executeCondition(List<Restaurant> availableRestaurants, List<Restaurant> res, CuisineSorter cuisineIdentifier, CostBracketIdentifier bracketIdentifier) {
        //Setting Seconday cuisine and primary cost bracket
        cuisineCriteria.setCuisines(cuisineIdentifier.getSecondaryPrefferedCuisines());
        costBracketCriteria.setCostBracket(bracketIdentifier.getPrimaryCostBracket());

        //Setting rating criteria
        reverseRatingCriteria.setRating(this.rating);

        AndCriteria a1 = new AndCriteria(cuisineCriteria,costBracketCriteria);
        AndCriteria a2 = new AndCriteria(a1,reverseRatingCriteria);

        List<Restaurant> restaurants = a2.meetCriteria(availableRestaurants);
        addToResult(res,restaurants);
    }
}
