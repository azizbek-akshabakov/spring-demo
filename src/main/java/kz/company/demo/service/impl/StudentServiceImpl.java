package kz.company.demo.service.impl;

import kz.company.demo.entity.Student;
import kz.company.demo.repository.StudentRepository;
import kz.company.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public List<Student> findAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student findOneById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteOneById(Long id) {
        studentRepository.deleteById(id);
    }

}
