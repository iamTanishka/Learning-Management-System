package com.example.demo;

public class User {
    public enum Role{
        Instructor,
        Learner
    }
    private int Userid;
    private String UserName;
    private String UserEmail;
    private String UserPassword;
    private Role role;
    public User(String UserName, String UserEmail, String UserPassword, Role role){
        this.UserName=UserName;
        this.UserEmail=UserEmail;
        this.UserPassword=UserPassword;
        this.role=role;
        this.Userid=Userid;
    }

    public String getUserName() {
        return UserName;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public String getUserPassword() {
        return UserPassword;
    }

    public Role getRole() {
        return role;
    }
    public void setUserName(String userName) {
        UserName = userName;
    }

    public void setUserEmail(String userEmail) {
        UserEmail = userEmail;
    }

    public void setUserPassword(String userPassword) {
        UserPassword = userPassword;
    }
    public void setrole(Role role){
        this.role=role;
    }
}
