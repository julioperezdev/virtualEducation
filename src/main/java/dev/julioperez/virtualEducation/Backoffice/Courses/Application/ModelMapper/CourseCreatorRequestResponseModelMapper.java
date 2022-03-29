package dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.*;

public class CourseCreatorRequestResponseModelMapper {

    public Course toCourse(CourseCreatorRequest courseCreatorRequest){
        CourseName name = new CourseName(courseCreatorRequest.getName());
        CoursePrice price = new CoursePrice(courseCreatorRequest.getPrice());
        CourseCategory category = new CourseCategory(courseCreatorRequest.getCategory());
        return Course.create(name, price, category);
    }

    public CourseCreatorResponse toCourseCreatorResponse(Course course){
        String name = course.name().value();
        Long price = course.price().value();
        String category = course.category().value();
        return new CourseCreatorResponse(name, category, price);
    }
    public CourseCreatorRequest toCourseCreatorRequest(Course course){
        String name = course.name().value();
        Long price = course.price().value();
        String category = course.category().value();
        return new CourseCreatorRequest(name, price, category);
    }
}
