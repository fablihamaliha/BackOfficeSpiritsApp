package com.cgi.OrderService.model;

import java.time.LocalDateTime;
import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Order {
	
	@Id
	String order_number;
	double gross_weight;
	String truck_number;
	LocalDateTime creation_date;
	String driver;
	String receivedBy;
	String receptionSig;
	String orderStatus;
	int warehouse_id;
	LocalDateTime reception_date;
	List<Boxes> list_box;

	
	
	public Order() {}

	public Order(String order_number, double gross_weight, String truck_number, LocalDateTime creation_date, String driver, String receivedBy, String receptionSig, String orderStatus, int warehouse_id, LocalDateTime reception_date, List<Boxes> list_box) {
		this.order_number = order_number;
		this.gross_weight = gross_weight;
		this.truck_number = truck_number;
		this.creation_date = creation_date;
		this.driver = driver;
		this.receivedBy = receivedBy;
		this.receptionSig = receptionSig;
		this.orderStatus = orderStatus;
		this.warehouse_id = warehouse_id;
		this.reception_date = reception_date;
		this.list_box = list_box;
	}

	@Override
	public String toString() {
		return "Order{" +
				"order_number='" + order_number + '\'' +
				", gross_weight=" + gross_weight +
				", truck_number='" + truck_number + '\'' +
				", creation_date=" + creation_date +
				", driver='" + driver + '\'' +
				", receivedBy='" + receivedBy + '\'' +
				", receptionSig='" + receptionSig + '\'' +
				", orderStatus='" + orderStatus + '\'' +
				", warehouse_id=" + warehouse_id +
				", reception_date=" + reception_date +
				", list_box=" + list_box +
				'}';
	}

	public String getOrder_number() {
		return order_number;
	}

	public void setOrder_number(String order_number) {
		this.order_number = order_number;
	}

	public double getGross_weight() {
		return gross_weight;
	}

	public void setGross_weight(double gross_weight) {
		this.gross_weight = gross_weight;
	}

	public String getTruck_number() {
		return truck_number;
	}

	public void setTruck_number(String truck_number) {
		this.truck_number = truck_number;
	}

	public LocalDateTime getCreation_date() {
		return creation_date;
	}

	public void setCreation_date() {
		this.creation_date = LocalDateTime.now();
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getReceivedBy() {
		return receivedBy;
	}

	public void setReceivedBy(String receivedBy) {
		this.receivedBy = receivedBy;
	}

	public String getReceptionSig() {
		return receptionSig;
	}

	public void setReceptionSig(String receptionSig) {
		this.receptionSig = receptionSig;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public int getWarehouse_id() {
		return warehouse_id;
	}

	public void setWarehouse_id(int warehouse_id) {
		this.warehouse_id = warehouse_id;
	}

	public LocalDateTime getReception_date() {
		return reception_date;
	}

	public void setReception_date() {
		this.reception_date = LocalDateTime.now();
	}

	public List<Boxes> getList_box() {
		return list_box;
	}

	public void setList_box(List<Boxes> list_box) {
		this.list_box = list_box;
	}
}