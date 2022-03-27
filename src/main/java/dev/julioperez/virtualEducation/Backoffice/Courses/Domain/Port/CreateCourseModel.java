package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;

public interface CreateCourseModel {
    Void createCourseModel(Course course);
}
