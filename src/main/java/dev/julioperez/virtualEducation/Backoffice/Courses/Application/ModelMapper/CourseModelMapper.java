package dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCategory;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseName;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CoursePrice;
import dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository.Model.CourseEntity;

public class CourseModelMapper {

    public CourseEntity toEntity(Course course){
        return new CourseEntity(
                course.name().value(),
                course.price().value(),
                course.category().value());
    }
    public Course toDomainModel(CourseEntity courseEntity){
        CourseName courseName = new CourseName(courseEntity.getName());
        CoursePrice coursePrice = new CoursePrice(courseEntity.getPrice());
        CourseCategory courseCategory = new CourseCategory(courseEntity.getCategory());
        return Course.create(courseName, coursePrice, courseCategory);
    }
}
