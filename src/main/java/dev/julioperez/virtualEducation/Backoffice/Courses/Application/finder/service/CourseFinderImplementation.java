package dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.service;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCategory;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CoursePrice;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.CourseRepository;

import java.util.List;

public class CourseFinderImplementation implements CourseFinder{

    private final CourseRepository courseRepository;

    public CourseFinderImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.getAllCourses();
    }

    @Override
    public Course getCourseByPrice(CoursePrice coursePrice) {
        return courseRepository.getCourseByPrice(coursePrice);
    }

    @Override
    public Course getCourseByCategory(CourseCategory category) {
        return courseRepository.getCourseByCategory(category);
    }
}
