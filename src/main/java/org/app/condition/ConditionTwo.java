package org.app.condition;

import org.app.filter.AndCriteria;
import org.app.models.Cuisine;
import org.app.models.Restaurant;
import org.app.sorter.CostBracketIdentifier;
import org.app.sorter.CuisineSorter;

import java.util.List;

//All restaurants of Primary cuisine, primary cost bracket with rating >= 4

public class ConditionTwo extends BaseCondition{
    float rating;

    public ConditionTwo(float rating){
        super();
        this.rating = rating;
    }
    @Override
    public void executeCondition(List<Restaurant> availableRestaurants,List<Restaurant> res, CuisineSorter cuisineIdentifier, CostBracketIdentifier bracketIdentifier) {

        //setting primary cusine and primary cost bracket
        cuisineCriteria.setCuisines(cuisineIdentifier.getPrimaryPrefferedCuisine());
        costBracketCriteria.setCostBracket(bracketIdentifier.getPrimaryCostBracket());

        //setting rating
        ratingCriteria.setRating(rating);


        AndCriteria a1 = new AndCriteria(cuisineCriteria,costBracketCriteria);
        AndCriteria a2 = new AndCriteria(a1,ratingCriteria);

        List<Restaurant> result = a2.meetCriteria(availableRestaurants);
        addToResult(res,result);
    }
}
