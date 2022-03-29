package dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model;

import java.util.Objects;

public class CourseCreatorResponse {

    private final String name;
    private final String category;
    private final Long price;

    public CourseCreatorResponse(String name, String category, Long price) {
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
}
