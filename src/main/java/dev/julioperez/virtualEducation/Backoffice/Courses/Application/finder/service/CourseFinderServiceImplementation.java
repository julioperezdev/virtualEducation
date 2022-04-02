package dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.service;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.CourseFinderRepository;

import java.util.Comparator;
import java.util.List;

public class CourseFinderServiceImplementation implements CourseFinderService {

    private final CourseFinderRepository courseFinderRepository;

    public CourseFinderServiceImplementation(CourseFinderRepository courseFinderRepository) {
        this.courseFinderRepository = courseFinderRepository;
    }


    @Override
    public List<Course> getAllCoursesOrderedByCategory() {
        Comparator<Course> courseOrderedByCategory =Comparator
                .comparing(Course::getCategory)
                .thenComparing(Course::getPrice);
        return orderCourseByComparator(courseOrderedByCategory);
    }

    @Override
    public List<Course> getAllCoursesOrderedByLowerPrice() {
        Comparator<Course> courseOrderedByLowerPrice =Comparator
                .comparing(Course::getPrice)
                .thenComparing(Course::getName);
        return orderCourseByComparator(courseOrderedByLowerPrice);
    }

    @Override
    public List<Course> getAllCoursesOrderedByName() {
        Comparator<Course> courseOrderedByName =Comparator
                .comparing(Course::getName)
                .thenComparing(Course::getPrice);
        return orderCourseByComparator(courseOrderedByName);
    }

    private List<Course> orderCourseByComparator(Comparator<Course> courseOrderedByName) {
        return courseFinderRepository.getAllCourses()
                .stream()
                .sorted(courseOrderedByName)
                .toList();
    }
}
