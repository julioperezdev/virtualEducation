package dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Delivery;

import dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.delivery.CourseFinderEndPoints;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/course")
public class SpringCourseFinderController {

    private final CourseFinderEndPoints courseFinderEndPoints;

    public SpringCourseFinderController(CourseFinderEndPoints courseFinderEndPoints) {
        this.courseFinderEndPoints = courseFinderEndPoints;
    }
}
