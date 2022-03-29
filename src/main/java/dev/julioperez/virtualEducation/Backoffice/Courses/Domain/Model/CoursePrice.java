package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

import dev.julioperez.virtualEducation.Shared.Domain.ValueObject.LongValueObject;

public class CoursePrice extends LongValueObject {

    public CoursePrice(Long value) {
        super(value);
    }

    public CoursePrice() {
        super(0L);
    }
}
