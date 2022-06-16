package com.ishmamruhan.PracticeProject2.ServiceImpl;

import com.ishmamruhan.PracticeProject2.Dao.StudentRepo;
import com.ishmamruhan.PracticeProject2.Model.Student;
import com.ishmamruhan.PracticeProject2.Service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Primary
@Service
public class StudentServiceImpl implements StudentService {

    public static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    public StudentRepo studentRepo;

    @Override
    public Student addStudent(Student student) {
        return studentRepo.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }

    @Override
    public Student getStudentById(long id) {
        return studentRepo.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {

        Student student1 =getStudentById(student.getId());

        if(student1 == null){
            logger.error("No Student With Such ID");
            return null;
        }

        BeanUtils.copyProperties(student, student1);

        return studentRepo.save(student1);
    }

    @Override
    public String deleteStudent(Long id) {
        Student student1 =getStudentById(id);

        if(student1 == null){
            logger.error("No Student With Such ID");
            return null;
        }

        studentRepo.deleteById(id);

        return null;
    }
}
