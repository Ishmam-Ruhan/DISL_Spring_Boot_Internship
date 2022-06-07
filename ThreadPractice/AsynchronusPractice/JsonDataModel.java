package com.ishmamruhan.Dhrubok_Practice_Session.AsynchronusPractice;

public class JsonDataModel {
    private int id;
    private String email;

    public JsonDataModel() {
    }

    public JsonDataModel(int id, String email) {
        this.id = id;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "JsonDataModel{" +
                "id=" + id +
                ", email='" + email + '\'' +
                '}';
    }
}
