package com.ships.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;
import com.ships.model.ShippingCompany;
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
	
	@RequestMapping(value = "/addOrder", method=RequestMethod.GET)
	public String addOrderGET(@ModelAttribute("addOrders") OrderInfo o, HttpServletRequest h, Model m) {
		ArrayList<Ship> ships = shipService.findAll();
		Map<Long,String> orderShip = new HashMap<Long,String>();
		
		for(Ship s : ships) {
			
			orderShip.put((long) s.getSid(), s.getName() + ", " + s.getCost().toString());
		}
		m.addAttribute("orderShip", orderShip);
		
		return "addOrder";
	}
	
	
	@RequestMapping(value = "/addOrder", method=RequestMethod.POST)
	public String addOrderPOST(@ModelAttribute("addOrders") OrderInfo o, BindingResult r, HttpServletRequest h, Model m) {
		
		if(r.hasErrors()) {
			return "addOrder";
			
		}else {
			shipService.saveShip(o.getShip());
			orderInfoService.addOrder(o);
			
			ArrayList<OrderInfo> orders = orderInfoService.findAll();
			m.addAttribute("orders", orders);
			
			
			return "showOrders";
		}
		
		
		
	}

	
	
	

}