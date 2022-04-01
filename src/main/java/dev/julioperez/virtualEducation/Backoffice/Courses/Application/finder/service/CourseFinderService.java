package dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.service;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.GetAllCoursesOrderedByName;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.GetAllCoursesOrderedByCategory;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.GetAllCoursesOrderedByLowerPrice;

public interface CourseFinderService extends GetAllCoursesOrderedByName, GetAllCoursesOrderedByLowerPrice, GetAllCoursesOrderedByCategory {
}
