package dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.*;

public class CourseCreatorRequestResponseModelMapper {

    public Course toCourse(CourseCreatorRequest courseCreatorRequest){
        String name = courseCreatorRequest.getName();
        Long price = courseCreatorRequest.getPrice();
        String category = courseCreatorRequest.getCategory();
        return Course.create(name, price, category);
    }

    public CourseCreatorResponse toCourseCreatorResponse(Course course){
        String name = course.getName();
        Long price = course.getPrice();
        String category = course.getCategory();
        return new CourseCreatorResponse(name, category, price);
    }
    public CourseCreatorRequest toCourseCreatorRequest(Course course){
        String name = course.getName();
        Long price = course.getPrice();
        String category = course.getCategory();
        return new CourseCreatorRequest(name, price, category);
    }
}
