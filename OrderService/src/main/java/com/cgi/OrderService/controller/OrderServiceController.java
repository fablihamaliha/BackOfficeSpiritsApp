package com.cgi.OrderService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.cgi.OrderService.exception.OrderNotFoundException;
import com.cgi.OrderService.model.Order;
import com.cgi.OrderService.service.OrderServiceImpl;

@CrossOrigin
@RestController
@RequestMapping("/OrderService")
public class OrderServiceController {
	
	@Autowired
	OrderServiceImpl orderserviceimpl;
	
	@PostMapping("/addOrder")
	public ResponseEntity<?> addOrder(@RequestBody Order order) {
		
		try {
			Order orderobj = orderserviceimpl.addOrder(order);
			return new ResponseEntity<Order>(orderobj,HttpStatus.OK);
		}
		
		catch(OrderNotFoundException e) {
			return new ResponseEntity<String>("Order not found",HttpStatus.CONFLICT);
		}
		
	}
	@GetMapping("/getAllOrder")
	public ResponseEntity<?> getAllOrders() {
		
		try {
		List<Order> list = orderserviceimpl.getAllOrders(); 
		return new ResponseEntity<List<Order>>(list, HttpStatus.OK);
		}
		
		catch (OrderNotFoundException e) {
			return new ResponseEntity<String>("Order not found",HttpStatus.NOT_FOUND);
		}
		
	}
	@GetMapping("/getOrderbyId/{orderNumber}")
	public ResponseEntity<?> getOrdersbyId(@PathVariable("orderNumber") String orderNumber) {
		
		try {
			Order order = orderserviceimpl.getOrderbyId(orderNumber);
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		}
		catch(OrderNotFoundException e) {
			return new ResponseEntity<String>("Order not found",HttpStatus.OK);
		}
		
	}
	@DeleteMapping("/deleteorder/{orderNumber}")
	public ResponseEntity<?> deleteOrder(@PathVariable("orderNumber") String orderNumber) {
		
		try {
			Order order = orderserviceimpl.deleteOrder(orderNumber);
			return new ResponseEntity<Order>(order, HttpStatus.OK);
			
		}
		
		catch(OrderNotFoundException e) {
			return new ResponseEntity<String>("Order not found",HttpStatus.NOT_FOUND);
		}
		
	}
	@PutMapping("/updateorder")
	public ResponseEntity<?> updateOrder(@RequestBody Order orderobj) {
		try {
			Order order = orderserviceimpl.updateOrderStatus(orderobj);
			return new ResponseEntity<Order>(order, HttpStatus.OK);
		}
		catch(OrderNotFoundException e) {
			return new ResponseEntity<String>("Order object not found",HttpStatus.NOT_FOUND);
		}
		
	}



	


}
