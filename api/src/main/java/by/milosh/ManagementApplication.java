package by.milosh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "by.milosh")
public class ManagementApplication {
    public static final String PROFILE_TEST = "test";

    public static void main(String[] args) {
        SpringApplication.run(ManagementApplication.class, args);
    }
}
