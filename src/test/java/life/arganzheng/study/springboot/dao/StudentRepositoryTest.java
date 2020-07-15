package life.arganzheng.study.springboot.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import life.arganzheng.study.springboot.model.Student;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository StudentRepository;

    @Test
    void testFindAll() {
        // when
        List<Student> students = StudentRepository.findAll();
        // then
        assertTrue(students.size() == 2);
    }
    
    @Test
    void testFindById() {
        // when
        Optional<Student> student = StudentRepository.findById(10001L);
        // then
        assertTrue(student.isPresent());
    }

}
