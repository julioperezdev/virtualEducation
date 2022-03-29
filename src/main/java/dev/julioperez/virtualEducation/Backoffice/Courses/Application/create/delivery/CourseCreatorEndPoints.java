package dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.delivery;

import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.service.CourseCreatorService;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.*;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper.CourseCreatorRequestResponseModelMapper;

public class CourseCreatorEndPoints {

    private final CourseCreatorService courseCreatorService;
    private final CourseCreatorRequestResponseModelMapper courseCreatorModelMapper;

    public CourseCreatorEndPoints(CourseCreatorService courseCreatorService, CourseCreatorRequestResponseModelMapper courseCreatorModelMapper) {
        this.courseCreatorService = courseCreatorService;
        this.courseCreatorModelMapper = courseCreatorModelMapper;
    }

    public CourseCreatorResponse createCourse(CourseCreatorRequest courseCreatorRequest){
        Course course = courseCreatorService.createCourse(
                new CourseName(courseCreatorRequest.getName()),
                new CoursePrice(courseCreatorRequest.getPrice()),
                new CourseCategory(courseCreatorRequest.getCategory()));
        return courseCreatorModelMapper.toCourseCreatorResponse(course);
    }

    public CourseCreatorResponse createCourseModel(CourseCreatorRequest courseCreatorRequest){
        Course courseModel = courseCreatorService.createCourseModel(courseCreatorModelMapper.toCourse(courseCreatorRequest));
        return courseCreatorModelMapper.toCourseCreatorResponse(courseModel);
    }
}
