package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

public class Course {

    private CourseName name;
    private CoursePrice price;
    private CourseCategory category;

    public Course(CourseName name, CoursePrice price, CourseCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static Course create(CourseName name, CoursePrice price, CourseCategory category){
        Course course = new Course(name, price, category);
        //here we will record in Event Drive Development, future feature
        return course;
    }

    public CourseName name(){
        return this.name;
    }

    public CoursePrice price(){
        return this.price;
    }

    public CourseCategory category(){
        return this.category;
    }

    public void rename(CourseName newName){
        this.name = newName;
    }
}
