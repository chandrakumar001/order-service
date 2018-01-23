package com.demo.order.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.order.model.Order;
import com.demo.order.utill.OrderData;


@Service
public class OrderServiceImpl implements OrderService {

	private  List<Order> orders=null;

	public OrderServiceImpl(){
		orders = OrderData.getOrders();
	}

	@Override
	public Order getOrder(int idNumber) {
		return orders.stream().filter(id->idNumber==id.getOrderId()).findFirst().orElse(null);
	}

	@Override
	public Order getOrder(Order Order) {
		orders.add(Order);
		return Order;
	}

	@Override
	public List<Order> getOrder() {
		return orders;
	}



}
