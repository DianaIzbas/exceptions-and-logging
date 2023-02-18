package org.example.exception;

public class CnpException extends Exception {
    public static final String MESSAGE = "CNP shouldn't be null";

    public CnpException(){
        super(MESSAGE);
    }
}
