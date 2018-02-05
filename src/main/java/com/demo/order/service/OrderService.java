package com.demo.order.service;

import java.util.List;

import com.demo.order.model.Order;


public interface OrderService {
	public 	List<Order> getOrder();
	public 	Order getOrder(int id);
	public 	Order getOrder(Order customer);
	public void send(Order Order);
}
