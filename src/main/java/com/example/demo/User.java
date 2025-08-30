package com.example.demo;

public class User {
    public enum Role {
        Instructor,
        Learner
    }

    private String userName;
    private String userEmail;
    private String password;
    private Role role;

    public User(String userName, String userEmail, String password, Role role) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.password = password;
        this.role = role;
    }
    public String getUserName() {
        return userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public Role getRole() {
        return role;
    }
}