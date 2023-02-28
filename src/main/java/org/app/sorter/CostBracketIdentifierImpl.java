package org.app.sorter;

import org.app.models.CostTracking;
import org.app.models.Cuisine;
import org.app.models.CuisineTracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CostBracketIdentifierImpl implements CostBracketIdentifier{

    List<CostTracking> preferredBrackets;

    public CostBracketIdentifierImpl(List<CostTracking> costTrackings){
        this.preferredBrackets = costTrackings;
        Collections.sort(preferredBrackets,(s1,s2) -> s2.getNoOfOrders()-s1.getNoOfOrders());
    }
    @Override
    public List<Integer> getPrimaryCostBracket() {
        List<Integer> preferredBracket = new ArrayList<>();
        if(preferredBrackets.size()==1 || (preferredBrackets.get(0).getNoOfOrders()>preferredBrackets.get(1).getNoOfOrders())){
            preferredBracket.add(preferredBrackets.get(0).getCostBracket());
            return preferredBracket;
        }
        return null;
    }

    @Override
    public List<Integer> getSeondaryPrefferedBracket(){
        List<Integer> preferredBracket = new ArrayList<>();
        if(preferredBrackets.size()==1 || preferredBrackets.size()==0){
            preferredBracket =  null;
        }else if(preferredBrackets.size()==2 && preferredBrackets.get(0).getNoOfOrders()>preferredBrackets.get(1).getNoOfOrders()){
            preferredBracket.add(preferredBrackets.get(1).getCostBracket());

        }
        else if (preferredBrackets.size()==2 && preferredBrackets.get(0).getNoOfOrders()==preferredBrackets.get(1).getNoOfOrders()){
            preferredBracket.add(preferredBrackets.get(0).getCostBracket());
            preferredBracket.add(preferredBrackets.get(1).getCostBracket());
        }
        else{
            preferredBracket.add(preferredBrackets.get(1).getCostBracket());
            preferredBracket.add(preferredBrackets.get(2).getCostBracket());
        }
        return preferredBracket;
    }

    @Override
    public List<Integer> getAllCostBrackets(){
        List<Integer> allCostBrackets = new ArrayList<>();
        for(CostTracking tracking:preferredBrackets){
            allCostBrackets.add(tracking.getCostBracket());
        }
        return allCostBrackets;
    }
}
