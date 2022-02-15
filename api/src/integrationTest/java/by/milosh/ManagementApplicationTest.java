package by.milosh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "by.milosh")
public class ManagementApplicationTest {

    public static void main(String[] args) {
        SpringApplication.run(ManagementApplicationTest.class, args);
    }
}
