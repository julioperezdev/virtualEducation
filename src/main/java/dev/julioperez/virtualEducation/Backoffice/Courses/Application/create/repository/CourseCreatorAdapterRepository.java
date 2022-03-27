package dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.repository;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCategory;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseName;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CoursePrice;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.CourseCreatorRepository;

public class CourseCreatorAdapterRepository implements CourseCreatorRepository {

    @Override
    public Course createCourse(CourseName name, CoursePrice price, CourseCategory category) {
        return null;
    }

    @Override
    public Void createCourseModel(Course course) {
        return null;
    }
}
