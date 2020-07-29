package life.arganzheng.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import life.arganzheng.study.springboot.dao.EmployeeRepository;
import life.arganzheng.study.springboot.exception.RecordNotFoundException;
import life.arganzheng.study.springboot.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository repository;

	public List<Employee> getAllEmployees() {
		return repository.findAll();
	}

	public Employee getEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Employee> employee = repository.findById(id);

		if (employee.isPresent()) {
			return employee.get();
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}

	public Employee createOrUpdateEmployee(Employee entity) throws RecordNotFoundException {
		Optional<Employee> employee = repository.findById(entity.getId());

		if (employee.isPresent()) {
			Employee newEntity = employee.get();
			newEntity.setEmail(entity.getEmail());
			newEntity.setFirstName(entity.getFirstName());
			newEntity.setLastName(entity.getLastName());

			newEntity = repository.save(newEntity);

			return newEntity;
		} else {
			entity = repository.save(entity);

			return entity;
		}
	}

	public void deleteEmployeeById(Long id) throws RecordNotFoundException {
		Optional<Employee> employee = repository.findById(id);

		if (employee.isPresent()) {
			repository.deleteById(id);
		} else {
			throw new RecordNotFoundException("No employee record exist for given id");
		}
	}
}