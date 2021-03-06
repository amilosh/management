package by.milosh.controller;

import by.milosh.controller.api.EmployeeControllerApi;
import by.milosh.entity.Employee;
import by.milosh.entity.EmployeeCreateDto;
import by.milosh.entity.EmployeeDto;
import by.milosh.mapper.EmployeeMapper;
import by.milosh.service.EmployeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/employee")
public class EmployeeController implements EmployeeControllerApi {

    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper;

    public EmployeeController(EmployeeService employeeService, EmployeeMapper employeeMapper) {
        this.employeeService = employeeService;
        this.employeeMapper = employeeMapper;
    }

    @PostMapping(consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public EmployeeDto createEmployee(@RequestBody EmployeeCreateDto dto) {
        log.debug("Starting to create Employee");
        Employee employee = employeeService.create(dto);
        log.info("Employee was created");
        return employeeMapper.toDto(employee);
    }
}
