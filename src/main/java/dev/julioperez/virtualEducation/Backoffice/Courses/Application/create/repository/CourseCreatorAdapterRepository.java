package dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.repository;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCategory;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseName;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CoursePrice;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.CourseCreatorRepository;
import dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository.Dao.CourseDao;
import dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository.Model.CourseEntity;
import dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper.CourseModelMapper;

import java.util.Optional;

public class CourseCreatorAdapterRepository implements CourseCreatorRepository {

    private final CourseDao courseDao;
    private final CourseModelMapper courseModelMapper;

    public CourseCreatorAdapterRepository(CourseDao courseDao, CourseModelMapper courseModelMapper) {
        this.courseDao = courseDao;
        this.courseModelMapper = courseModelMapper;
    }

    @Override
    public Course createCourse(CourseName name, CoursePrice price, CourseCategory category) {
        Course courseToRecord = new Course(name, price, category);
        CourseEntity courseEntityRecorded = createCourseEntity(courseToRecord);
        return courseModelMapper.toDomainModel(courseEntityRecorded);
    }

    @Override
    public Course createCourseModel(Course course) {
        CourseEntity courseEntityRecorded = createCourseEntity(course);
        return courseModelMapper.toDomainModel(courseEntityRecorded);
    }

    private CourseEntity createCourseEntity(Course courseToRecord) {
        return Optional
                .of(courseDao.save(courseModelMapper.toEntity(courseToRecord)))
                .orElseThrow(IllegalArgumentException::new);
    }
}
