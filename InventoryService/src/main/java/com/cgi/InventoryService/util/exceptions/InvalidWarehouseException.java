package com.cgi.InventoryService.util.exceptions;

public class InvalidWarehouseException extends RuntimeException{
    public InvalidWarehouseException(String msg){
        super(msg);
    }
}
