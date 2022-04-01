package dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.service;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.*;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.CourseCreatorRepository;

public class CourseCreatorServiceImplementation implements CourseCreatorService{

    private final CourseCreatorRepository courseCreatorRepository;

    public CourseCreatorServiceImplementation(CourseCreatorRepository courseCreatorRepository) {
        this.courseCreatorRepository = courseCreatorRepository;
    }

    public Course createCourse(Course newCourse){
        return courseCreatorRepository.createCourse(newCourse);
    }

}
