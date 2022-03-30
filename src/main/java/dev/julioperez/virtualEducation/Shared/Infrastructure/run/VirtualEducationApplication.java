package dev.julioperez.virtualEducation.Shared.Infrastructure.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"dev"})
@EnableJpaRepositories("dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository")
@EntityScan("dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository")
public class VirtualEducationApplication {

	public static void main(String[] args) {
		SpringApplication.run(VirtualEducationApplication.class, args);
	}

}
