package com.ishmamruhan.PracticeProject2.Service;

import com.ishmamruhan.PracticeProject2.Model.Student;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface StudentService {

    Student addStudent(Student student);

    List<Student> getAllStudent();

    Student getStudentById(long id);

    Student updateStudent(Student student);

    String deleteStudent(Long id);
}
