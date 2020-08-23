package com.aws.person.SpringDemo.model;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("bet")
public class bet {
    private int client;
    private int ammount;
    private int numberBet;

    public int getClient() {
        return client;
    }

    public void setClient(int client) {
        this.client = client;
    }

    public int getAmmount() {
        return ammount;
    }

    public void setAmmount(int ammount) {
        this.ammount = ammount;
    }

    public int getNumberBet() {
        return numberBet;
    }

    public void setNumberBet(int numberBet) {
        this.numberBet = numberBet;
    }
    
}