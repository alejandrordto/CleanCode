package com.aws.person.SpringDemo.services.impl;

import java.util.HashMap;

import com.aws.person.SpringDemo.model.roulette;
import com.aws.person.SpringDemo.services.ruleteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import repository.RouletteRepository;

@Service
public class ruleteServiceImpl implements ruleteService {

    @Autowired
    RouletteRepository ruletRepository;

    @Override
    public long createRoulette() {
        roulette roulette = new roulette(ruletRepository.count() + 1);
        ruletRepository.save(roulette);
        return roulette.getRouletteId();
    }

    @Override
    public HashMap<Long, String> getAllRouletes() {
        HashMap<Long, String> states = new HashMap<>();
        Iterable<roulette> roulettes = ruletRepository.findAll();
        for (roulette roulette : roulettes) {
            if (roulette.getStatus()) {
                states.put(roulette.getRouletteId(), "Abierta");
            } else {
                states.put(roulette.getRouletteId(), "Cerrada");
            }
        }
        return states;
    }

}