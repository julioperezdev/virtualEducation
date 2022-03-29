package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

import java.util.Objects;

public class CourseCreatorRequest {

    private final String name;
    private final String category;
    private final Long price;

    public CourseCreatorRequest(String name, Long price, String category) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public Long getPrice() {
        return price;
    }

    public Boolean validateFields(){
        return validateName() || validatePrice()  || validateCategory();
    }

    private Boolean validateName(){
        return !Objects.equals(name, null) && !Objects.equals(name, "");
    }

    private Boolean validateCategory(){
        return !Objects.equals(category, null) && !Objects.equals(category, "");
    }

    private Boolean validatePrice(){
        return !Objects.equals(price, null) && price > 0;
    }
}
