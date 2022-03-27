package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

import dev.julioperez.virtualEducation.Shared.Domain.ValueObject.LongValueObject;

public class CourseId extends LongValueObject {

    protected CourseId(Long value) {
        super(value);
    }
}
