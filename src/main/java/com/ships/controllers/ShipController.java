package com.ships.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.Ship;
import com.ships.services.ShipService;

@Controller
public class ShipController {
	@Autowired
	private ShipService s;
	
	

	@RequestMapping(value = "/showShips", method=RequestMethod.GET)
	public String getShip(Model model) {
		
		ArrayList<Ship> ships = s.findAll();
		model.addAttribute("ships", ships);
		return "showShips";		
	}

}