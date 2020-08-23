package com.aws.person.SpringDemo.model;

import java.util.HashMap;
import java.util.List;

public class results {
    private long roulette;
	private int numberGame;
	private List<bet> bet ;
	private int numberWinner;
    private HashMap<Integer,Long> clientsResults;

    public results(long roulette, int numberGame, List<com.aws.person.SpringDemo.model.bet> bet, int numberWinner) {
        this.roulette = roulette;
        this.numberGame = numberGame;
        this.bet = bet;
        this.numberWinner = numberWinner;
        this.clientsResults= new HashMap<>();
    }

    public long getRoulette() {
        return roulette;
    }

    public void setRoulette(long roulette) {
        this.roulette = roulette;
    }

    public int getNumberGame() {
        return numberGame;
    }

    public void setNumberGame(int numberGame) {
        this.numberGame = numberGame;
    }

    public List<bet> getBet() {
        return bet;
    }

    public void setBet(List<bet> bet) {
        this.bet = bet;
    }

    public int getNumberWinner() {
        return numberWinner;
    }

    public void setNumberWinner(int numberWinner) {
        this.numberWinner = numberWinner;
    }

    public HashMap<Integer, Long> getClientsResults() {
        return clientsResults;
    }

    public void setClientsResults(HashMap<Integer, Long> clientsResults) {
        this.clientsResults = clientsResults;
    }
    
}