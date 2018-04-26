package com.ships.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
import com.ships.repositories.OrderInfoRepository;
import com.ships.repositories.ShipCompanyRepository;
import com.ships.repositories.ShipRepository;

@Service
public class OrderInfoService {
	@Autowired
	OrderInfoRepository orderInfoRepository;
	
	public ArrayList<OrderInfo>findAll(){
		return (ArrayList<OrderInfo>) orderInfoRepository.findAll();
	}
}
