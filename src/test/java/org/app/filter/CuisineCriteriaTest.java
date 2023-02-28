package org.app.filter;

import org.app.models.Cuisine;
import org.app.models.Restaurant;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;

public class CuisineCriteriaTest {

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
    public void testCuisineCriteria(){
        CuisineCriteria criteria = new CuisineCriteria();
        criteria.setCuisines(Arrays.asList(new Cuisine[]{Cuisine.Chinese}));
        List<Restaurant> rs = criteria.meetCriteria(restaurantList);
        List<String> expected = new ArrayList<>(Arrays.asList(new String[]{"A1","A6","A7",}));
        List<String> resultId = new ArrayList<>();
        for(Restaurant each:rs){
            resultId.add(each.getRestaurantId());
        }
        assertEquals(3,rs.size());
        assertThat(expected,is(resultId));
    }

    @Test
    public void testMultipleCuisines(){
        CuisineCriteria criteria = new CuisineCriteria();
        criteria.setCuisines(Arrays.asList(new Cuisine[]{Cuisine.Chinese,Cuisine.NorthIndian}));
        List<Restaurant> rs = criteria.meetCriteria(restaurantList);
        List<String> resultId = new ArrayList<>();
        for(Restaurant each:rs){
            resultId.add(each.getRestaurantId());
        }
        List<String> expected = new ArrayList<>(Arrays.asList(new String[]{"A1","A3","A4","A6","A7"}));
        assertEquals(5,rs.size());
        assertThat(expected,is(resultId));
    }
    

}