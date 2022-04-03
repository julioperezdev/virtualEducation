package dev.julioperez.virtualEducation.Backoffice.Courses.Application.create.repository;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Exeptions.CourseCanNotHaveSameNameException;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Exeptions.CourseDoesNotRecordedException;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.*;
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
    public Course createCourse(Course course) {
        CourseEntity courseEntityRecorded = createCourseEntity(course);
        return courseModelMapper.toDomainModel(courseEntityRecorded);
    }

    private CourseEntity createCourseEntity(Course courseToRecord) {
        this.checkIfExistCourseByName(courseToRecord);
        return Optional
                .of(courseDao.save(courseModelMapper.toEntity(courseToRecord)))
                .orElseThrow(() -> new CourseDoesNotRecordedException(courseToRecord));
    }

    private void checkIfExistCourseByName(Course course){
        Optional<CourseEntity> courseEntityByName = courseDao.getFirstByName(course.getName());
        if(courseEntityByName.isPresent()){
            throw new CourseCanNotHaveSameNameException(courseModelMapper
                    .toDomainModel(courseEntityByName.get())
                    .getName());
        }
    }
}
