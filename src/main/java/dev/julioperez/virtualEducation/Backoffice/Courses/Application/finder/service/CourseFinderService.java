package dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.service;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.GetAllCourses;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.GetCourseByCategory;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.GetCourseByPrice;

public interface CourseFinderService extends GetAllCourses, GetCourseByPrice, GetCourseByCategory {
//    List<Course> getAllCourses();
//    Course getCourseByPrice(CoursePrice coursePrice);
//    Course getCourseByCategory(CourseCategory category);
}
