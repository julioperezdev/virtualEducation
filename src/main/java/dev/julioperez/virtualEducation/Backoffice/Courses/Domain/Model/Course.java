package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

public class Course {
    private String name;
    private Long price;
    private String category;

    public Course(String name, Long price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public static Course create(String name, Long price, String category){
        Course course = new Course(name, price, category);
        //here we will record in Event Drive Development, future feature
        return course;
    }

    public void rename(String newName){
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
