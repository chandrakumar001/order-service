package com.demo.order.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.demo.order.model.Order;
import com.google.gson.Gson;

@Component
public class RabbitMQSender {
	private String exchange;
	private String routingkey;	
	private AmqpTemplate amqpTemplate;
	
	@Autowired(required = true)
	public RabbitMQSender( AmqpTemplate amqpTemplate,@Value("${demoone.rabbitmq.routingkey}") String routingkey ,@Value("${demoone.rabbitmq.exchange}") String exchange){
		this.amqpTemplate=amqpTemplate;
		this.routingkey=routingkey;
		this.exchange=exchange;
	}
	
	
	public void send(Order company) {
		Gson gson=new  Gson();
		String s=gson.toJson(company);
		amqpTemplate.convertAndSend(exchange, routingkey, s);
		System.out.println("RabbitMQSender--->"+"routingkey"+routingkey+"exchange"+exchange+"Send msg = " + s);
	}
}
