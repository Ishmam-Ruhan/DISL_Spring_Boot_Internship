package com.ishmam.DhrubokPracticeProject1.Controller;

import com.ishmam.DhrubokPracticeProject1.Annotations.DeleteAPI;
import com.ishmam.DhrubokPracticeProject1.Annotations.GetAPI;
import com.ishmam.DhrubokPracticeProject1.Annotations.PostAPI;
import com.ishmam.DhrubokPracticeProject1.Annotations.PutAPI;
import com.ishmam.DhrubokPracticeProject1.Model.Course;
import com.ishmam.DhrubokPracticeProject1.Output.Response;
import com.ishmam.DhrubokPracticeProject1.Services.CourseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("api/v1/course/")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Operation(
            summary = "Course Controller Welcome Message",
            description = "Course Controller Check!!"
    )
    @GetAPI("/")
    public ResponseEntity<Response> sayHiFromCourseController(){

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Welcome Message!",
                        true,
                        "Hello! I'm From Course Controller!"
                ));
    }

    @Operation(
            summary = "Create/Add a Course",
            description = "We ca create or add a course by passing a Course Object."
    )
    @PostAPI("/create")
    public ResponseEntity<Response> createCourse(@Valid @RequestBody Course course){

        Course course1 = courseService.createCourse(course);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Response<>(
                        HttpStatus.CREATED,
                        "Create Course Successfully!",
                        true,
                        course1
                ));
    }

    @Operation(
            summary = "Create/Add Multiple Course",
            description = "We ca create or add a list of course by passing a Course Object."
    )
    @PostAPI("/create/all")
    public ResponseEntity<Response> createMultipleCourse(@Valid @RequestBody List<Course> courses){

        String message = courseService.createAllCourse(courses);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new Response<>(
                        HttpStatus.CREATED,
                        "Created All Courses Successfully!",
                        true,
                        message
                ));
    }

    @Operation(
            summary = "Find Course By ID",
            description = "We can retrive a course by passing a course id in this API"
    )
    @GetAPI("/get/id/{id}")
    public ResponseEntity<Response> getCourseById(@PathVariable(value = "id") BigInteger id){

        Course course = courseService.getCourseById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Retrieve Success!",
                        true,
                        course
                ));
    }

    @Operation(
            summary = "Find Course By Course Code",
            description = "We can retrieve a course by passing a COURSE CODE  in this API"
    )
    @GetAPI("/get/code/{code}")
    public ResponseEntity<Response> getCourseByCourseCode(@PathVariable(value = "code") String code){

        Course course = courseService.getCourseByCourseCode(code);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Retrieve Success!",
                        true,
                        course
                ));
    }

    @Operation(
            summary = "Find/Search Course By Course Name",
            description = "We can retrieve a course by passing a COURSE NAME  in this API"
    )
    @GetAPI("/get/name/{name}")
    public ResponseEntity<Response> getCourseByCourseName(@PathVariable(value = "name") String name){

        List<Course> courses = courseService.getCourseByCourseName("%"+name+"%".toLowerCase());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Retrieve Success!",
                        true,
                        courses
                ));
    }

    @Operation(
            summary = "Retrieve All Courses",
            description = "Get All Courses"
    )
    @GetAPI("/get/all")
    public ResponseEntity<Response> getAllCourse(){

        List<Course> courses = courseService.getAllCourses();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Retrieve Success!",
                        true,
                        courses
                ));
    }

    @Operation(
            summary = "Update Course",
            description = "We can update any course here!"
    )
    @PutAPI("/update")
    public ResponseEntity<Response> updateCourse(@Valid @RequestBody Course course){

        Course course1 = courseService.updateCourse(course);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Retrieve Success!",
                        true,
                        course1
                ));
    }

    @Operation(
            summary = "Delete Course",
            description = "We can perform delete operation on any course here!"
    )
    @DeleteAPI("/delete")
    public ResponseEntity<Response> deleteCourse(@RequestBody Course course){

        String message = courseService.deleteCourseWithId(course.getCourseId());

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(new Response<>(
                        HttpStatus.OK,
                        "Delete Course with id: "+course.getCourseId()+" Success!",
                        true,
                        message
                ));
    }
}
