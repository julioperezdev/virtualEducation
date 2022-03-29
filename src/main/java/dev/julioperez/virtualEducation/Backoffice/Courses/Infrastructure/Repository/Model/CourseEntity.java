package dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "course")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CourseEntity {

    @Id
    private Long id;
    private String name;
    private Long price;
    private String category;

    public CourseEntity(String name, Long price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
