package org.app.condition;

import org.app.filter.*;
import org.app.models.Cuisine;
import org.app.models.Restaurant;
import org.app.sorter.CostBracketIdentifier;
import org.app.sorter.CuisineSorter;

import java.util.List;
import java.util.Objects;

public abstract class BaseCondition {
    protected FeaturedCriteria featuredCriteria;
    protected CuisineCriteria cuisineCriteria;

    protected CostBracketCriteria costBracketCriteria;
    protected RatingCriteria ratingCriteria;
    protected ReverseRatingCriteria reverseRatingCriteria;

    protected OnBoardingCriteria onBoardingCriteria;


    public BaseCondition(){
        featuredCriteria = new FeaturedCriteria();
        cuisineCriteria = new CuisineCriteria();
        costBracketCriteria = new CostBracketCriteria();
        ratingCriteria = new RatingCriteria();
        reverseRatingCriteria = new ReverseRatingCriteria();
        onBoardingCriteria = new OnBoardingCriteria();
    }

    public abstract void executeCondition(List<Restaurant> availableRestaurants,List<Restaurant> res, CuisineSorter cuisineIdentifier, CostBracketIdentifier bracketIdentifier);

    public void addToResult(List<Restaurant> res, List<Restaurant> obj){
        if(Objects.isNull(obj))return;
        res.addAll(obj);
    }
}
