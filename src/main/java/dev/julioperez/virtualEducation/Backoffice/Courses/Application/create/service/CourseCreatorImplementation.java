package dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.service;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.CourseCreatorRepository;

public class CourseCreatorImplementation {

    private final CourseCreatorRepository courseCreatorRepository;

    public CourseCreatorImplementation(CourseCreatorRepository courseCreatorRepository) {
        this.courseCreatorRepository = courseCreatorRepository;
    }
}
