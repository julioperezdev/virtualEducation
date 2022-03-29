package dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.app.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"dev.julioperez.virtualEducation.Backoffice"})
public class SpringDependenciesConfiguration {


}
