package com.ships.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping(value = "/addShip", method=RequestMethod.GET)
	public String addShipGET(@ModelAttribute("addShips") Ship p, HttpServletRequest h) {
		
		return "addShip";
	}
	
	@RequestMapping(value = "/addShip", method=RequestMethod.POST)
	public String addShip(@Valid @ModelAttribute("addShips") Ship ship, BindingResult result, HttpServletRequest h, Model model) {
		
		if(result.hasErrors()) {
			return "addShip";
		}else {
			s.saveShip(ship);
			
			ArrayList<Ship> ships = s.findAll();
			model.addAttribute("ships",ships);
			return "showShips";
		}
		
	}


}