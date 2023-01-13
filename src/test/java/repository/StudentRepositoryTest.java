package repository;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.example.utils.OrderBy;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StudentRepositoryTest {
    StudentRepository studentRepository = new StudentRepository();

    @BeforeEach
    void setup(){
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();
        s1.setDateOfBirth(1999);
        s1.setCnp(65654641644L);
        s1.setGender("m");
        s1.setLastName("dhfbjdgd");
        s1.setFirstName("shbchd");

        s2.setDateOfBirth(1966);
        s2.setCnp(4136413454L);
        s2.setGender("M");
        s2.setLastName("hbfkcd");
        s2.setFirstName("jbksjf");

        s3.setDateOfBirth(1996);
        s3.setCnp(54165416L);
        s3.setGender("F");
        s3.setLastName("sdkssfhs");
        s3.setFirstName("dxvjhnvnvmk");

        studentRepository.add(s1);
        studentRepository.add(s2);
        studentRepository.add(s3);
    }

    @Test
    void shouldDeleteStudent(){
        int listSize=studentRepository.getAll().size();
        studentRepository.delete(54165416L);
        assertEquals(studentRepository.getAll().size(), listSize-1);
    }

    @Test
    void shouldAddStudent(){
//        given
        int listSize=studentRepository.getAll().size();
        Student s4 = new Student();
        s4.setFirstName("kskjehf");
        s4.setLastName("kahdnksf");
        s4.setGender("f");
        s4.setCnp(54164164165L);
        s4.setDateOfBirth(1999);
//        when
        studentRepository.add(s4);
//        then
        assertEquals(listSize+1, studentRepository.getAll().size());
        assertEquals("kahdnksf", studentRepository.getByCnp(54164164165L).getLastName());
        assertEquals("kskjehf", studentRepository.getByCnp(54164164165L).getFirstName());
    }

    @Test
     void shouldReturnListOfStudents(){
//        given
//        when
        List<Student> studentList = studentRepository.getAll();
//        then
        assertNotNull(studentList);
        assertEquals(3, studentList.size());
    }

    @Test
    void shouldOrderStudentsByName(){
//        given
        OrderBy orderBy=OrderBy.LAST_NAME;
//        when
        List<Student> studentList = studentRepository.list(orderBy);
//        then
        assertTrue(studentList.get(0).getLastName().compareTo(studentList.get(1).getLastName())<0);
    }




}
