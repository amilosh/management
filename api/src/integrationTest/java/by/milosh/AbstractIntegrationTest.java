package by.milosh;

import by.milosh.repository.EmployeeRepo;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;

import static by.milosh.ManagementApplication.PROFILE_TEST;

@AutoConfigureWebTestClient
@ActiveProfiles({PROFILE_TEST})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ContextConfiguration(initializers = EmbeddedPostgresInitializer.class)
public abstract class AbstractIntegrationTest {

    @LocalServerPort
    protected int port;

    @Value("${server.servlet.context-path}")
    protected String contextPath;

    protected String basePath;

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    protected TestRestTemplate template;

    @Autowired
    public WebTestClient webTestClient;

    @BeforeAll
    @Transactional
    protected void beforeAll() {
        employeeRepo.deleteAll();
    }

    @BeforeEach
    public void setUp() {
        this.basePath = "http://localhost:" + port;
    }

    @AfterAll
    @Transactional
    protected void afterAll() {
        employeeRepo.deleteAll();
    }
}
