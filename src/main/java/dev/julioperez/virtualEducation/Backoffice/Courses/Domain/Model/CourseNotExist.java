package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

public class CourseNotExist extends RuntimeException{

    private final CourseName name;

    public CourseNotExist(CourseName name) {
        this.name = name;
    }

    public String errorCode(){
        return "course_not_exist";
    }

    protected String errorMessage(){
        return String.format("The course %s does not exist", this.name.value());
    }
}
