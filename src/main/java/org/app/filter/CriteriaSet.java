package org.app.filter;

import org.app.models.Restaurant;
import org.app.sorter.CostBracketIdentifier;
import org.app.sorter.CuisineSorter;

import java.util.List;

public interface CriteriaSet {
    public List<String> execute(List<Restaurant> availRest, CuisineSorter cuisineIdentifier, CostBracketIdentifier bracketIdentifier);
}
