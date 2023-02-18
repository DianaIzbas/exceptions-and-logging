package org.example.exception;

public class FirstNameException extends RuntimeException {
    private static final String MESSAGE = "First Name should not be empty.";

    public FirstNameException() {
        super(MESSAGE);
    }

}
