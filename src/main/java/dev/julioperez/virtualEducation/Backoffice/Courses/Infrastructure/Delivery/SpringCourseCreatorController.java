package dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Delivery;

import dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.delivery.CourseCreatorEndPoints;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCreatorRequest;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCreatorResponse;
import dev.julioperez.virtualEducation.Shared.Infrastructure.Delivery.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/course")
public class SpringCourseCreatorController {

    private final CourseCreatorEndPoints courseCreatorEndPoints;

    public SpringCourseCreatorController(CourseCreatorEndPoints courseCreatorEndPoints) {
        this.courseCreatorEndPoints = courseCreatorEndPoints;
    }

    @PostMapping("/create")
    public RestResponse<CourseCreatorResponse> createCourse(@RequestBody CourseCreatorRequest courseCreatorRequest){
        CourseCreatorResponse course = courseCreatorEndPoints.createCourse(courseCreatorRequest);
        return new RestResponse<>(
                HttpStatus.CREATED,
                HttpStatus.CREATED.getReasonPhrase(),
                course);
    }
}
