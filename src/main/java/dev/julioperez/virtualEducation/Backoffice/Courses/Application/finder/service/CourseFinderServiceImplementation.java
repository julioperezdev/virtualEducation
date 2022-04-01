package dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.service;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.CourseRepository;

import java.util.Comparator;
import java.util.List;

public class CourseFinderServiceImplementation implements CourseFinderService {

    private final CourseRepository courseRepository;

    public CourseFinderServiceImplementation(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Course> getAllCoursesOrderedByCategory() {
        Comparator<Course> courseOrderedByCategory =Comparator
                .comparing(Course::getCategory);
        return orderCourseByComparator(courseOrderedByCategory);
    }

    @Override
    public List<Course> getAllCoursesOrderedByLowerPrice() {
        Comparator<Course> courseOrderedByLowerPrice =Comparator
                .comparing(Course::getPrice)
                .reversed();
        return orderCourseByComparator(courseOrderedByLowerPrice);
    }

    @Override
    public List<Course> getAllCoursesOrderedByName() {
        Comparator<Course> courseOrderedByName =Comparator
                .comparing(Course::getName);
        return orderCourseByComparator(courseOrderedByName);
    }

    private List<Course> orderCourseByComparator(Comparator<Course> courseOrderedByName) {
        return courseRepository.getAllCourses()
                .stream()
                .sorted(courseOrderedByName)
                .toList();
    }
}
