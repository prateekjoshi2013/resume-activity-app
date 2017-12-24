package com.rjbank.internal.resumeapp.model;

/**
 * Created by pjoshi1 on 11/28/2017.
 */
public class SortResumeRequest {
    private String taskId;
    private String userId;
    private String category;
    private Comment comment;

    public SortResumeRequest() {
    }

    public SortResumeRequest(String taskId, String userId, String category, Comment comment) {
        this.taskId = taskId;
        this.userId = userId;
        this.category = category;
        this.comment = comment;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comments) {
        this.comment = comments;
    }
}
