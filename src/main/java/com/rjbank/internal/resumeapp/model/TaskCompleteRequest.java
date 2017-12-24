package com.rjbank.internal.resumeapp.model;

/**
 * Created by pjoshi1 on 11/27/2017.
 */
public class TaskCompleteRequest {
    private String taskId;
    private String userId;
    private Candidate candidate;

    public TaskCompleteRequest(String taskId, String userId, Candidate candidate) {
        this.taskId = taskId;
        this.userId = userId;
        this.candidate = candidate;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }
}
