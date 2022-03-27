package dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.service;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCategory;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CoursePrice;

import java.util.List;

public interface CourseFinder {
    List<Course> getAllCourses();
    Course getCourseByPrice(CoursePrice coursePrice);
    Course getCourseByCategory(CourseCategory category);
}
