package by.milosh.controller;

import by.milosh.AbstractIntegrationTest;
import by.milosh.ManagementApplicationTest;
import by.milosh.entity.Employee;
import by.milosh.entity.EmployeeCreateDto;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = {ManagementApplicationTest.class})
public class EmployeeControllerTest extends AbstractIntegrationTest {

    @Test
    public void testCreateEmployee() {
        EmployeeCreateDto dto = new EmployeeCreateDto("Alex");
        String url = "/employee";
        Employee employee = this.webTestClient
            .post().uri(url)
            .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            .bodyValue(dto)
            .exchange()
            .expectStatus().isCreated()
            .expectBody(Employee.class).returnResult().getResponseBody();
        assertEquals(1, employee.getId());
        assertEquals("Alex", employee.getName());
    }
}
