package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseA;

import java.util.List;

public interface GetAllCoursesOrderedByCategory {
    List<Course> getAllCoursesOrderedByCategory();
}
