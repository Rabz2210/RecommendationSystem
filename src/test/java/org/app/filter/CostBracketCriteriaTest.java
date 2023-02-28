package org.app.filter;

import org.app.models.Cuisine;
import org.app.models.Restaurant;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CostBracketCriteriaTest {

    List<Restaurant> restaurantList;



    @Before
    public void prepareData(){
        Restaurant[] ls = {
                new Restaurant("A1", Cuisine.Chinese,1,3,Boolean.TRUE,new Date(2023,02,11,12,00)),
                new Restaurant("A2", Cuisine.SouthIndian,2,3,Boolean.FALSE,new Date(2023,02,22,12,00)),
                new Restaurant("A3", Cuisine.NorthIndian,3,3,Boolean.TRUE,new Date(2023,02,23,12,00)),
                new Restaurant("A4", Cuisine.NorthIndian,4,3,Boolean.FALSE,new Date(2023,02,24,12,00)),
                new Restaurant("A5", Cuisine.SouthIndian,5,3,Boolean.TRUE,new Date(2023,02,25,12,00)),
                new Restaurant("A6", Cuisine.Chinese,1,3,Boolean.FALSE,new Date(2023,02,25,12,00)),
                new Restaurant("A7", Cuisine.Chinese,2,3,Boolean.TRUE,new Date(2023,02,22,12,00)),
                new Restaurant("A8", Cuisine.SouthIndian,3,3,Boolean.FALSE,new Date(2023,02,11,12,00))
        };
        restaurantList = Arrays.asList(ls);
    }

    @Test
    public void testCostBracketCriteria(){
        CostBracketCriteria costBracketCriteria = new CostBracketCriteria();
        costBracketCriteria.setCostBracket(Arrays.asList(new Integer[]{1}));
        List<Restaurant> res = costBracketCriteria.meetCriteria(restaurantList);
        List<String> resRestaurantId = new ArrayList<>();
        for(Restaurant restaurant:res){
            resRestaurantId.add(restaurant.getRestaurantId());
        }
        List<String> expected = Arrays.asList(new String[]{"A1","A6"});
        assertEquals(res.size(),2);
        assertThat(resRestaurantId,is(expected));
    }
}