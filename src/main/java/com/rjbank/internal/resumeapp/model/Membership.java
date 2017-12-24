package com.rjbank.internal.resumeapp.model;

import java.util.List;

/**
 * Created by pjoshi1 on 11/26/2017.
 */
public class Membership {
    private String user;
    private List<String> membership;

    public Membership() {
    }

    public Membership(String user, List<String> membership) {
        this.user = user;
        this.membership = membership;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public List<String> getMembership() {
        return membership;
    }

    public void setMembership(List<String> membership) {
        this.membership = membership;
    }
}
