package org.example;

import org.example.model.Student;
import org.example.repository.StudentRepository;
import org.example.utils.Gender;
import org.example.utils.OrderBy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        StudentRepository studentRepository = new StudentRepository();
        Integer n = 3;
        Scanner scanner = new Scanner(System.in);
        while (n != 0) {
            System.out.println("Birth Date: ");
            Integer dateOfBirth = scanner.nextInt();
            System.out.println("First Name: ");
            String firstName = scanner.next();
            System.out.println("Last Name: ");
            String lastName = scanner.next();
            System.out.println("CNP: ");
            Long cnp = scanner.nextLong();
            System.out.println("Gender: ");
            String gender = scanner.next();

            Student student = new Student();
            student.setFirstName(firstName);
            student.setLastName(lastName);
            student.setCnp(cnp);
            student.setGender(gender);
            student.setDateOfBirth(dateOfBirth);
            studentRepository.add(student);
            n--;
            System.out.println("-------------");
        }
        System.out.println(studentRepository.getAll());
        System.out.println(studentRepository.list(OrderBy.LAST_NAME));



    }

}