package dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.repository;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCategory;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CoursePrice;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.CourseFinderRepository;

import java.util.List;

public class CourseFinderAdapterRepository implements CourseFinderRepository {

    @Override
    public List<Course> getAllCourses() {
        return null;
    }

    @Override
    public Course getCourseByCategory(CourseCategory category) {
        return null;
    }

    @Override
    public Course getCourseByPrice(CoursePrice coursePrice) {
        return null;
    }
}
