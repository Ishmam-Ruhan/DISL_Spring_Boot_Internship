package com.ishmam.DhrubokPracticeProject1.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "user_addresses")
@JsonIgnoreProperties(value = {"createdAt","updatedAt"},allowGetters = true)
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

    @Column(nullable = false,updatable = false)
    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @LastModifiedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date updatedAt;

    public Address() {
    }

    public Address(String division, String district, String upazilla, long zipCode, User user) {
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
