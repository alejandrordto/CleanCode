package com.aws.person.SpringDemo.services;

import com.aws.person.SpringDemo.model.bet;
import com.aws.person.SpringDemo.model.results;

public interface BetServices {
    void openBet(String betId) throws serviceExecption;
    
    results closebet(String betId) throws serviceExecption;
    void createBet(String id,bet bet) throws serviceExecption;
}