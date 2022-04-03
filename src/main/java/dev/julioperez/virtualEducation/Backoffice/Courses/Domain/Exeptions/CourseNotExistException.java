package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Exeptions;

import dev.julioperez.virtualEducation.Shared.Domain.DomainError;

public class CourseNotExistException extends DomainError {

    public CourseNotExistException(String name) {
        super("course_not_exist", String.format("The course %s does not exist", name));
    }
}
