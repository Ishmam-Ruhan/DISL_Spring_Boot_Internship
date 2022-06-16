package com.ishmam.DhrubokPracticeProject1.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ishmam.DhrubokPracticeProject1.ExceptionManagement.CustomError;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.http.HttpStatus;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"age","createdAt","updatedAt"}, allowGetters = true)
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
    @OneToOne(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER, optional = false)
    private Address address;
    @NotNull
    private String bloodGroup;

    @ManyToMany(mappedBy = "users")
    @JsonIgnoreProperties({"users"})
    private List<Course> courses = new LinkedList<>();

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date createdAt;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date updatedAt;

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

        if(date.length != 3) {
            throw new CustomError(HttpStatus.BAD_REQUEST, "Operation Failed! Please Provide date with correct format. Ex: dd-MM-yyyy");
        }

        LocalDate todayDate = LocalDate.now();
        LocalDate birthDate  = LocalDate.of(
          Integer.parseInt(date[2]),
          Integer.parseInt(date[1]),
          Integer.parseInt(date[0])
        );

        Period calculatedDate = Period.between(birthDate,todayDate);

        setAge(calculatedDate.getYears());
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

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
