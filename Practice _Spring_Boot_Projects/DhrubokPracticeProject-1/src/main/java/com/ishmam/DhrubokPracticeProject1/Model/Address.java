package com.ishmam.DhrubokPracticeProject1.Model;

import com.ishmam.DhrubokPracticeProject1.Helpers.DateGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.util.Objects;

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

    private String createdAt;

    private String updatedAt;

    public Address() {
    }

    public Address(String division, String district, String upazilla, long zipCode) {
        this.division = division;
        this.district = district;
        this.upazilla = upazilla;
        this.zipCode = zipCode;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return getId().equals(address.getId());
    }

    @PrePersist
    public void prePersist(){
        if(this.createdAt == null) setCreatedAt(DateGenerator.generateDate());
        if(this.updatedAt == null) setUpdatedAt(DateGenerator.generateDate());
    }

    @PreUpdate
    public void preUpdate(){
        setCreatedAt(this.getCreatedAt());
        setUpdatedAt(DateGenerator.generateDate());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", division='" + division + '\'' +
                ", district='" + district + '\'' +
                ", upazilla='" + upazilla + '\'' +
                ", zipCode=" + zipCode +
                ", createdAt=" + createdAt +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
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
