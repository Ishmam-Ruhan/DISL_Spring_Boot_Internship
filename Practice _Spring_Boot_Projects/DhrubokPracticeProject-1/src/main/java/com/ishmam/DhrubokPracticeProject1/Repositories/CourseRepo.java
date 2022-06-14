package com.ishmam.DhrubokPracticeProject1.Repositories;

import com.ishmam.DhrubokPracticeProject1.Model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepo extends JpaRepository<Course, BigInteger> {

    @Query("SELECT c FROM Course c WHERE LOWER(c.courseName) LIKE :queryValue")
    List<Course> searchCourseByCourseName(@Param(value = "queryValue") String queryValue);

    Optional<Course> courseCode(String code);
}
