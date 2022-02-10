package by.milosh.mapper;

import by.milosh.entity.Employee;
import by.milosh.entity.EmployeeCreateDto;
import by.milosh.entity.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface EmployeeMapper {

    Employee toEntity(EmployeeCreateDto dto);

    EmployeeDto toDto(Employee employee);
}
