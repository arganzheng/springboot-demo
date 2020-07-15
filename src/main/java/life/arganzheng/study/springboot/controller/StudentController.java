package life.arganzheng.study.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import life.arganzheng.study.springboot.dao.StudentRepository;
import life.arganzheng.study.springboot.exception.StudentNotFoundException;
import life.arganzheng.study.springboot.model.Student;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> retrieveAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable long id) {
        Optional<Student> student = studentRepository.findById(id);

        if (!student.isPresent()) {
            throw new StudentNotFoundException(String.format("Student with id %s not found!", id));
        }

        return student.get();
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);

        return savedStudent;
    }

    @PutMapping("/students/{id}")
    public Student updateStudent(@RequestBody Student student, @PathVariable long id) {
        Optional<Student> studentOptional = studentRepository.findById(id);

        if (!studentOptional.isPresent()) {
            throw new StudentNotFoundException(String.format("Student with id %s not found!", id));
        }

        student.setId(id);

        studentRepository.save(student);

        return student;
    }

}
