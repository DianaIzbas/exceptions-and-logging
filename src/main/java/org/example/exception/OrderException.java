package org.example.exception;

public class OrderException extends RuntimeException {
    private static final String MESSAGE = "Order type not specified";
    public OrderException(){
        super(MESSAGE);
    }
}
