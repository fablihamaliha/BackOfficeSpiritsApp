package com.cgi.UserService.exceptions;

public class WarehouseAlreadyExistsException extends RuntimeException{

    public WarehouseAlreadyExistsException(String msg){
        super(msg);
    }
}
