package com.aws.person.SpringDemo.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.redis.core.RedisHash;

@RedisHash("roulette")
public class roulette {

    private long rouletteId;
    private Boolean status;
    private List<game> games;

    public roulette (long id){
        super();
        this.rouletteId=id;
        this.status=false;
        this.games= new ArrayList<>();

    }

    public long getRouletteId() {
        return rouletteId;
    }

    public void setRouletteId(long rouletteId) {
        this.rouletteId = rouletteId;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public List<game> getGames() {
        return games;
    }

    public void setGames(List<game> games) {
        this.games = games;
    }
    
    
}