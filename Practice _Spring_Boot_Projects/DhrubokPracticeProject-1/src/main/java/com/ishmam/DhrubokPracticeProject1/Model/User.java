package com.ishmam.DhrubokPracticeProject1.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ishmam.DhrubokPracticeProject1.Helpers.DateDeserializer;
import com.ishmam.DhrubokPracticeProject1.Helpers.DateGenerator;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigInteger;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private BigInteger id;

    @NotNull(message = "Name field should not be empty!")
    @Size(min = 2, message = "Minimum length should be 2.")
    private String name;

    @Email(message = "Please provide a valid email address.")
    private String email;

    @JsonDeserialize(using = DateDeserializer.class)
    @NotNull(message = "Date of Birth field must not be null!")
    private Date dateOfBirth;
    private int age;
    @NotNull(message = "Address field must not be null!")
    @OneToOne(fetch = FetchType.EAGER)
    @MapsId
    private Address address;
    @NotNull
    private String bloodGroup;
    @NotNull
    @JsonDeserialize(using = DateDeserializer.class)
    private Date createdAt = new Date();
    @JsonDeserialize(using = DateDeserializer.class)
    private Date updatedAt;

    public User() {
    }

    public User(String name, String email, Date dateOfBirth, int age, Address address, String bloodGroup) {
        this.name = name;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
        this.age = age;
        this.address = address;
        this.bloodGroup = bloodGroup;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {

        LocalDate today = LocalDate.now();

        LocalDate birthDate = LocalDate.ofInstant(getDateOfBirth().toInstant(), ZoneId.systemDefault());

        Period calculatedAge = Period.between(birthDate,today);

        this.age = calculatedAge.getYears();
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}
