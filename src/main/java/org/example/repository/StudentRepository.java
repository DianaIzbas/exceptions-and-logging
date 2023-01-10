package org.example.repository;

import org.example.model.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentRepository {
    private Map<Long, Student> studentMap;

    public StudentRepository() {
        this.studentMap = new HashMap<>();
    }

    public void add(Student student){
        studentMap.put(student.getCnp(), student);
    }

    public List<Student> getAll(){
        List<Student> studentList = new ArrayList<>();
        for (Map.Entry<Long, Student> item : studentMap.entrySet()){
            studentList.add(item.getValue());
        }
        return studentList;
    }

    public void delete(Long cnp){
        studentMap.remove(cnp);
    }
}
