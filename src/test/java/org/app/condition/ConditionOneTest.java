package org.app.condition;

import org.app.models.CostTracking;
import org.app.models.Cuisine;
import org.app.models.CuisineTracking;
import org.app.models.Restaurant;
import org.app.sorter.CostBracketIdentifier;
import org.app.sorter.CostBracketIdentifierImpl;
import org.app.sorter.CuisineSorter;
import org.app.sorter.CuisineSorterImpl;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ConditionOneTest {

    List<Restaurant> restaurantList;

    CuisineSorter cuisineSorter;

    CostBracketIdentifier costBracketIdentifier;

    @Before
    public void prepareData(){
        Restaurant[] ls = {
                new Restaurant("A1", Cuisine.Chinese,1,3,Boolean.TRUE,new Date(2023,02,11,12,00)),
                new Restaurant("A2", Cuisine.SouthIndian,2,3,Boolean.FALSE,new Date(2023,02,22,12,00)),
                new Restaurant("A3", Cuisine.NorthIndian,3,3,Boolean.TRUE,new Date(2023,02,23,12,00)),
                new Restaurant("A4", Cuisine.NorthIndian,4,3,Boolean.FALSE,new Date(2023,02,24,12,00)),
                new Restaurant("A5", Cuisine.SouthIndian,5,3,Boolean.TRUE,new Date(2023,02,25,12,00)),
                new Restaurant("A6", Cuisine.Chinese,1,3,Boolean.FALSE,new Date(2023,02,25,12,00)),
                new Restaurant("A7", Cuisine.Chinese,5,3,Boolean.TRUE,new Date(2023,02,22,12,00)),
                new Restaurant("A8", Cuisine.SouthIndian,3,3,Boolean.FALSE,new Date(2023,02,11,12,00))
        };
        restaurantList = Arrays.asList(ls);
        CuisineTracking[] cuisines = {
                new CuisineTracking(Cuisine.SouthIndian, 10),
                new CuisineTracking(Cuisine.NorthIndian, 5),
                new CuisineTracking(Cuisine.Chinese, 15)
        };

        CostTracking[] costBrackets = {
                new CostTracking(1, 10),
                new CostTracking(2, 5),
                new CostTracking(3, 15),
                new CostTracking(4, 15),
                new CostTracking(5, 20)
        };

        cuisineSorter = new CuisineSorterImpl(Arrays.asList(cuisines));
        costBracketIdentifier = new CostBracketIdentifierImpl(Arrays.asList(costBrackets));
    }

    @Test
    public void testexecuteConditionOne() {
        List<Restaurant> result = new ArrayList<>();
        ConditionOne conditionOne = new ConditionOne();
        conditionOne.executeCondition(restaurantList,result,cuisineSorter,costBracketIdentifier);
        assertEquals(result.size(),1);
        assertEquals(result.get(0).getRestaurantId(),"A7");
    }
}