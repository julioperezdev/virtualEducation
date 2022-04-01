package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

import dev.julioperez.virtualEducation.Shared.Domain.DomainError;

public class CourseDoesNotRecorded extends DomainError {

    public CourseDoesNotRecorded(Course course){
        super("course_does_not_recorded",
                String.format("The Course with NAME: %s | CATEGORY: %s | PRICE: %d does not recorded",
                        course.getName(),
                        course.getCategory(),
                        course.getPrice()));
    }
}
