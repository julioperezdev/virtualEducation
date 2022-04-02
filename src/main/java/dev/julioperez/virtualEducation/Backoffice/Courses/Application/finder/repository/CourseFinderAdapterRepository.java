package dev.julioperez.virtualEducation.Backoffice.Courses.Application.finder.repository;

import dev.julioperez.virtualEducation.Backoffice.Courses.Application.ModelMapper.CourseModelMapper;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.Course;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Port.CourseFinderRepository;
import dev.julioperez.virtualEducation.Backoffice.Courses.Infrastructure.Repository.Dao.CourseDao;

import java.util.List;
import java.util.stream.Collectors;

public class CourseFinderAdapterRepository implements CourseFinderRepository {

    private final CourseDao courseDao;
    private final CourseModelMapper courseModelMapper;

    public CourseFinderAdapterRepository(CourseDao courseDao, CourseModelMapper courseModelMapper) {
        this.courseDao = courseDao;
        this.courseModelMapper = courseModelMapper;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.findAll()
                .stream()
                .map(courseModelMapper::toDomainModel)
                .collect(Collectors.toList());
    }
}
