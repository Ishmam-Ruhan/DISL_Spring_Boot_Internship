package com.ishmamruhan.DislAssignmentOne.Entity.ContactEntity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ContactSearchCriteria {
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String city;
    private String state;
    private String zipcode;

    private Long startAge;

    private Long endAge;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String startBirthDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private String endBirthDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public Long getStartAge() {
        return startAge;
    }

    public void setStartAge(Long startAge) {
        this.startAge = startAge;
    }

    public Long getEndAge() {
        return endAge;
    }

    public void setEndAge(Long endAge) {
        this.endAge = endAge;
    }

    public String getStartBirthDate() {
        return startBirthDate;
    }

    public void setStartBirthDate(String startBirthDate) {
        this.startBirthDate = startBirthDate;
    }

    public String getEndBirthDate() {
        return endBirthDate;
    }

    public void setEndBirthDate(String endBirthDate) {
        this.endBirthDate = endBirthDate;
    }
}
