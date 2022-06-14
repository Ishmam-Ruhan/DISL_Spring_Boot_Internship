package com.ishmam.DhrubokPracticeProject1.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ishmam.DhrubokPracticeProject1.Helpers.DateGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private BigInteger courseId;

    @Size(min = 3, message = "Minimum length of subject name is 3.")
    private String courseName;

    @Size(min = 6, max = 6, message = "Course code length should be 6!")
    private String courseCode;

    @NotNull(message = "Course description can't be empty!")
    private String courseDescription;

    @ManyToMany(cascade = {CascadeType.MERGE,CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @JoinTable(
            name = "courses_users_table",
            joinColumns = {
                    @JoinColumn(name = "course_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "user_id")
            }
    )
    @JsonIgnoreProperties({"courses"})
    private List<User> users = new LinkedList<>();

    private String createdAt;

    private String updatedAt;

    public Course() {
    }

    public Course(String courseName, String courseCode, String courseDescription, List<User> users) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseDescription = courseDescription;
        this.users = users;
    }

    @PrePersist
    public void prePersist(){
        if(this.getUpdatedAt() == null) this.setUpdatedAt(DateGenerator.generateDate());
        if(this.getCreatedAt() == null) this.setCreatedAt(DateGenerator.generateDate());
    }

    @PreUpdate
    public void preUpdate(){
        setCreatedAt(this.getCreatedAt());
        setUpdatedAt(DateGenerator.generateDate());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return getCourseId().equals(course.getCourseId()) && getCourseName().equals(course.getCourseName()) && getCourseCode().equals(course.getCourseCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCourseId(), getCourseName(), getCourseCode());
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId=" + courseId +
                ", courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", courseDescription='" + courseDescription + '\'' +
                ", users=" + users +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }

    public BigInteger getCourseId() {
        return courseId;
    }

    public void setCourseId(BigInteger courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
