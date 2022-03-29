package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

import dev.julioperez.virtualEducation.Shared.Domain.ValueObject.StringValueObject;

public class CourseName extends StringValueObject {

    public CourseName(String value) {
        super(value);
    }

    private CourseName(){
        super("");
    }
}
