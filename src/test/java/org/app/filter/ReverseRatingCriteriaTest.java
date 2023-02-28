package org.app.filter;

import org.app.models.Cuisine;
import org.app.models.Restaurant;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ReverseRatingCriteriaTest {

    List<Restaurant> restaurantList;

    @Before
    public void prepareData(){
        Restaurant[] ls = {
                new Restaurant("A1", Cuisine.Chinese,1,3,Boolean.TRUE,new Date(2023,02,11)),
                new Restaurant("A2", Cuisine.SouthIndian,2,3,Boolean.FALSE,new Date(2023,02,22)),
                new Restaurant("A3", Cuisine.NorthIndian,3,2,Boolean.TRUE,new Date(2023,02,23)),
                new Restaurant("A4", Cuisine.NorthIndian,4,3,Boolean.FALSE,new Date(2023,02,28,12,00)),
                new Restaurant("A5", Cuisine.SouthIndian,5,4,Boolean.TRUE,new Date(2023,02,28,12,00)),
                new Restaurant("A6", Cuisine.Chinese,1,3,Boolean.FALSE,new Date(2023,02,27,12,00)),
                new Restaurant("A7", Cuisine.Chinese,2,2,Boolean.FALSE,new Date(2023,02,27,12,00)),
                new Restaurant("A8", Cuisine.SouthIndian,3,4.5f,Boolean.FALSE,new Date(2023,02,26,12,00))
        };
        restaurantList = Arrays.asList(ls);

    }

    @Test
    public void testReverseRatingCriteria(){
        ReverseRatingCriteria criteria = new ReverseRatingCriteria();
        criteria.setRating(3f);
        List<Restaurant> rs = criteria.meetCriteria(restaurantList);
        List<String> resultId = new ArrayList<String>();
        List<String> expected = new ArrayList<>(Arrays.asList(new String[]{"A3","A7"}));
        for(Restaurant each:rs){
            resultId.add(each.getRestaurantId());
        }
        assertEquals(2,rs.size());
        assertThat(expected,is(resultId));
    }

}