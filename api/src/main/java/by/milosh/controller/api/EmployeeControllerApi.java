package by.milosh.controller.api;

import by.milosh.entity.EmployeeCreateDto;
import by.milosh.entity.EmployeeDto;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

public interface EmployeeControllerApi {

    @ApiOperation(value = "Create Employee.")
    @ApiResponses(value = {
        @ApiResponse(code = 201, message = "Employee was created successfully.")
    })
    EmployeeDto createEmployee(EmployeeCreateDto dto);
}
