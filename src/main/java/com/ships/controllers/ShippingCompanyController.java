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
import com.ships.model.ShippingCompany;
import com.ships.services.ShipService;
import com.ships.services.ShippingCompanyService;

@Controller
public class ShippingCompanyController {
	@Autowired
	 ShippingCompanyService shippingCompanyService;
	
	

	@RequestMapping(value = "/showShippingCompanies", method=RequestMethod.GET)
	public String getShippingCompanies(Model model) {
		
		ArrayList<ShippingCompany> shipingCompanies = shippingCompanyService.findAll();
		model.addAttribute("shippingCompanies", shipingCompanies);
		return "showShippingCompanies";		
	}
	
	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.GET)
	public String addShipGET(@ModelAttribute("addCompany") ShippingCompany p, HttpServletRequest h) {
		
		return "addShippingCompany";
	}
	
	@RequestMapping(value = "/addShippingCompany", method=RequestMethod.POST)
	public String addShippingCompany(@Valid @ModelAttribute("addCompany") ShippingCompany p, BindingResult result, HttpServletRequest h, Model model) {
		
		if(result.hasErrors()) {
			return "addShippingCompany";
		}else {
			shippingCompanyService.save(p);
			
			ArrayList<ShippingCompany> shipingCompanies = shippingCompanyService.findAll();
			model.addAttribute("shipingCompanies",shipingCompanies);
			return "showShippingCompanies";
		}
		
	}

}