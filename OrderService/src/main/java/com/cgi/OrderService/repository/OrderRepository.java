package com.cgi.OrderService.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.cgi.OrderService.model.Order;

@Repository
public interface OrderRepository extends MongoRepository<Order, String>{

}
