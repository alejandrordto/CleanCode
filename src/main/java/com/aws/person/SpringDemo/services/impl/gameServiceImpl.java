package com.aws.person.SpringDemo.services.impl;

import com.aws.person.SpringDemo.model.bet;
import com.aws.person.SpringDemo.model.game;
import com.aws.person.SpringDemo.model.results;
import com.aws.person.SpringDemo.services.gameService;
import org.springframework.stereotype.Service;

@Service
public class gameServiceImpl implements gameService {

    @Override
    public int spinRoullete() {
        double winner=Math.random()*37;
        return (int)winner;
    }

    @Override
    public results payBets(game game) {
        results resultGame = 
        new results(game.getRouletteId(),game.getGameNumber(),game.getBets(),game.getNumberWinner());
			
		for (bet bet : game.getBets() ){
			long stocks = 0;
			if(resultGame.getClientsResults().containsKey(bet.getClient())) {
				if(bet.getNumberBet()==resultGame.getNumberWinner()) {					
					stocks = resultGame.getClientsResults().get(bet.getClient());
					stocks+= bet.getAmmount()*36;
					resultGame.getClientsResults().replace(bet.getClient(), stocks);
				}
			}else {				
				if(bet.getNumberBet()==resultGame.getNumberWinner()) {
					stocks=bet.getAmmount()* (long)36;
				}
				resultGame.getClientsResults().put(bet.getClient(),stocks);
			}
					
		}
		return resultGame;
    }

}