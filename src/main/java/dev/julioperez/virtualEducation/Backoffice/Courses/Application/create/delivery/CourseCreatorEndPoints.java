package dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.delivery;

import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.service.CourseCreatorService;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Exeptions.CourseCreatorRequestDontHaveRequirementException;
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
        if (courseCreatorRequest.validateFields()) {
            throw new CourseCreatorRequestDontHaveRequirementException(courseCreatorRequest);
        }
        Course course = courseCreatorService.createCourse(courseCreatorModelMapper.toCourse(courseCreatorRequest));
        return courseCreatorModelMapper.toCourseCreatorResponse(course);
    }
}
