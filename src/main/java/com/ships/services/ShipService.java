package com.ships.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.repositories.ShipRepository;

@Service
public class ShipService {
	@Autowired
	ShipRepository s;
	
	//Takes info out of ship table in database
	public ArrayList<Ship>findAll(){
		return (ArrayList<Ship>) s.findAll();
	}
	
	public Ship saveShip(Ship ship) {
		return s.save(ship);
	}
}

