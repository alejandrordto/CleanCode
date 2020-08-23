package com.aws.person.SpringDemo.services;

import com.aws.person.SpringDemo.model.results;

public interface betServices {
    void openBet(String betId) throws serviceExecption;
    
    results closebet(String betId) throws serviceExecption;
}