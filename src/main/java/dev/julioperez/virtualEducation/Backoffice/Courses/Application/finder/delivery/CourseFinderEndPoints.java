package dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.delivery;

import dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper.CourseFinderResponseModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.service.CourseFinderService;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseFinderResponse;

import java.util.List;

public class CourseFinderEndPoints {

    private final CourseFinderService courseFinderService;
    private final CourseFinderResponseModelMapper courseFinderResponseModelMapper;

    public CourseFinderEndPoints(CourseFinderService courseFinderService, CourseFinderResponseModelMapper courseFinderResponseModelMapper) {
        this.courseFinderService = courseFinderService;
        this.courseFinderResponseModelMapper = courseFinderResponseModelMapper;
    }
    public List<CourseFinderResponse> getAllCoursesOrderedByName(){
        return courseFinderResponseModelMapper.toCourseFinderListResponse(
                courseFinderService.getAllCoursesOrderedByName());
    }

    public List<CourseFinderResponse> getAllCoursesOrderedByCategory(){
        return courseFinderResponseModelMapper.toCourseFinderListResponse(
                courseFinderService.getAllCoursesOrderedByCategory());
    }

    public List<CourseFinderResponse> getAllCoursesOrderedByLowerPrice(){
        return courseFinderResponseModelMapper.toCourseFinderListResponse(
                courseFinderService.getAllCoursesOrderedByLowerPrice());
    }
}
