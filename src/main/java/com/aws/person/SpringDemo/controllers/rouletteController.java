package com.aws.person.SpringDemo.controllers;

import java.util.HashMap;

import com.aws.person.SpringDemo.services.ruleteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/roullet")
public class rouletteController {
    @Autowired
    ruleteService ruleteService;
    @PostMapping("")
	public ResponseEntity<Long> crearRuleta() {
		return new ResponseEntity<>(ruleteService.createRoulette(), HttpStatus.CREATED);
	}

	@GetMapping("")
	public ResponseEntity<HashMap<Long, String>> getAllRouletes() {
		HashMap<Long, String> estados = ruleteService.getAllRouletes();
		if (estados.isEmpty()) {
			return new ResponseEntity<>(estados, HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>(estados, HttpStatus.OK);
		}
    }
    
}