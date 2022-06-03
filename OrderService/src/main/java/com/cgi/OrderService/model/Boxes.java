package com.cgi.OrderService.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Boxes {
	
	@Id
//	int box_id;
	String sku;
	int qty_of_boxes;
	String product_name;
	String box_type;
	int qty_per_box;
	String comment;
	String imgUrl;

	
	public Boxes() {}

	public Boxes(String sku, int qty_of_boxes, String product_name, String box_type, int qty_per_box, String comment, String imgUrl) {
		this.sku = sku;
		this.qty_of_boxes = qty_of_boxes;
		this.product_name = product_name;
		this.box_type = box_type;
		this.qty_per_box = qty_per_box;
		this.comment = comment;
		this.imgUrl = imgUrl;
	}

	@Override
	public String toString() {
		return "Boxes{" +
				"sku='" + sku + '\'' +
				", qty_of_boxes=" + qty_of_boxes +
				", product_name='" + product_name + '\'' +
				", box_type='" + box_type + '\'' +
				", qty_per_box=" + qty_per_box +
				", comment='" + comment + '\'' +
				", imgUrl='" + imgUrl + '\'' +
				'}';
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getQty_of_boxes() {
		return qty_of_boxes;
	}

	public void setQty_of_boxes(int qty_of_boxes) {
		this.qty_of_boxes = qty_of_boxes;
	}

	public String getProduct_name() {
		return product_name;
	}

	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}

	public String getBox_type() {
		return box_type;
	}

	public void setBox_type(String box_type) {
		this.box_type = box_type;
	}

	public int getQty_per_box() {
		return qty_per_box;
	}

	public void setQty_per_box(int qty_per_box) {
		this.qty_per_box = qty_per_box;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
}
