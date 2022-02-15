package by.milosh.service;

import by.milosh.entity.Employee;
import by.milosh.entity.EmployeeCreateDto;
import by.milosh.mapper.EmployeeMapper;
import by.milosh.repository.EmployeeRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {

    @Mock
    private EmployeeRepo employeeRepo;

    @Mock
    private EmployeeMapper employeeMapper;

    @InjectMocks
    private EmployeeServiceImpl service;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void createTest() {
        EmployeeCreateDto dto = new EmployeeCreateDto("Alex");
        Employee employee = new Employee(null, "Alex");
        when(employeeMapper.toEntity(dto)).thenReturn(employee);
        Employee savedEmployee = new Employee(1, "Alex");
        when(employeeRepo.save(employee)).thenReturn(savedEmployee);
        Employee result = service.create(dto);
        assertEquals(1, result.getId());
        assertEquals("Alex", result.getName());
    }
}
