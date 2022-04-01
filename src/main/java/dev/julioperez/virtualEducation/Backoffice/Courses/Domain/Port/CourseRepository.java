package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.*;

import java.util.List;

public interface CourseRepository {
    List<Course> getAllCourses();
    Course getCourseByPrice(CoursePrice coursePrice);
    Course getCourseByCategory(CourseCategory category);
    Course createCourse(CourseName name, CoursePrice price, CourseCategory category);
    Void createCourseModel(Course course);
}
