package org.example.comparator;

import org.example.model.Student;

import java.util.Comparator;

public class CompareByBirthDate implements Comparator<Student> {

    @Override
    public int compare(Student o1, Student o2) {
        return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
    }
}
