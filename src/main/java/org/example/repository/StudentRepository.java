package org.example.repository;

import org.example.comparator.CompareByBirthDate;
import org.example.comparator.CompareByLastName;
import org.example.exception.AgeException;
import org.example.exception.CnpException;
import org.example.exception.OrderException;
import org.example.exception.StudentNotFoundException;
import org.example.model.Student;
import org.example.utils.OrderBy;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class StudentRepository {
    Logger logger = Logger.getLogger(StudentRepository.class.getName());
    private final Map<Long, Student> studentMap;

    public StudentRepository() {
        this.studentMap = new HashMap<>();
        logger.log(Level.INFO, "Student Repository initialized.");
    }

    public void add(Student student) {
        logger.log(Level.INFO, "Add Student initializing");
        studentMap.put(student.getCnp(), student);
        logger.log(Level.INFO, "Student with following CNP " + student.getCnp() + " was added");
    }

    public Student getByCnp(Long cnp) {
        return studentMap.get(cnp);
    }

    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        for (Map.Entry<Long, Student> item : studentMap.entrySet()) {
            studentList.add(item.getValue());
        }
        return studentList;
    }

    public void delete(Long cnp) throws CnpException {
        if (cnp == null) {
            logger.log(Level.SEVERE, "CNP should not be null");
            throw new CnpException();
        }
        if (!studentMap.containsKey(cnp)) {
            throw new StudentNotFoundException();
        }
        studentMap.remove(cnp);
    }

    public List<Student> list(OrderBy orderBy) {
        if (orderBy == null) {
            throw new OrderException();
        }
        List<Student> studentList = getAll();
        if (orderBy.equals(OrderBy.LAST_NAME)) {
            studentList.sort(new CompareByLastName());
        } else {
            studentList.sort(new CompareByBirthDate());
        }
        return studentList;
    }

    public List<Student> retrieveAllByAge(Integer age) {
        if (age < 0) {
            throw new AgeException();
        }
        List<Student> studentList = new ArrayList<>();
        Integer currentYear = 2023;
        for (Student currentStudent : getAll()) {
            Integer studentAge = currentYear - currentStudent.getDateOfBirth();
            if (studentAge.equals(age)) {
                studentList.add(currentStudent);
            }
        }
        return studentList;
    }
}
