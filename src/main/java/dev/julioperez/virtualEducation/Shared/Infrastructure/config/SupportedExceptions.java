package dev.julioperez.virtualEducation.Shared.Infrastructure.config;

import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCanNotHaveSameNameException;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseCreatorRequestDontHaveRequirementException;
import dev.julioperez.virtualEducation.Backoffice.Courses.Domain.Model.CourseDoesNotRecordedException;
import dev.julioperez.virtualEducation.Shared.Domain.DomainError;
import org.springframework.http.HttpStatus;

public enum SupportedExceptions {

    //Categories Controller Exceptions
    //..

    //CourseCreatorEndpoints Exceptions
    COURSE_CREATOR_REQUEST_DONT_HAVE_REQUIREMENT(CourseCreatorRequestDontHaveRequirementException.class, HttpStatus.PRECONDITION_FAILED),

    //CourseCreatorAdapterRepository Exceptions
    COURSE_DOES_NOT_RECORDED(CourseDoesNotRecordedException.class, HttpStatus.BAD_GATEWAY),
    COURSE_CAN_NOT_HAVE_SAME_NAME(CourseCanNotHaveSameNameException.class, HttpStatus.PRECONDITION_REQUIRED);


    private Class<? extends DomainError> exceptionClass;
    private HttpStatus status;
    private SupportedExceptions(Class<? extends DomainError>exception, HttpStatus status){
        this.exceptionClass = exception;
        this.status = status;
    }

    public Class <? extends DomainError> getExceptionClass(){
        return this.exceptionClass;
    }

    public HttpStatus getStatus(){
        return this.status;
    }
}
