package by.milosh.service;

import by.milosh.entity.Employee;
import by.milosh.entity.EmployeeCreateDto;

public interface EmployeeService {

    Employee create(EmployeeCreateDto dto);
}
