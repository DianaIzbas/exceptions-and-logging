package org.example.exception;

public class StudentNotFoundException extends RuntimeException {
    private static final String MESSAGE = "Student does not exist.";
    public StudentNotFoundException(){
        super(MESSAGE);
    }
}
