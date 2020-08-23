package com.aws.person.SpringDemo.services;

import com.aws.person.SpringDemo.model.game;
import com.aws.person.SpringDemo.model.results;

public interface gameService {
    int spinRoullete();
    results payBets(game game);

}