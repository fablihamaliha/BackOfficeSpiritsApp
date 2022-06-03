package com.cgi.InventoryService.util.exceptions;

public class InvalidQuantityException extends  RuntimeException{
    public InvalidQuantityException (String msg){
        super(msg);
    }
}
