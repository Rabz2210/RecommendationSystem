package org.app.recommend;


import org.app.filter.*;
import org.app.models.Cuisine;
import org.app.models.Restaurant;
import org.app.models.User;
import org.app.sorter.CostBracketIdentifier;
import org.app.sorter.CostBracketIdentifierImpl;
import org.app.sorter.CuisineSorter;
import org.app.sorter.CuisineSorterImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class RecommendationEngine {
    CriteriaSet criteriaSet;

    public RecommendationEngine(CriteriaSet criteriaSet){
        this.criteriaSet = criteriaSet;
    }

    public String[] getRestaurantRecommendations(User user, Restaurant[] availableRestaurants) {

        if(Objects.isNull(user) || Objects.isNull(availableRestaurants))return null;
        if(user.getCostBrackets().length==0 || user.getCuisines().length==0)return null;

        //Chaning the Array to ArrayList
     List<Restaurant> availRest = Arrays.asList(availableRestaurants);

     //Createing Cuisine Identifiers and BracketIdentifiers
     CuisineSorter cuisineIdentifier = new CuisineSorterImpl(Arrays.asList(user.getCuisines()));
     CostBracketIdentifier bracketIdentifier = new CostBracketIdentifierImpl(Arrays.asList(user.getCostBrackets()));

     //Executing configured Criteria Set
     List<String> recommendations = criteriaSet.execute(availRest,cuisineIdentifier,bracketIdentifier);

     //Return final list of recommended restaurant Ids
     return recommendations.toArray(new String[0]);

    }
}




