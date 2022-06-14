package com.ishmam.DhrubokPracticeProject1.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ishmam.DhrubokPracticeProject1.ExceptionManagement.CustomError;
import com.ishmam.DhrubokPracticeProject1.Helpers.DateGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    public static final Logger logger = LoggerFactory.getLogger(User.class);

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private BigInteger id;

    @NotNull(message = "Name field should not be empty!")
    @Size(min = 2, message = "Minimum length should be 2.")
    private String name;

    @Email(message = "Please provide a valid email address.")
    private String email;

    @NotNull(message = "Date of Birth field must not be null!")
    private String dateOfBirth;
    private int age;
    @NotNull(message = "Address field must not be null!")
    @OneToOne(cascade = CascadeType.ALL)
    private Address address;
    @NotNull
    private String bloodGroup;

    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties({"users"})
    private List<Course> courses = new LinkedList<>();

    private String createdAt;

    private String updatedAt;

    public User() {
    }

    public User(String name, String email, String dateOfBirth, int age, Address address, String bloodGroup, List<Course> courses) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.address = address;
        this.bloodGroup = bloodGroup;
        this.courses = courses;
    }

    @PrePersist
    public void prePersist(){
        if(this.createdAt == null) setCreatedAt(DateGenerator.generateDate());
        if(this.updatedAt == null) setUpdatedAt(DateGenerator.generateDate());
    }

    @PreUpdate
    public void preUpdate(){
        setUpdatedAt(this.getUpdatedAt());
        setUpdatedAt(DateGenerator.generateDate());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) && getEmail().equals(user.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getEmail());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", age=" + age +
                ", address=" + address +
                ", bloodGroup='" + bloodGroup + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
        setAge();
    }

    public int getAge() {
        return age;
    }

    private void setAge() {
        String[] date = getDateOfBirth().split("-");

        if(date.length == 1) {
            throw new CustomError(HttpStatus.BAD_REQUEST, "Operation Failed! Please Provide date with correct format. Ex: dd-MM-yyyy");
        }

        LocalDate todayDate = LocalDate.now();
        LocalDate birthDate  = LocalDate.of(
          Integer.parseInt(date[2]),
          Integer.parseInt(date[1]),
          Integer.parseInt(date[0])
        );

        Period calculatedDate = Period.between(birthDate,todayDate);

        this.age = calculatedDate.getYears();
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
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
