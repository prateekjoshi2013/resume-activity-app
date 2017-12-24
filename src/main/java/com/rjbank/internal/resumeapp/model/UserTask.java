package com.rjbank.internal.resumeapp.model;

/**
 * Created by pjoshi1 on 11/28/2017.
 */
public class UserTask {
    private String taskId;
    private String taskName;

    public UserTask(String taskId, String taskName) {
        this.taskId = taskId;
        this.taskName = taskName;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
}
