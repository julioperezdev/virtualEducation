package dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Delivery;

import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.delivery.CourseCreatorEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCreatorRequest;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCreatorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/course")
public class SpringCourseController {

    private final CourseCreatorEndPoints courseCreatorEndPoints;

    public SpringCourseController(CourseCreatorEndPoints courseCreatorEndPoints) {
        this.courseCreatorEndPoints = courseCreatorEndPoints;
    }

    @PostMapping("/create")
    public CourseCreatorResponse createCourse(@RequestBody CourseCreatorRequest courseCreatorRequest){
        return courseCreatorEndPoints.createCourse(courseCreatorRequest);
    }

    @PostMapping("/create/model")
    public CourseCreatorResponse createCourseModel(@RequestBody CourseCreatorRequest courseCreatorRequest){
        return courseCreatorEndPoints.createCourseModel(courseCreatorRequest);
    }
}
