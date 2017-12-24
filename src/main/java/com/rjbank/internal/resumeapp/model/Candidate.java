package com.rjbank.internal.resumeapp.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by pjoshi1 on 11/26/2017.
 */
public class Candidate implements Serializable{
    private static final long serialVersionUID = 7526472295622776147L;
    private String name;
    private String resume;
    private int exp;
    private String category;
    private List<Comment> comments;
    private boolean prelimApproval;
    private boolean finalApproval;

    public Candidate(String name, String resume, int exp, String category, List<Comment> comments, boolean prelimApproval, boolean finalApproval) {
        this.name = name;
        this.resume = resume;
        this.exp = exp;
        this.category = category;
        this.comments = comments;
        this.prelimApproval = prelimApproval;
        this.finalApproval = finalApproval;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public boolean hasPrelimApproval() {
        return prelimApproval;
    }

    public void setPrelimApproval(boolean prelimApproval) {
        this.prelimApproval = prelimApproval;
    }

    public boolean hasFinalApproval() {
        return finalApproval;
    }

    public void setFinalApproval(boolean finalApproval) {
        this.finalApproval = finalApproval;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "name='" + name + '\'' +
                ", resume='" + resume + '\'' +
                ", exp=" + exp +
                ", category='" + category + '\'' +
                ", comments=" + comments +
                ", prelimApproval=" + prelimApproval +
                ", finalApproval=" + finalApproval +
                '}';
    }
}
