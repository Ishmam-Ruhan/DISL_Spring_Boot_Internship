package com.ishmamruhan.PracticeProject2.Controller;

import com.ishmamruhan.PracticeProject2.Annotations.GetAPI;
import com.ishmamruhan.PracticeProject2.Annotations.PostAPI;
import com.ishmamruhan.PracticeProject2.Model.Student;
import com.ishmamruhan.PracticeProject2.Service.StudentService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StudentController {

    public static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    private StudentService studentService;

    @Operation(
            summary = "Add Student",
            description = "We can pass student parameter through this API"
    )
    @PostAPI("/add")
    public Student addStudent(@RequestBody Student student){
        logger.info("Incoming Details: {}",student);
        return studentService.addStudent(student);
    }

    @Operation(summary = "Get All Students", description = "Nothing to pass! Retrive all student data")
    @GetAPI("/all")
    public List<Student> getAllStudent(){
        return studentService.getAllStudent();
    }

}
