package com.ships.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.services.OrderInfoService;
import com.ships.services.ShipService;
import com.ships.services.ShippingCompanyService;

@Controller
public class OrderInfoController {
	@Autowired
	private OrderInfoService orderInfoService;
	
	@Autowired
	ShippingCompanyService shippingCompanyService;
	
	@Autowired
	ShipService shipService;
	
	

	@RequestMapping(value = "/showOrders", method=RequestMethod.GET)
	public String getOrderInfo(Model model) {
		
		ArrayList<OrderInfo> orderInfos = orderInfoService.findAll();
		model.addAttribute("orderInfos", orderInfos);
		return "showOrders";		
	}

}