package org.app.sorter;

import org.app.models.Cuisine;
import org.app.models.CuisineTracking;

import java.util.*;

public class CuisineSorterImpl implements CuisineSorter{

    List<CuisineTracking> cuisineTrackings;

    public CuisineSorterImpl (List<CuisineTracking> cuisineTrackings){
        this.cuisineTrackings = cuisineTrackings;
        Collections.sort(this.cuisineTrackings,(s1,s2) -> s2.getNoOfOrders()-s1.getNoOfOrders());
    }

    @Override
    public List<Cuisine> getPrimaryPrefferedCuisine() {
        List<Cuisine> preferredCuisines = new ArrayList<>();
        if(cuisineTrackings.size()==1 || (cuisineTrackings.get(0).getNoOfOrders()>cuisineTrackings.get(1).getNoOfOrders())){
            preferredCuisines.add(cuisineTrackings.get(0).getType());
            return preferredCuisines;
        }
            return null;
    }
    @Override
    public List<Cuisine> getSecondaryPrefferedCuisines(){
        List<Cuisine> preferredCuisines = new ArrayList<>();
        if(cuisineTrackings.size()==1 || cuisineTrackings.size()==0){
            preferredCuisines =  null;
        }else if(cuisineTrackings.size()==2 && cuisineTrackings.get(0).getNoOfOrders()>cuisineTrackings.get(1).getNoOfOrders()){
            preferredCuisines.add(cuisineTrackings.get(1).getType());

        }
        else if (cuisineTrackings.size()==2 && cuisineTrackings.get(0).getNoOfOrders()==cuisineTrackings.get(1).getNoOfOrders()){
            preferredCuisines.add(cuisineTrackings.get(0).getType());
            preferredCuisines.add(cuisineTrackings.get(1).getType());
        }
        else{
            preferredCuisines.add(cuisineTrackings.get(1).getType());
            preferredCuisines.add(cuisineTrackings.get(2).getType());

        }
        return preferredCuisines;
    }


    @Override
    public List<Cuisine> getAllCuisines(){
        List<Cuisine> res = new ArrayList<Cuisine>(Arrays.asList(Cuisine.values()));
        return res;
    }

}
