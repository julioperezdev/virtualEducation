package dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseFinderResponse;

import java.util.List;

public class CourseFinderResponseModelMapper {

    public List<CourseFinderResponse> toCourseFinderListResponse(List<Course> courses){
        return courses.stream().map(this::toCourseFinderResponse).toList();
    }

    private CourseFinderResponse toCourseFinderResponse(Course course){
        String name = course.getName();
        Long price = course.getPrice();
        String category = course.getCategory();
        return new CourseFinderResponse(name, price, category);
    }
}
