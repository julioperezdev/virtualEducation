package dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.service;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCategory;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseName;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CoursePrice;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.CourseCreatorRepository;

public class CourseCreatorServiceImplementation implements CourseCreatorService{

    private final CourseCreatorRepository courseCreatorRepository;

    public CourseCreatorServiceImplementation(CourseCreatorRepository courseCreatorRepository) {
        this.courseCreatorRepository = courseCreatorRepository;
    }

    public Course createCourseModel(Course newCourse){
        return courseCreatorRepository.createCourseModel(newCourse);
    }

    public Course createCourse(CourseName name, CoursePrice price, CourseCategory category){
        return courseCreatorRepository.createCourse(name, price, category);
    }
}
