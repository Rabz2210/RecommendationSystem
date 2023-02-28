package org.app.condition;

import org.app.filter.AndCriteria;
import org.app.models.Cuisine;
import org.app.models.Restaurant;
import org.app.sorter.CostBracketIdentifier;
import org.app.sorter.CuisineSorter;

import java.util.List;
import java.util.Objects;


//Featured restaurants of primary cuisine and primary cost bracket.
// If none, then all featured restaurants of primary cuisine, secondary cost and secondary cuisine, primary cost

public class ConditionOne extends BaseCondition{

    public ConditionOne(){
        super();
    }

    @Override
    public void executeCondition(List<Restaurant> availableRestaurants,List<Restaurant> res, CuisineSorter cuisineIdentifier, CostBracketIdentifier bracketIdentifier) {

        //setting featured Restaurant, primary cuisine and primary cost bracket
        List<Restaurant> c1 = ConditionOneFiltering(availableRestaurants,cuisineIdentifier.getPrimaryPrefferedCuisine(),bracketIdentifier.getPrimaryCostBracket());
        addToResult(res,c1);

        if(Objects.isNull(c1) || c1.size()==0){

            //setting primary cuisine and secondary cost bracket
            c1 =  ConditionOneFiltering(availableRestaurants,cuisineIdentifier.getPrimaryPrefferedCuisine(),bracketIdentifier.getSeondaryPrefferedBracket());
            addToResult(res,c1);

            //setting secondary cuisine and primary cost bracket
            List<Restaurant> c2 = ConditionOneFiltering(availableRestaurants,cuisineIdentifier.getSecondaryPrefferedCuisines(),bracketIdentifier.getPrimaryCostBracket());
            addToResult(res,c2);
        }
    }

    public List<Restaurant> ConditionOneFiltering(List<Restaurant> availableRestaurants, List<Cuisine> cuisines, List<Integer> costBrackets){
        costBracketCriteria.setCostBracket(costBrackets);
        cuisineCriteria.setCuisines(cuisines);
        AndCriteria a1 = new AndCriteria(cuisineCriteria,costBracketCriteria);
        AndCriteria a2 = new AndCriteria(a1,featuredCriteria);
        List<Restaurant> recommendationList = a2.meetCriteria(availableRestaurants);
        return recommendationList;
    }

}
