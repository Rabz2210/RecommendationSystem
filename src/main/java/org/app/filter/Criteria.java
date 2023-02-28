package org.app.filter;

import org.app.models.Restaurant;

import java.util.List;

public interface Criteria {
   public List<Restaurant> meetCriteria(List<Restaurant> Restaurants);
}
