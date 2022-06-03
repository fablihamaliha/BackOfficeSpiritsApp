package com.cgi.InventoryService.controller;

import com.cgi.InventoryService.model.Product;
import com.cgi.InventoryService.service.ProductService;
import com.cgi.InventoryService.util.exceptions.InvalidQuantityException;
import com.cgi.InventoryService.util.exceptions.InvalidWarehouseException;
import com.cgi.InventoryService.util.exceptions.ProductDoesNotExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Repository
@RequestMapping("/api/v1")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService=productService;
    }

    @PostMapping("/inventory")
    public ResponseEntity<?> addProduct(@RequestBody Product product){

        try{

            Product newProduct =productService.addProduct(product);
            return new ResponseEntity<Product>(newProduct, HttpStatus.CREATED);

        }catch(InvalidWarehouseException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }catch(InvalidQuantityException e){
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/inventory")
    public ResponseEntity<?> getAllProducts(){
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(productList,HttpStatus.OK);
    }



    @GetMapping("/inventory/{productSku}")
    public ResponseEntity<?> getProduct(@PathVariable("productSku") String productSku){

        try{
            Product product = productService.getProduct(productSku);
            return new ResponseEntity<Product>(product,HttpStatus.OK);

        }catch(ProductDoesNotExistException e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/inventory/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable("productId") String productId){
        try{
            productService.deleteProduct(productId);
            return new ResponseEntity<String>("Product Deleted",HttpStatus.OK);

        }catch(ProductDoesNotExistException e){
            return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
        }




    }






}
