package com.rjbank.internal.resumeapp.model;

/**
 * Created by pjoshi1 on 11/29/2017.
 */
public class FinalApprovalRequest {

    private String taskId;
    private String userId;
    private String category;
    private Comment comment;
    private boolean finalApproval;

    public FinalApprovalRequest() {
    }

    public FinalApprovalRequest(String taskId, String userId, String category, Comment comment, boolean finalApproval) {
        this.taskId = taskId;
        this.userId = userId;
        this.category = category;
        this.comment = comment;
        this.finalApproval = finalApproval;
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

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public boolean isFinalApproval() {
        return finalApproval;
    }

    public void setFinalApproval(boolean finalApproval) {
        this.finalApproval = finalApproval;
    }
}
