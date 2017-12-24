package com.rjbank.internal.resumeapp.model;

import org.apache.ibatis.javassist.bytecode.ByteArray;

/**
 * Created by pjoshi1 on 11/23/2017.
 */
public class Resume {
    private String name;
    private int exp;
    private String resume;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }


    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    @Override
    public String toString() {
        return "Resume{" +
                "name='" + name + '\'' +
                ", exp=" + exp +
                ", resume='" + resume + '\'' +
                '}';
    }
}
