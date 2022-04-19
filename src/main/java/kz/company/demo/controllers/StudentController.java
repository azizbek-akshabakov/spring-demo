package kz.company.demo.controllers;

import kz.company.demo.entity.Student;
import kz.company.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String listStudents(Model model) {

        model.addAttribute( "students", studentService.findAllStudents() );
        return "students";

    }

    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student) {
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/new")
    public String addStudentForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "add-student";
    }

    @GetMapping("/students/update/{id}")
    public String updateStudentForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("student", studentService.findOneById(id));
        return "update-student";
    }

    @PostMapping("/students/update/{id}")
    public String updateStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        Student existingStudent = studentService.findOneById(id);
        existingStudent.setId(id);
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student) {
        studentService.deleteOneById(id);
        return "redirect:/students";
    }

}
