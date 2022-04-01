package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

import dev.julioperez.virtualEducation.Shared.Domain.DomainError;

public class CourseNotExist extends DomainError {

    public CourseNotExist(String name) {
        super("course_not_exist", String.format("The course %s does not exist", name));
    }
}
