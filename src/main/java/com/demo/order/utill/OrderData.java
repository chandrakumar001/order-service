package com.demo.order.utill;

import java.util.ArrayList;
import java.util.List;

import com.demo.order.model.Order;

public class OrderData {
	public static List<Order> getOrders(){
		List<Order> order=new ArrayList<Order>();
		order.add(new Order(111, "Test..",1));
		order.add(new Order(222, "Test..",1));
		order.add(new Order(333, "Test..",2));
		order.add(new Order(444, "Test..",1));
		order.add(new Order(555, "Test..",1));
		return order;
	}

}
