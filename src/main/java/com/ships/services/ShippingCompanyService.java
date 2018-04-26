package com.ships.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.ShipCompanyRepository;
import com.ships.repositories.ShipRepository;

@Service
public class ShippingCompanyService {
	@Autowired
	ShipCompanyRepository shipCompanyRepository;
	
	public ArrayList<ShippingCompany>findAll(){
		return (ArrayList<ShippingCompany>) shipCompanyRepository.findAll();
	}
	
	public ShippingCompany save(ShippingCompany company) {
		return shipCompanyRepository.save(company);
	}
}
