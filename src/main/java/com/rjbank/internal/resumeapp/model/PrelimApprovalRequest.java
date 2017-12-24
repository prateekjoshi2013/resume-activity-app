package com.rjbank.internal.resumeapp.model;

/**
 * Created by pjoshi1 on 11/28/2017.
 */
public class PrelimApprovalRequest {
    private String taskId;
    private String userId;
    private String category;
    private Comment comment;
    private boolean prelimApproval;

    public PrelimApprovalRequest() {
    }

    public PrelimApprovalRequest(String taskId, String userId, String category, boolean prelimApproval, Comment comment) {
        this.taskId = taskId;
        this.userId = userId;
        this.category = category;
        this.prelimApproval = prelimApproval;
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

    public boolean isPrelimApproval() {
        return prelimApproval;
    }

    public void setPrelimApproval(boolean prelimApproval) {
        this.prelimApproval = prelimApproval;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
