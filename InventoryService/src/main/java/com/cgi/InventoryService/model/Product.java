package com.cgi.InventoryService.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
public class Product {

    @Id
    private String productSku;
    private String imgUrl;
    private String productName;
    private List<Warehouse> warehouseList;


    public Product(){}

    public Product(String productSku, String imgUrl, String productName, List<Warehouse> warehouseList) {
        this.productSku = productSku;
        this.imgUrl = imgUrl;
        this.productName = productName;
        this.warehouseList = warehouseList;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productSku='" + productSku + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", productName='" + productName + '\'' +
                ", warehouseList=" + warehouseList +
                '}';
    }

    public String getProductSku() {
        return productSku;
    }

    public void setProductSku(String productSku) {
        this.productSku = productSku;
    }

    public List<Warehouse> getWarehouseList() {
        return warehouseList;
    }

    public void setWarehouseList(List<Warehouse> warehouseList) {
        this.warehouseList = warehouseList;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
