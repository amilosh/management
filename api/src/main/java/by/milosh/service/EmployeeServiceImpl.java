package by.milosh.service;

import by.milosh.entity.Employee;
import by.milosh.entity.EmployeeCreateDto;
import by.milosh.mapper.EmployeeMapper;
import by.milosh.repository.EmployeeRepo;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepo employeeRepo;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepo employeeRepo, EmployeeMapper employeeMapper) {
        this.employeeRepo = employeeRepo;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public Employee create(EmployeeCreateDto dto) {
        Employee employee = employeeMapper.toEntity(dto);
        return employeeRepo.save(employee);
    }
}
