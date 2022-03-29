package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

import dev.julioperez.virtualEducation.Shared.Domain.ValueObject.StringValueObject;

public class CourseCategory extends StringValueObject {

    public CourseCategory(String value) {
        super(value);
    }

    private CourseCategory(){
        super("");
    }
}
