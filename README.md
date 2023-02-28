# Solution : Kindly Read Me!!!

The Recommendation system is desined to be modular to provide ***maximum code reusability*** , **decoupling of imp features** and **qucik turn around time in case of changes**. Though you might find some bugs here and there this being not a very polished solution as I tested with some of the test cases i could write up. 

# Components

 - Pool of Conditions made from filters
 - Pool of filters
 - Criteria set , consisting of checks from pool of check 


## Pool Of Condition

Every  condition is implemented as a standone condition. Thus all modular condition are kept under one package (hence Pool of condition) and implement a common interface. Creating a pool of condition has two distinct advantages

 - **Code Reusability**
 - **Mix-N-Match**
 
 The attributes/parameters of these condition

  are configurable and thus each condition in this pool just holds the logical part of it, logic around threshold.  The threashold of that logic is completely configurable.

## Criteria Set

A Criteria set is set of checks, in this case the 9 conditions that were provided. This is created with a ***pattern similar to chain of responsibility*.**

This de-couples the Criteria set from the recommendation engine and we can even have more criteria set at a time that be used as per the classification of the user.

## Pool of filters

Each filtering criteria is created as a filter, ***using filter design pattern.*** 


