package by.milosh.service;

import by.milosh.entity.Employee;
import by.milosh.entity.EmployeeCreateDto;
import by.milosh.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepo employeeRepo;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @Override
    public Employee create(EmployeeCreateDto dto) {
        Employee employee = new Employee();
        employee.setName(dto.getName());
        return employeeRepo.save(employee);
    }
}
