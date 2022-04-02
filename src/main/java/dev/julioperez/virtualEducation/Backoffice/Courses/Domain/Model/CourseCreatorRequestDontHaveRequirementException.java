package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

import dev.julioperez.virtualEducation.Shared.Domain.DomainError;

public class CourseCreatorRequestDontHaveRequirementException extends DomainError {

    public CourseCreatorRequestDontHaveRequirementException(CourseCreatorRequest courseCreatorRequest) {
        super("course_creator_request_dont_have_requirement",
                String.format("The Course creator Request with NAME: %s | CATEGORY: %s | PRICE: %d dont have requirement",
                        courseCreatorRequest.getName(),
                        courseCreatorRequest.getCategory(),
                        courseCreatorRequest.getPrice()));
    }
}
