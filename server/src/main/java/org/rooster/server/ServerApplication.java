package org.rooster.server;

import org.rooster.server.auth.AuthenticationService;
import org.rooster.server.auth.RegisterRequestBody;
import org.rooster.server.job.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

import static org.rooster.server.user.Role.*;

@SpringBootApplication
public class ServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServerApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService authenticationService,
            JobService jobService
    ) {
        return args -> {
            var user = RegisterRequestBody.builder()
                    .displayName("User 1")
                    .email("user@example.com")
                    .password("password")
                    .role(USER)
                    .company("LOLC")
                    .phone("94573494934")
                    .build();
            System.out.println("User token: " + authenticationService.register(user).getAccessToken());

            var admin = RegisterRequestBody.builder()
                    .displayName("Admin 1")
                    .email("admin@example.com")
                    .password("password")
                    .role(ADMIN)
                    .company("LOLC")
                    .phone("94573494934")
                    .build();
            System.out.println("Admin token: " + authenticationService.register(admin).getAccessToken());

            var employee = RegisterRequestBody.builder()
                    .displayName("Employee 1")
                    .email("employee@example.com")
                    .password("password")
                    .role(EMPLOYEE)
                    .company("LOLC")
                    .phone("94573494934")
                    .build();
            System.out.println("Employee token: " + authenticationService.register(employee).getAccessToken());

            var job1 = Job.builder()
                    .logo("https://rooster.jobs/static/mobile-logo.svg")
                    .title("Software Engineering Intern")
                    .companyName("Rooster")
                    .classification("Information & Communication Technology")
                    .subClassification("Engineering - Software")
                    .type(JobType.CONTRACT)
                    .location("Colombo, Srilanka")
                    .salary(Salary.builder()
                            .min(70000)
                            .max(80000)
                            .currency("LKR")
                            .paidEvery(PaidEvery.MONTH)
                            .build())
                    .postedDate(new Date())
                    .companyUrl("rooster.org")
                    .build();
            jobService.save(job1);

            for (int i = 0; i < 40; i++) {
                var job2 = Job.builder()
                        .logo("https://rooster-content-s3.s3.amazonaws.com/companyLogos/logo_1610022110673_ig_logoTESTFINAL_UPLOAD_ARALIYA_IG.jpg")
                        .title(i + "Accounts Executive / Bookkeeper in a Export Business")
                        .companyName("D&R Exports (Pty) Ltd")
                        .classification("Accounting")
                        .subClassification("Accounts Officers/Clerks")
                        .type(JobType.FULL_TIME)
                        .location("Wellampitiya, Sri Lanka")
                        .salary(Salary.builder()
                                .min(40000)
                                .max(50000)
                                .currency("LKR")
                                .paidEvery(PaidEvery.MONTH)
                                .build())
                        .postedDate(new Date())
                        .companyUrl("example.com")
                        .build();
                jobService.save(job2);
            }
        };
    }
}
