package org.example.model;

import org.example.exception.DateOfBirthException;
import org.example.exception.FirstNameException;
import org.example.exception.GenderException;
import org.example.exception.LastNameException;
import org.example.utils.Gender;

import java.time.Instant;
import java.util.Date;

public class Student {
    private Long cnp;
    private String firstName;
    private String lastName;
    private Integer dateOfBirth;
    private Gender gender;


    public Long getCnp() {
        return cnp;
    }

    public void setCnp(Long cnp) {
        this.cnp = cnp;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (firstName.isEmpty()) {
            throw new FirstNameException();
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (lastName.isEmpty()) {
            throw new LastNameException();
        }
        this.lastName = lastName;
    }

    public Integer getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Integer dateOfBirth) {
        Integer currentYear = new Date().getYear();
        if (dateOfBirth < 1900 || dateOfBirth > currentYear - 18) {
            throw new DateOfBirthException();
        }
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (!gender.equalsIgnoreCase("M") || !gender.equalsIgnoreCase("F")){
            throw new GenderException();
        }
        this.gender = Gender.valueOf(gender.toUpperCase());
    }

    @Override
    public String toString() {
        return "Student{" +
                "cnp=" + cnp +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender=" + gender +
                '}';
    }
}
