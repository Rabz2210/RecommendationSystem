package org.app.sorter;

import org.junit.Test;

import org.app.models.Cuisine;
import org.app.models.CuisineTracking;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;


public class CuisineSorterImplTest{

    @Test
    public void testGetUsersPrefferedCuisine() {
        CuisineTracking[] cuisines = {
                new CuisineTracking(Cuisine.SouthIndian, 10),
                new CuisineTracking(Cuisine.NorthIndian, 5),
                new CuisineTracking(Cuisine.Chinese, 15)
        };

        CuisineTracking cuisineTracking = new CuisineTracking(Cuisine.Chinese, 15);


        CuisineSorterImpl cuisineTrackingTest = new CuisineSorterImpl(Arrays.asList(cuisines));
        List<Cuisine>expected = cuisineTrackingTest.getPrimaryPrefferedCuisine();
        assertEquals(expected.size(), 1);
        assertEquals(expected.get(0), cuisineTracking.getType());
    }

    @Test
    public void testNoPrimaryPrefferedCuisine(){
        CuisineTracking[] cuisines = {
                new CuisineTracking(Cuisine.SouthIndian, 15),
                new CuisineTracking(Cuisine.NorthIndian, 5),
                new CuisineTracking(Cuisine.Chinese, 15)
        };

        List<Cuisine>expected = Arrays.asList(Cuisine.SouthIndian,Cuisine.Chinese);
        CuisineSorterImpl cuisineTrackingTest = new CuisineSorterImpl(Arrays.asList(cuisines));
        List<Cuisine> res = cuisineTrackingTest.getPrimaryPrefferedCuisine();
        assertNull(res);
    }

    @Test
    public void testSingleSecondaryPrefferedCuisine(){
        CuisineTracking[] cuisines = {
                new CuisineTracking(Cuisine.SouthIndian, 10),
                new CuisineTracking(Cuisine.Chinese, 15)
        };

        CuisineTracking cuisineTracking = new CuisineTracking(Cuisine.SouthIndian, 10);

        CuisineSorterImpl cuisineTrackingTest = new CuisineSorterImpl(Arrays.asList(cuisines));
        List<Cuisine>expected = cuisineTrackingTest.getSecondaryPrefferedCuisines();
        assertEquals(expected.size(), 1);
        assertEquals(expected.get(0), cuisineTracking.getType());

    }

    @Test
    public void testMultipleSecondaryPrefferedCuisine(){
        CuisineTracking[] cuisines = {
                new CuisineTracking(Cuisine.SouthIndian, 10),
                new CuisineTracking(Cuisine.NorthIndian, 5),
                new CuisineTracking(Cuisine.Chinese, 15)
        };
        List<Cuisine> expected = Arrays.asList(new Cuisine[]{Cuisine.SouthIndian,Cuisine.NorthIndian});

        CuisineSorterImpl cuisineTrackingTest = new CuisineSorterImpl(Arrays.asList(cuisines));
        List<Cuisine>res = cuisineTrackingTest.getSecondaryPrefferedCuisines();
        assertEquals(res.size(), 2);
        assertThat(res,is(expected));
    }

    @Test
    public void testNoPrimaryMultipleSecondaryPrefferedCuisine(){
        CuisineTracking[] cuisines = {
                new CuisineTracking(Cuisine.SouthIndian, 10),
                new CuisineTracking(Cuisine.NorthIndian, 10),
        };

        List<Cuisine> expected = Arrays.asList(new Cuisine[]{Cuisine.SouthIndian,Cuisine.NorthIndian});

        CuisineSorterImpl cuisineTrackingTest = new CuisineSorterImpl(Arrays.asList(cuisines));
        List<Cuisine>res = cuisineTrackingTest.getSecondaryPrefferedCuisines();
        assertEquals(res.size(), 2);
        assertThat(res,is(expected));
    }

    @Test
    public void testGetAllCuisines(){
        CuisineTracking[] cuisines = {
                new CuisineTracking(Cuisine.SouthIndian, 10),
                new CuisineTracking(Cuisine.NorthIndian, 5),
                new CuisineTracking(Cuisine.Chinese, 15)
        };
        List<Cuisine> expected = Arrays.asList(new Cuisine[]{Cuisine.SouthIndian,Cuisine.NorthIndian,Cuisine.Chinese});
        CuisineSorterImpl test = new CuisineSorterImpl(Arrays.asList(cuisines));
        List<Cuisine> res = test.getAllCuisines();
        assertEquals(3,res.size());
        assertThat(expected,is(res));
    }
}