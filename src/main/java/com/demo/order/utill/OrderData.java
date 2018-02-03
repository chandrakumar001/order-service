package com.demo.order.utill;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import com.demo.order.model.Order;

@RefreshScope
public class OrderData {
	
	@Value("${orderName: Hello world - Config Server is not working..pelase check}")
	private static String orderName;
	
	public static List<Order> getOrders(){
		List<Order> order=new ArrayList<Order>();
		order.add(new Order(111, "Test..",orderName,1));
		order.add(new Order(222, "Test..",orderName,1));
		order.add(new Order(333, "Test..",orderName,2));
		order.add(new Order(444, "Test..",orderName,1));
		order.add(new Order(555, "Test..",orderName,1));
		return order;
	}

}
