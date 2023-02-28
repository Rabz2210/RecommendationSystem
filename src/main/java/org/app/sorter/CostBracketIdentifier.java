package org.app.sorter;

import org.app.models.CostTracking;

import java.util.List;

public interface CostBracketIdentifier {
    public List<Integer> getPrimaryCostBracket();
    public List<Integer> getSeondaryPrefferedBracket();
    public List<Integer> getAllCostBrackets();

}
