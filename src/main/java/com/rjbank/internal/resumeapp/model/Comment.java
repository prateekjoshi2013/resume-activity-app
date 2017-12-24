package com.rjbank.internal.resumeapp.model;

import java.io.Serializable;

/**
 * Created by pjoshi1 on 11/26/2017.
 */
public class Comment implements Serializable {
    private static final long serialVersionUID = 7526472295622776148L;
    private String commentor;
    private String description;

    public Comment() {
    }

    public Comment(String commentor, String description) {
        this.commentor = commentor;
        this.description = description;
    }

    public String getCommentor() {
        return commentor;
    }

    public void setCommentor(String commentor) {
        this.commentor = commentor;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
