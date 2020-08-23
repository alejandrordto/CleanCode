package com.aws.person.SpringDemo.services;

import java.util.HashMap;

import org.springframework.data.redis.hash.HashMapper;

public interface ruleteService {
    long createRoulette();
    HashMap<Long,String> getAllRouletes() ;
}