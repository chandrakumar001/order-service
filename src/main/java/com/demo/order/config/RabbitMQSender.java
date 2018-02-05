package com.demo.order.config;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.demo.order.model.Order;

@Component
public class RabbitMQSender {
	private String exchange;
	private String routingkey;	
	private AmqpTemplate amqpTemplate;
	
	@Autowired
	public RabbitMQSender( AmqpTemplate amqpTemplate,@Value("${demoone.rabbitmq.routingkey}") String routingkey ,@Value("${demoone.rabbitmq.exchange}") String exchange){
		this.amqpTemplate=amqpTemplate;
		this.routingkey=routingkey;
		this.exchange=exchange;
	}
	
	
	public void send(Order company) {
		amqpTemplate.convertAndSend(exchange, routingkey, company);
		System.out.println("RabbitMQSender--->"+"routingkey"+routingkey+"exchange"+exchange+"Send msg = " + company);
	}
}
