package org.app.sorter;

import org.app.models.Cuisine;

import java.util.List;

public interface CuisineSorter {
    public List<Cuisine> getPrimaryPrefferedCuisine();

    public List<Cuisine> getSecondaryPrefferedCuisines();

    public List<Cuisine> getAllCuisines();
}
