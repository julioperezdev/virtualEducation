package dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.service;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCategory;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CoursePrice;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.GetAllCourses;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.GetCourseByCategory;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.GetCourseByPrice;

import java.util.List;

public interface CourseFinder extends GetAllCourses, GetCourseByPrice, GetCourseByCategory {
//    List<Course> getAllCourses();
//    Course getCourseByPrice(CoursePrice coursePrice);
//    Course getCourseByCategory(CourseCategory category);
}
