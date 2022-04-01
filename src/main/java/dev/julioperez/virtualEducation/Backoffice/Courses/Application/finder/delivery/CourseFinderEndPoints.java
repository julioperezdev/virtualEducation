package dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.delivery;

import dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.service.CourseFinderService;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseA;

import java.util.List;

public class CourseFinderEndPoints {

    private final CourseFinderService courseFinderService;

    public CourseFinderEndPoints(CourseFinderService courseFinderService) {
        this.courseFinderService = courseFinderService;
    }

    public List<CourseA> getAllCoursesOrderedByName(){
        return courseFinderService.getAllCoursesOrderedByName();
    }

    public List<CourseA> getAllCoursesOrderedByCategory(){
        return courseFinderService.getAllCoursesOrderedByCategory();
    }

    public List<CourseA> getAllCoursesOrderedByLowerPrice(){
        return courseFinderService.getAllCoursesOrderedByLowerPrice();
    }
}
