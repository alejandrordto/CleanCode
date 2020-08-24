package com.aws.person.SpringDemo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aws.person.SpringDemo.model.bet;
import com.aws.person.SpringDemo.services.BetServices;
import com.aws.person.SpringDemo.services.serviceExecption;

@RestController
@RequestMapping("/bets")
public class BetController {

    @Autowired
    BetServices betservice;
    @PatchMapping("/{rulet}/open")
	public ResponseEntity<String> openBet(@PathVariable String rulet) {
		try {
			betservice.openBet(rulet);
			return new ResponseEntity<>("Abierto", HttpStatus.OK);
		} catch (serviceExecption e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PatchMapping("/{rulet}/cerrar")
	public ResponseEntity<?> closeBet(@PathVariable String rulet) {
		try {
			return new ResponseEntity<>(betservice.closebet(rulet), HttpStatus.OK);
		} catch (serviceExecption e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		}

	}

	@PostMapping("/{rulet}")
	public ResponseEntity<String> crearbet(@PathVariable String rulet, @RequestBody bet bet) {
		if (bet.getNumberBet() < 0 || bet.getNumberBet() > 36) {
			return new ResponseEntity<>(
					"El numero apostado no es correcto para el juego de la ruleta, sobrepasa 36 o es negativo",
					HttpStatus.BAD_REQUEST);
		}
		try {
			betservice.createBet(rulet, bet);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (serviceExecption e) {
			return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		}

	}
}