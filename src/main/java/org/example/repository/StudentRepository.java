package org.example.repository;

import org.example.comparator.CompareByBirthDate;
import org.example.comparator.CompareByLastName;
import org.example.model.Student;
import org.example.utils.OrderBy;

import java.util.*;

public class StudentRepository {
    private Map<Long, Student> studentMap;

    public StudentRepository() {
        this.studentMap = new HashMap<>();
    }

    public void add(Student student) {
        studentMap.put(student.getCnp(), student);
    }

    public Student getByCnp(Long cnp){
        return studentMap.get(cnp);
    }

    public List<Student> getAll() {
        List<Student> studentList = new ArrayList<>();
        for (Map.Entry<Long, Student> item : studentMap.entrySet()) {
            studentList.add(item.getValue());
        }
        return studentList;
    }

    public void delete(Long cnp) {
        studentMap.remove(cnp);
    }

    public List<Student> list(OrderBy orderBy) {
        List<Student> studentList = getAll();
        if (orderBy.equals(OrderBy.LAST_NAME)){
            studentList.sort(new CompareByLastName());
        }
        else {
            studentList.sort(new CompareByBirthDate());
        }
        return studentList;

    }
}
