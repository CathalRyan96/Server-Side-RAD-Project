package com.ships.services;

import org.springframework.stereotype.Service;

import com.ships.model.Ship;

@Service
public class ShipService {
	public Ship saveStudent(Ship newShip) {
		return shipRepository.findAll(newShip);
	}
}

