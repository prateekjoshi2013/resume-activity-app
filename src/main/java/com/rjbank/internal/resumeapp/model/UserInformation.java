package com.rjbank.internal.resumeapp.model;

import java.util.List;

/**
 * Created by pjoshi1 on 11/23/2017.
 */
public class UserInformation {
    private String firstName;
    private String lastName;
    private String userId;
    private String password;
    private String email;
    private List<String> groups;

    public UserInformation() {
    }

    public UserInformation(String firstName, String lastName, String password, String email, List<String> groups) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.groups = groups;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getGroups() {
        return groups;
    }

    public void setGroups(List<String> groups) {
        this.groups = groups;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
