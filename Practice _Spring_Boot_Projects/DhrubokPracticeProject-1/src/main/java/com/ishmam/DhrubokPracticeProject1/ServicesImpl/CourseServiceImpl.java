package com.ishmam.DhrubokPracticeProject1.ServicesImpl;

import com.ishmam.DhrubokPracticeProject1.ExceptionManagement.CustomError;
import com.ishmam.DhrubokPracticeProject1.Model.Course;
import com.ishmam.DhrubokPracticeProject1.Repositories.CourseRepo;
import com.ishmam.DhrubokPracticeProject1.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepo courseRepo;

    @Override
    public Course createCourse(Course course) throws CustomError {
        return courseRepo.save(course);
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
    public Course updateCourse(Course course1) throws CustomError {
        Course course = getCourseById(course1.getCourseId());

        if(course == null){
            throw new CustomError(HttpStatus.NOT_FOUND,"Course with id: "+course1.getCourseId()+" not found!");
        }

        return courseRepo.save(course1);
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
