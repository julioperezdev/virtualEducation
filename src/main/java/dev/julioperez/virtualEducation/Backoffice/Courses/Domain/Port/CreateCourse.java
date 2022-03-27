package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCategory;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseName;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CoursePrice;

public interface CreateCourse {
    Course createCourse(CourseName name, CoursePrice price, CourseCategory category);
}
