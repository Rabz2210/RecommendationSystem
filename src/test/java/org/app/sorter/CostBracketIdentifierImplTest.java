package org.app.sorter;

import org.app.models.CostTracking;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class CostBracketIdentifierImplTest {

    @Test
    public void testgetUsersCostBracket(){
        CostTracking[] costBrackets = {
                new CostTracking(1, 10),
                new CostTracking(2, 5),
                new CostTracking(3, 15),
                new CostTracking(4, 15),
                new CostTracking(5, 20)
        };

        CostBracketIdentifierImpl costTrackingTest = new CostBracketIdentifierImpl(Arrays.asList(costBrackets));
        List<Integer> res = costTrackingTest.getPrimaryCostBracket();
        assertEquals(res.size(), 1);
        assertEquals(res.get(0).intValue(),5);

    }


    @Test
    public void testNoPrimaryBracket(){
        CostTracking[] costBrackets = {
                new CostTracking(1, 10),
                new CostTracking(2, 20),
                new CostTracking(3, 15),
                new CostTracking(4, 15),
                new CostTracking(5, 20)
        };

        CostBracketIdentifierImpl costTrackingTest = new CostBracketIdentifierImpl(Arrays.asList(costBrackets));
        List<Integer> res = costTrackingTest.getPrimaryCostBracket();
        assertNull(res);

    }

    @Test
    public void testSingleSecondaryBracket(){
        CostTracking[] costBrackets = {
                new CostTracking(1, 10),
                new CostTracking(2, 20),

        };

        CostBracketIdentifierImpl costTrackingTest = new CostBracketIdentifierImpl(Arrays.asList(costBrackets));
        List<Integer> res = costTrackingTest.getSeondaryPrefferedBracket();
        List<Integer> expected = Arrays.asList(1);
        assertEquals(res.size(), 1);
        assertThat(res,is(expected));
    }

    @Test
    public void testMultipleSecondaryBracket(){
        CostTracking[] costBrackets = {
                new CostTracking(1, 10),
                new CostTracking(2, 20),
                new CostTracking(3, 15),
                new CostTracking(4, 25),
                new CostTracking(5, 20)
        };

        CostBracketIdentifierImpl costTrackingTest = new CostBracketIdentifierImpl(Arrays.asList(costBrackets));
        List<Integer> res = costTrackingTest.getSeondaryPrefferedBracket();
        List<Integer> expected = Arrays.asList(2,5);
        assertEquals(res.size(), 2);
        assertThat(res,is(expected));
    }

    @Test
    public void testGetAllCostBrackets(){
        CostTracking[] costBrackets = {
                new CostTracking(1, 10),
                new CostTracking(2, 20),
                new CostTracking(3, 15),
                new CostTracking(4, 25),
                new CostTracking(5, 20)
        };
        CostBracketIdentifierImpl costTrackingTest = new CostBracketIdentifierImpl(Arrays.asList(costBrackets));
        List<Integer> res = costTrackingTest.getAllCostBrackets();
        List<Integer> expected = new ArrayList<>(Arrays.asList(new Integer[]{4,2,5,3,1}));
        assertEquals(5,res.size());
        assertThat(expected,is(res));
    }
}
