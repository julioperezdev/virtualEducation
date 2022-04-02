package dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Delivery;

import dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.delivery.CourseFinderEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseFinderResponse;
import dev.julioperez.virtualEducation.Shared.Infrastructure.Delivery.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/course")
public class SpringCourseFinderController {

    private final CourseFinderEndPoints courseFinderEndPoints;

    public SpringCourseFinderController(CourseFinderEndPoints courseFinderEndPoints) {
        this.courseFinderEndPoints = courseFinderEndPoints;
    }

    @PutMapping("/get/ordered/by/name")
    public RestResponse<List<CourseFinderResponse>> getAllCoursesOrderedByName(){
        List<CourseFinderResponse> allCoursesOrderedByName = courseFinderEndPoints.getAllCoursesOrderedByName();
        return new RestResponse<>(
                HttpStatus.FOUND,
                HttpStatus.FOUND.getReasonPhrase(),
                allCoursesOrderedByName);

    }

    @PutMapping("/get/ordered/by/category")
    public RestResponse<List<CourseFinderResponse>> getAllCoursesOrderedByCategory(){
        List<CourseFinderResponse> allCoursesOrderedByCategory = courseFinderEndPoints.getAllCoursesOrderedByCategory();
        return new RestResponse<>(
                HttpStatus.FOUND,
                HttpStatus.FOUND.getReasonPhrase(),
                allCoursesOrderedByCategory);

    }

    @PutMapping("/get/ordered/by/price/lower")
    public RestResponse<List<CourseFinderResponse>> getAllCoursesOrderedByLowerPrice(){
        List<CourseFinderResponse> allCoursesOrderedByLowerPrice = courseFinderEndPoints.getAllCoursesOrderedByLowerPrice();
        return new RestResponse<>(
                HttpStatus.FOUND,
                HttpStatus.FOUND.getReasonPhrase(),
                allCoursesOrderedByLowerPrice);

    }
}
