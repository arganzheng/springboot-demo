package life.arganzheng.study.springboot.dao;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import life.arganzheng.study.springboot.model.Employee;

@SpringBootTest
class EmployeeRepositoryTest {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Test
	void testFindAll() {
		// when
		List<Employee> employees = employeeRepository.findAll();
		// System.out.println(employees);
		// then
		assertTrue(employees.size() == 3);
	}

	@Test
	void testFindById() {
		// when
		Optional<Employee> employee = employeeRepository.findById(1L);
		// then
		assertTrue(employee.isPresent());
	}

}
