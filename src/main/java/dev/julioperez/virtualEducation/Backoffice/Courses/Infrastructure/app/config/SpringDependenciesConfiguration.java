package dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.app.config;

import dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper.CourseCreatorRequestResponseModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper.CourseModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.delivery.CourseCreatorEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.repository.CourseCreatorAdapterRepository;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.service.CourseCreatorService;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.service.CourseCreatorServiceImplementation;
import dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository.Dao.CourseDao;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"dev.julioperez.virtualEducation.Backoffice"})
public class SpringDependenciesConfiguration {

    private final CourseDao courseDao;

    public SpringDependenciesConfiguration(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(10000)).build();
    }

    @Bean
    public CourseModelMapper courseModelMapper(){
        return new CourseModelMapper();
    }

    @Bean
    public CourseCreatorRequestResponseModelMapper courseCreatorRequestResponseModelMapper(){
        return new CourseCreatorRequestResponseModelMapper();
    }

    @Bean
    public CourseCreatorAdapterRepository courseRepository(){
        return new CourseCreatorAdapterRepository(courseDao, courseModelMapper());
    }

    @Bean
    public CourseCreatorServiceImplementation courseCreatorServiceImplementation(){
        return new CourseCreatorServiceImplementation(courseRepository());
    }

    @Bean
    public CourseCreatorEndPoints courseController(){
        return new CourseCreatorEndPoints(courseCreatorServiceImplementation(), courseCreatorRequestResponseModelMapper());
    }
}
