package com.demo.order.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.order.config.RabbitMQConsumer;
import com.demo.order.model.Order;
import com.demo.order.service.OrderService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@Api(value="Order-service", description="Operations pertaining for order service")
@RestController
public class OrderController {

	private static Logger LOGGER=LoggerFactory.getLogger(OrderController.class);
	
	private OrderService orderService;
	RabbitMQConsumer rabbitMQConsumer;

	@Autowired
	OrderController(OrderService orderService,RabbitMQConsumer rabbitMQConsumer){
		this.orderService=orderService;
		this.rabbitMQConsumer=rabbitMQConsumer;
	}

	@ApiOperation(value = "View a list of available orders")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})

	@GetMapping("/orders")
	public ResponseEntity<?>  getOrders() {

		//String globalProperties = global.getUrl();

		//LOGGER.info("calling getCustomers() method...-------"+globalProperties);
		if(LOGGER.isDebugEnabled()) {
			LOGGER.debug("calling getCustomers() method..."+orderService.toString());
		}

		return new ResponseEntity<>(orderService.getOrder(), HttpStatus.OK);
	}


	@ApiOperation(value = "available products", response = Order.class)
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Successfully retrieved list"),
			@ApiResponse(code = 401, message = "You are not authorized to view the resource"),
			@ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
			@ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
	})

	@GetMapping("/orders/{id}")
	public ResponseEntity<?>  getOrder(@RequestHeader String jwt, @PathVariable("id") int id) {

		LOGGER.info("calling getCustomer() method..."+id);



		Order cs=orderService.getOrder(id);
		if(null==cs) {
			new ResponseEntity<>(new Order(), HttpStatus.OK);
		}
		return new ResponseEntity<>(cs, HttpStatus.OK);
	}

	@PostMapping("/orders")
	public ResponseEntity<?>  createOrder(@RequestBody Order order) {
		LOGGER.info("calling getCustomer() method..."+order);

		Order customerResp = orderService.getOrder(order);
		return new ResponseEntity<>(customerResp, HttpStatus.CREATED);
	}
	@PostMapping("/orderbypassing")
	public ResponseEntity<?>  createOrderPassingArgs(@RequestParam("orderId") int orderId,@RequestParam("custom_Id") int custom_Id,
			@RequestParam("desc") String desc,@RequestParam("orderName") String orderName
			) {
		Order order=new Order();
		order.setCustom_Id(custom_Id);
		order.setDesc(desc);
		order.setOrderId(orderId);
		order.setOrderName(orderName);
		LOGGER.info("calling getCustomer() method..."+order);

		 orderService.send(order);
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
//	@GetMapping("/orderbypassingRecived")
//	public String returnData() {
//		return rabbitMQConsumer.recievedMessage("");
//	}
	
}
