package com.demo.order.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.order.config.RabbitMQSender;
import com.demo.order.model.Order;
import com.demo.order.utill.OrderData;


@Service
public class OrderServiceImpl implements OrderService {

	
	private RabbitMQSender rabbitMQSender;
	private  List<Order> orders=null;
	
	@Autowired
	public OrderServiceImpl(RabbitMQSender rabbitMQSender){
		this.orders = OrderData.getOrders();
		this.rabbitMQSender=rabbitMQSender;
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
	
	public void send(Order order) {
		rabbitMQSender.send(order);
		System.out.println("OrderServiceImpl Send msg = " + order);
	}
	
}
