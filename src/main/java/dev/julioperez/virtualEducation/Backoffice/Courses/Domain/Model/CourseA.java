package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

public class CourseA {

    private CourseName name;
    private CoursePrice price;
    private CourseCategory category;

    public CourseA(CourseName name, CoursePrice price, CourseCategory category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static CourseA create(CourseName name, CoursePrice price, CourseCategory category){
        CourseA courseA = new CourseA(name, price, category);
        //here we will record in Event Drive Development, future feature
        return courseA;
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
