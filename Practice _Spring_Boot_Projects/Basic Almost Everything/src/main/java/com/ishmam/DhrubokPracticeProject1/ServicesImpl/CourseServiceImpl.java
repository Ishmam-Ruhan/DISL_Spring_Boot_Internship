package com.ishmam.DhrubokPracticeProject1.ServicesImpl;

import com.ishmam.DhrubokPracticeProject1.ExceptionManagement.CustomError;
import com.ishmam.DhrubokPracticeProject1.Model.Course;
import com.ishmam.DhrubokPracticeProject1.Repositories.CourseRepo;
import com.ishmam.DhrubokPracticeProject1.Services.CourseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    public static final Logger logger = LoggerFactory.getLogger(CourseServiceImpl.class);

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Course createCourse(Course course) throws CustomError {

        Course course1 = null;

        try{
            course1 = courseRepo.save(course);
        }catch (Exception ex){
            throw new CustomError(HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage());
        }

        return course1;
    }

    @Override
    public String createAllCourse(List<Course> courses) throws CustomError {

        courseRepo.saveAll(courses);

        return "Successfully Saved All Users!";
    }

    @Override
    public Course getCourseById(BigInteger id) throws CustomError {
        Optional<Course> course = courseRepo.findById(id);

        if(!course.isPresent()){
            throw new CustomError(
                    HttpStatus.NOT_FOUND,
                    "Course with id: "+id+" Not Found!"
            );
        }

        return course.get();
    }

    @Override
    public Course getCourseByCourseCode(String code) throws CustomError {
        Optional<Course> course = courseRepo.courseCode(code);

        if(!course.isPresent()){
            throw new CustomError(
                    HttpStatus.NOT_FOUND,
                    "Course with code: "+code+" Not Found!"
            );
        }

        return course.get();
    }

    @Override
    public List<Course> getCourseByCourseName(String courseName) throws CustomError {
        List<Course> courses = courseRepo.searchCourseByCourseName(courseName);

        return courses;
    }

    @Override
    public List<Course> getAllCourses() throws CustomError {
        return courseRepo.findAll();
    }

    @Override
    public Course updateCourse(Course updatedCourse) throws CustomError {
        Course course = getCourseById(updatedCourse.getCourseId());

        if(course == null){
            throw new CustomError(HttpStatus.NOT_FOUND,"Course with id: "+updatedCourse.getCourseId()+" not found!");
        }

        course.setCourseCode(
                updatedCourse.getCourseCode() != null ? updatedCourse.getCourseCode() : course.getCourseCode());
        course.setCourseDescription(
                updatedCourse.getCourseDescription() != null ? updatedCourse.getCourseDescription() : course.getCourseDescription());
        course.setCourseName(
                updatedCourse.getCourseName() != null ? updatedCourse.getCourseName() : course.getCourseName());

        return createCourse(course);
    }

    @Override
    public String deleteCourseWithId(BigInteger id) throws CustomError {
        Course course = getCourseById(id);

        if(course == null){
            throw new CustomError(HttpStatus.NOT_FOUND,"Course with id: "+id+" not found!");
        }

        courseRepo.deleteById(id);

        return "Course with id: "+id+" deleted successfully!";
    }
}
