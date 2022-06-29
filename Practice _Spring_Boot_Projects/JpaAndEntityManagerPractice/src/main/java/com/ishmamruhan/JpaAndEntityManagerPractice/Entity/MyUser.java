package com.ishmamruhan.JpaAndEntityManagerPractice.Entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    private String email;

    @ElementCollection
    @CollectionTable(name = "user_phone", joinColumns = @JoinColumn(name = "id"))
    private List<String> phones = new ArrayList<>();

    public MyUser() {
    }

    public MyUser(Long id, String name, String email, List<String> phones) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phones = phones;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    @Override
    public String toString() {
        return "MyUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phones=" + phones +
                '}';
    }
}
