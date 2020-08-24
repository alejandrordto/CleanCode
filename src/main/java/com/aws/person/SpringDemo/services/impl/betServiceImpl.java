package com.aws.person.SpringDemo.services.impl;

import java.util.List;
import java.util.Optional;

import com.aws.person.SpringDemo.model.bet;
import com.aws.person.SpringDemo.model.game;
import com.aws.person.SpringDemo.model.results;
import com.aws.person.SpringDemo.model.roulette;
import com.aws.person.SpringDemo.services.BetServices;
import com.aws.person.SpringDemo.services.GameService;
import com.aws.person.SpringDemo.services.serviceExecption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.RouletteRepository;

@Service
public class BetServiceImpl implements BetServices {
    private static final String NOTFOUND = "Roulette not found";
    @Autowired
    RouletteRepository rouletteRepository;
    @Autowired  
    GameService gameService;

    @Override
    public void openBet(String betId) throws serviceExecption {
        roulette roulette;
        Optional<roulette> optionRulet = rouletteRepository.findById(betId);
        if (optionRulet.isPresent()) {
            roulette = optionRulet.get();
            if (!roulette.getStatus()) {
                roulette.setStatus(true);
                roulette.getGames().add(new game(roulette.getRouletteId(), roulette.getGames().size()));
                rouletteRepository.save(roulette);
            } else {
                throw new serviceExecption("La ruleta " + betId + " ya se encuentra abierta");
            }
        } else {            throw new serviceExecption(NOTFOUND);
        }
    }

    @Override
    public results closebet(String betId) throws serviceExecption {
        Optional<roulette> optionRulet = rouletteRepository.findById(betId);
        if (optionRulet.isPresent()) {
            roulette roulette = optionRulet.get();
            if (roulette.getStatus()) {
                roulette.setStatus(false);
                roulette.getGames().get(roulette.getGames().size() - 1).setNumberWinner(gameService.spinRoullete());
                rouletteRepository.save(roulette);
                return (gameService.payBets(roulette.getGames().get(roulette.getGames().size() - 1)));
            } else {
                throw new serviceExecption("La ruleta " + betId + " ya se encuentra cerrada");
            }
        } else {
            throw new serviceExecption(NOTFOUND);
        }
    }

    @Override
    public void createBet(String id, bet bet) throws serviceExecption {
        Optional<roulette> opcionalRuleta = rouletteRepository.findById(id);
		if(opcionalRuleta.isPresent()) {
			roulette roulette = opcionalRuleta.get();
			if(roulette.getStatus()) {
				List<bet> bets = roulette.getGames().get(roulette.getGames().size()-1).getBets();	
				bets.add(bet);	
				rouletteRepository.save(roulette);
			}else {
				throw new serviceExecption("La ruleta numero "+id+" ya se encuentra cerrada para apuestas");
			}
		}else {
			throw new serviceExecption(NOTFOUND);
		}

    }

}