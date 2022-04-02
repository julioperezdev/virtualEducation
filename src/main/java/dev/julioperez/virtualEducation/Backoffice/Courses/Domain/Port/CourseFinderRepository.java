package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;

import java.util.List;

public interface CourseFinderRepository {
    List<Course> getAllCourses();
}
