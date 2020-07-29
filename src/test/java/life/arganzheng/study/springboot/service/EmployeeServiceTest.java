package life.arganzheng.study.springboot.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import life.arganzheng.study.springboot.exception.RecordNotFoundException;
import life.arganzheng.study.springboot.model.Employee;

@SpringBootTest
class EmployeeServiceTest {

	@Autowired
	EmployeeService employeeService;

	@Test
	void testGetAllEmployees() {
		List<Employee> employees = employeeService.getAllEmployees();
		// System.out.println(employees);
		// then
		assertTrue(employees.size() == 3);
	}

	@Test
	void testGetEmployeeById_Found() throws RecordNotFoundException {
		Employee employee = employeeService.getEmployeeById(1L);
		assertNotNull(employee);
		assertEquals(employee.getId(), 1L);
	}

	@Test
	void testGetEmployeeById_NotFound() throws RecordNotFoundException {
		assertThrows(RecordNotFoundException.class, () -> {
			employeeService.getEmployeeById(4L);
		});

	}

}
