package com.rjbank.internal.resumeapp.model;

/**
 * Created by pjoshi1 on 12/25/2017.
 */
public class GroupMembershipStatus {
    private boolean resumeUploadGroup;
    private boolean prelimApprovalGroup;
    private boolean finalApprovalGroup;

    public GroupMembershipStatus() {
    }

    public boolean isResumeUploadGroup() {
        return resumeUploadGroup;
    }

    public void setResumeUploadGroup(boolean resumeUploadGroup) {
        this.resumeUploadGroup = resumeUploadGroup;
    }

    public boolean isPrelimApprovalGroup() {
        return prelimApprovalGroup;
    }

    public void setPrelimApprovalGroup(boolean prelimApprovalGroup) {
        this.prelimApprovalGroup = prelimApprovalGroup;
    }

    public boolean isFinalApprovalGroup() {
        return finalApprovalGroup;
    }

    public void setFinalApprovalGroup(boolean finalApprovalGroup) {
        this.finalApprovalGroup = finalApprovalGroup;
    }
}
