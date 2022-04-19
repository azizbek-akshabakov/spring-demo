package kz.company.demo.service;

import kz.company.demo.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAllStudents();
    Student saveStudent(Student student);
    Student findOneById(Long id);
    void deleteOneById(Long id);

}
