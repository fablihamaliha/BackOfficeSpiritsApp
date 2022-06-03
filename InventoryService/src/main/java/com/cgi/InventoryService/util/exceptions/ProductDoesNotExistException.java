package com.cgi.InventoryService.util.exceptions;

public class ProductDoesNotExistException extends  RuntimeException{
    public ProductDoesNotExistException(String msg){
        super(msg);
    }
}
