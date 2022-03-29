package dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository.Dao;

import dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository.Model.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface CourseDao extends JpaRepository<CourseEntity, Long> {

    @Query(value = "SELECT * FROM COURSE WHERE PRICE = :price ", nativeQuery = true)
    Optional<CourseEntity> getCourseByPrice(@Param("price") Long price);

    Optional<CourseEntity> getCourseEntityByCategory(String category);
}
