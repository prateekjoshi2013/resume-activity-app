package com.rjbank.internal.resumeapp.model;

/**
 * Created by pjoshi1 on 12/25/2017.
 */
public class ModifyMembershipRequest {
    private String user;
    private GroupMembershipStatus groups;

    public ModifyMembershipRequest() {
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public GroupMembershipStatus getGroups() {
        return groups;
    }

    public void setGroups(GroupMembershipStatus groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "ModifyMembershipRequest{" +
                "user='" + user + '\'' +
                ", groupMembershipStatus=" + groups +
                '}';
    }
}
