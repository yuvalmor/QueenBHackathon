package com.example.queenbproj;

import java.util.Date;

public class Task {

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public Date getSubmitDate() {
        return submitDate;
    }

    public void setSubmitDate(Date submitDate) {
        this.submitDate = submitDate;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public int getParts() {
        return parts;
    }

    public void setParts(int parts) {
        this.parts = parts;
    }

    public int getPrecentageFromGrade() {
        return precentageFromGrade;
    }

    public void setPrecentageFromGrade(int precentageFromGrade) {
        this.precentageFromGrade = precentageFromGrade;
    }

    private String title;
    private String course;
    private Date submitDate;
    private String decription;
    private int parts;
    private int precentageFromGrade;




}
