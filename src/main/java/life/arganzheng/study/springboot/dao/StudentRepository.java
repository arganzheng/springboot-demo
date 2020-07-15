package life.arganzheng.study.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import life.arganzheng.study.springboot.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
