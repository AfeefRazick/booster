package org.rooster.server;

import org.rooster.server.auth.AuthenticationService;
import org.rooster.server.auth.RegisterRequestBody;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.rooster.server.user.Role.*;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService service
    ) {
        return args -> {
            var user = RegisterRequestBody.builder()
                    .displayName("User")
                    .username("user")
                    .password("password")
                    .role(USER)
                    .build();
            System.out.println("User token: " + service.register(user).getAccessToken());

            var admin = RegisterRequestBody.builder()
                    .displayName("Admin")
                    .username("admin")
                    .password("password")
                    .build();
            System.out.println("Admin token: " + service.register(admin).getAccessToken());

            var employee = RegisterRequestBody.builder()
                    .displayName("Employee")
                    .username("employee")
                    .password("password")
                    .role(EMPLOYEE)
                    .build();
            System.out.println("Employee token: " + service.register(employee).getAccessToken());

        };
    }
}
