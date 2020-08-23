package com.aws.person.SpringDemo.model;

import java.util.List;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("game")
public class game {
    private long rouletteId;
    private int gameNumber;
    private int numberWinner;
    private List<bet> bets;

    public game(long rouletteId, int gameNumber) {
        this.rouletteId = rouletteId;
        this.gameNumber = gameNumber;
    }

    public long getRouletteId() {
        return rouletteId;
    }

    public void setRouletteId(long rouletteId) {
        this.rouletteId = rouletteId;
    }

    public int getGameNumber() {
        return gameNumber;
    }

    public void setGameNumber(int gameNumber) {
        this.gameNumber = gameNumber;
    }

    public int getNumberWinner() {
        return numberWinner;
    }

    public void setNumberWinner(int numberWinner) {
        this.numberWinner = numberWinner;
    }

    public List<bet> getBets() {
        return bets;
    }

    public void setBets(List<bet> bets) {
        this.bets = bets;
    }
    
    
}