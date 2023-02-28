package org.app.recommend;
import org.app.filter.CriteriaSet;
import org.app.filter.DefaultCriteriaSet;
import org.app.models.*;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
public class RecommendationEngineTest {

    Restaurant[] listOfRestaurants;

    User user;

    CriteriaSet criteriaSet;

    @Before
    public void prepareData(){
        Restaurant[] ls = {
                new Restaurant("A1", Cuisine.Chinese,5,4f,Boolean.TRUE,new Date(2023,02,11,12,00)),
                new Restaurant("A2", Cuisine.SouthIndian,2,3,Boolean.FALSE,new Date(2023,02,22,12,00)),
                new Restaurant("A3", Cuisine.NorthIndian,2,4.8f,Boolean.TRUE,new Date(2023,02,23,12,00)),
                new Restaurant("A4", Cuisine.NorthIndian,4,5.5f,Boolean.FALSE,new Date(2023,02,24,12,00)),
                new Restaurant("A5", Cuisine.SouthIndian,3,3,Boolean.TRUE,new Date(2023,02,25,12,00)),
                new Restaurant("A6", Cuisine.Chinese,1,4.8f,Boolean.FALSE,new Date(2023,02,25,12,00)),
                new Restaurant("A7", Cuisine.Chinese,5,3,Boolean.TRUE,new Date(2023,02,22,12,00)),
                new Restaurant("A8", Cuisine.SouthIndian,3,3,Boolean.FALSE,new Date(2023,02,11,12,00)),
                new Restaurant("A9", Cuisine.Chinese,5,4f,Boolean.TRUE,new Date(2023,02,11,12,00)),
                new Restaurant("A10", Cuisine.SouthIndian,3,4.8f,Boolean.FALSE,new Date(2023,02,22,12,00)),
                new Restaurant("A11", Cuisine.NorthIndian,5,4.8f,Boolean.TRUE,new Date(2023,02,23,12,00)),
                new Restaurant("A12", Cuisine.NorthIndian,4,4,Boolean.FALSE,new Date(2023,02,24,12,00)),
                new Restaurant("A13", Cuisine.SouthIndian,3,3,Boolean.TRUE,new Date(2023,02,25,12,00)),
                new Restaurant("A14", Cuisine.Chinese,4,4.8f,Boolean.FALSE,new Date(2023,02,25,12,00)),
                new Restaurant("A15", Cuisine.Chinese,5,3,Boolean.TRUE,new Date(2023,02,22,12,00)),
                new Restaurant("A16", Cuisine.SouthIndian,3,4.8f,Boolean.FALSE,new Date(2023,02,11,12,00))
        };
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

        listOfRestaurants = ls;

        user = new User(cuisines,costBrackets);

        criteriaSet = new DefaultCriteriaSet();

    }

    @Test
    public void testGetRestaurantRecommendations() {
        RecommendationEngine engine = new RecommendationEngine(criteriaSet);
        String[] res = engine.getRestaurantRecommendations(user,listOfRestaurants);
        assertNotNull(res);
    }
}