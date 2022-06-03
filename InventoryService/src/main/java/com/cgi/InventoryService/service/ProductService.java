package com.cgi.InventoryService.service;

import com.cgi.InventoryService.model.Product;
import com.cgi.InventoryService.util.exceptions.InvalidQuantityException;
import com.cgi.InventoryService.util.exceptions.InvalidWarehouseException;
import com.cgi.InventoryService.util.exceptions.ProductDoesNotExistException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {
    public Product addProduct(Product product) throws InvalidQuantityException, InvalidWarehouseException;
    public List<Product> getAllProducts();
    public Product getProduct(String productId) throws ProductDoesNotExistException;
    public void deleteProduct(String productId) throws ProductDoesNotExistException;
//    public Product decreaseProductQty(String productId, int qty) throws ProductDoesNotExistException;
}
