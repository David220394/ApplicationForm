package com.applicationform.entities;

import com.applicationform.Application;

import javax.persistence.*;

@Entity
@Table(name = "TEDUCATION")
public class TEducation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tid;

    private String tName;

    private String course;

    private int tFrom;

    private int tTo;

    private String result;

    @ManyToOne
    @JoinColumn(name="aId")
    private ApplicationForm applicationForm;

    public TEducation() {
    }

    public TEducation(String tName, String course, int tFrom, int tTo, String result) {
        this.tName = tName;
        this.course = course;
        this.tFrom = tFrom;
        this.tTo = tTo;
        this.result = result;
    }

    public long getTid() {
        return tid;
    }

    public void setTid(long tid) {
        this.tid = tid;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public int gettFrom() {
        return tFrom;
    }

    public void settFrom(int tFrom) {
        this.tFrom = tFrom;
    }

    public int gettTo() {
        return tTo;
    }

    public void settTo(int tTo) {
        this.tTo = tTo;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public ApplicationForm getApplicationForm() {
        return applicationForm;
    }

    public void setApplicationForm(ApplicationForm applicationForm) {
        this.applicationForm = applicationForm;
    }
}
