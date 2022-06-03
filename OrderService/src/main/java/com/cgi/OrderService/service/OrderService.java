package com.cgi.OrderService.service;

import java.util.List;

import com.cgi.OrderService.exception.OrderNotFoundException;
import com.cgi.OrderService.model.Order;

public interface OrderService {
	
	public Order addOrder(Order order) throws OrderNotFoundException;
	
	public Order getOrderbyId(String orderNumber) throws OrderNotFoundException;
	
	public List<Order> getAllOrders() throws OrderNotFoundException;
	
	public Order deleteOrder(String orderNumber) throws OrderNotFoundException;
	
	public Order updateOrderStatus(Order orderobj) throws OrderNotFoundException;
	
	

}
