package org.app;

import org.app.filter.Criteria;
import org.app.filter.CriteriaSet;
import org.app.filter.DefaultCriteriaSet;
import org.app.recommend.RecommendationEngine;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {

        System.out.println( "Restaurant Recommendation Engine" );

        //Initializing the Criteria Set
        CriteriaSet criteriaSet = new DefaultCriteriaSet();

        //Initializing the recommendationEngine
        RecommendationEngine engine = new RecommendationEngine(criteriaSet);

        //running the engine
        //String[] res = engine.getRestaurantRecommendations()

    }
}
