package dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.app.config;

import dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper.CourseCreatorRequestResponseModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper.CourseFinderResponseModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper.CourseModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.delivery.CourseCreatorEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.repository.CourseCreatorAdapterRepository;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.service.CourseCreatorServiceImplementation;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.delivery.CourseFinderEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.repository.CourseFinderAdapterRepository;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.service.CourseFinderServiceImplementation;
import dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Delivery.SpringCourseFinderController;
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
public class BackofficeSpringDependenciesConfiguration {

    private final CourseDao courseDao;

    public BackofficeSpringDependenciesConfiguration(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    /**
     * Course/Application/ModelMapper
     */

    @Bean
    public CourseModelMapper courseModelMapper(){
        return new CourseModelMapper();
    }

    @Bean
    public CourseCreatorRequestResponseModelMapper courseCreatorRequestResponseModelMapper(){
        return new CourseCreatorRequestResponseModelMapper();
    }

    @Bean
    public CourseFinderResponseModelMapper courseFinderResponseModelMapper(){
        return new CourseFinderResponseModelMapper();
    }

    /**
     * Course/Application/Creator
     */

    @Bean
    public CourseCreatorAdapterRepository courseCreatorRepository(){
        return new CourseCreatorAdapterRepository(courseDao, courseModelMapper());
    }

    @Bean
    public CourseCreatorServiceImplementation courseCreatorServiceImplementation(){
        return new CourseCreatorServiceImplementation(courseCreatorRepository());
    }

    @Bean
    public CourseCreatorEndPoints courseCreatorController(){
        return new CourseCreatorEndPoints(courseCreatorServiceImplementation(), courseCreatorRequestResponseModelMapper());
    }

    /**
     *Application/Course/Finder
     */

    @Bean
    public CourseFinderAdapterRepository courseFinderRepository(){
        return new CourseFinderAdapterRepository(courseDao, courseModelMapper());
    }

    @Bean
    CourseFinderServiceImplementation courseFinderServiceImplementation(){
        return new CourseFinderServiceImplementation(courseFinderRepository());
    }

    @Bean
    CourseFinderEndPoints courseFinderController(){
        return new CourseFinderEndPoints(courseFinderServiceImplementation(), courseFinderResponseModelMapper());
    }

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplateBuilder().setConnectTimeout(Duration.ofMillis(10000)).build();
    }
}
