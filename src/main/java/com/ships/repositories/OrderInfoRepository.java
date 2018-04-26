package com.ships.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ships.model.OrderInfo;
import com.ships.model.Ship;

@Repository
public interface OrderInfoRepository 
	extends CrudRepository<OrderInfo, Long> {
}
