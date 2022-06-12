package com.ishmam.DhrubokPracticeProject1.Model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.ishmam.DhrubokPracticeProject1.Helpers.DateDeserializer;
import com.ishmam.DhrubokPracticeProject1.Helpers.DateGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Date;

@Entity
@Table(name = "user_addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT")
    private BigInteger id;
    @NotNull(message = "Division field must not be null!")
    private String division;
    private String district;
    private String upazilla;
    @NotNull(message = "Zipcode field must not be null!")
    private long zipCode;

    @JsonDeserialize(using = DateDeserializer.class)
    private Date createdAt = new Date();

    @JsonDeserialize(using = DateDeserializer.class)
    private String updatedAt;

    public Address() {
    }

    public Address(String division, String district, String upazilla, long zipCode) {
        this.division = division;
        this.district = district;
        this.upazilla = upazilla;
        this.zipCode = zipCode;
    }

    public BigInteger getId() {
        return id;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getUpazilla() {
        return upazilla;
    }

    public void setUpazilla(String upazilla) {
        this.upazilla = upazilla;
    }

    public long getZipCode() {
        return zipCode;
    }

    public void setZipCode(long zipCode) {
        this.zipCode = zipCode;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
