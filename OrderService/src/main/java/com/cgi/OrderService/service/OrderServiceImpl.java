package com.cgi.OrderService.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgi.OrderService.exception.OrderNotFoundException;
import com.cgi.OrderService.model.Order;
import com.cgi.OrderService.repository.OrderRepository;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderRepository orderrepo;
	
	@Override
	public Order addOrder(Order order) throws OrderNotFoundException {
		Optional<Order> optorder = orderrepo.findById(order.getOrder_number());
		
		if(optorder.isEmpty()) {
			order.setOrderStatus("PENDING");
			orderrepo.save(order);
		}
		else
			throw new OrderNotFoundException();
		
		return order;

		
	}
	

	@Override
	public Order getOrderbyId(String orderNumber) throws OrderNotFoundException  {
		Optional<Order> obj = orderrepo.findById(orderNumber);
		
		if(obj.isEmpty()) {
			throw new OrderNotFoundException();
		}
		
		else {
			return obj.get();
		}
		
	}

	@Override
	public List<Order> getAllOrders() throws OrderNotFoundException{
		
		return orderrepo.findAll();
		
	}

	@Override
	public Order deleteOrder(String orderNumber) throws OrderNotFoundException {
		Optional<Order> obj = orderrepo.findById(orderNumber);
		
		if(obj.isEmpty()) {
			throw new OrderNotFoundException();
		}
		else {
			orderrepo.deleteById(orderNumber);
		}
		return obj.get();
		
	}

	@Override
	public Order updateOrderStatus(Order orderobj) throws OrderNotFoundException {
		
		Optional<Order> obj = orderrepo.findById(orderobj.getOrder_number());
		if(obj.isEmpty()) {
			throw new OrderNotFoundException();
		}
		else
			orderobj.setReception_date();
			orderobj.setOrderStatus("COMPLETED");
			orderrepo.save(orderobj);
		return orderobj;

}
	

}
