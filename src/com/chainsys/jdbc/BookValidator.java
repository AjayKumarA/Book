package com.chainsys.jdbc;

public class BookValidator {
    public void validateBook(String name, int price) throws Exception{
    	if(name == null)
    	{
    		throw new Exception("Invalid name");
    	}
    	if(price <= 0){
    		throw new Exception("Invalid price");
    	}
    }
}
