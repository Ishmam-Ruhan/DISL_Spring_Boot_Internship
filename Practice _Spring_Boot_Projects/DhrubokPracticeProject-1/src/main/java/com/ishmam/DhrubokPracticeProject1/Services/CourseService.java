package com.ishmam.DhrubokPracticeProject1.Services;

import com.ishmam.DhrubokPracticeProject1.ExceptionManagement.CustomError;
import com.ishmam.DhrubokPracticeProject1.Model.Course;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.List;

@Service
public interface CourseService {

    Course createCourse(Course course) throws CustomError;

    String createAllCourse(List<Course> courses) throws CustomError;

    Course getCourseById(BigInteger id) throws CustomError;

    Course getCourseByCourseCode(String code) throws CustomError;

    List<Course> getCourseByCourseName(String courseName) throws CustomError;

    List<Course> getAllCourses() throws CustomError;

    Course updateCourse(Course course) throws CustomError;

    String deleteCourseWithId(BigInteger id)throws CustomError;
}
