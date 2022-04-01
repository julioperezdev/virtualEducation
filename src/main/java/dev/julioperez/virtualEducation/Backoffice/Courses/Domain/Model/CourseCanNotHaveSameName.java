package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

import dev.julioperez.virtualEducation.Shared.Domain.DomainError;

public class CourseCanNotHaveSameName extends DomainError {

    public CourseCanNotHaveSameName(String name) {
        super("course_can_not_have_same_name", String.format("The new Course with NAME: %s , exist in database", name));
    }


}
