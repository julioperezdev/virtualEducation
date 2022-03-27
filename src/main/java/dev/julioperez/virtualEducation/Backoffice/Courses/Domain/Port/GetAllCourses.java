package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;

import java.util.List;

public interface GetAllCourses {
    List<Course> getAllCourses();
}
