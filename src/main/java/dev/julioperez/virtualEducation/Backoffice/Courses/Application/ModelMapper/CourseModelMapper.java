package dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.*;
import dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository.Model.CourseEntity;

public class CourseModelMapper {

    public CourseEntity toEntity(Course course){
        return new CourseEntity(
                course.getName(),
                course.getPrice(),
                course.getCategory());
    }
    public Course toDomainModel(CourseEntity courseEntity){
        String courseName = courseEntity.getName();
        Long coursePrice = courseEntity.getPrice();
        String courseCategory = courseEntity.getCategory();
        return Course.create(courseName, coursePrice, courseCategory);
    }
}
