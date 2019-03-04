package com.applicationform.entities;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "JOB")
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long jId;

    private String companyName;

    private LocalDate jFrom;

    private LocalDate jTo;

    private String jobDesc;

    @ManyToOne
    @JoinColumn(name="aId")
    private ApplicationForm applicationForm;

    public Job() {
    }

    public Job(String companyName, LocalDate jFrom, LocalDate jTo, String jobDesc) {
        this.companyName = companyName;
        this.jFrom = jFrom;
        this.jTo = jTo;
        this.jobDesc = jobDesc;
    }

    public long getjId() {
        return jId;
    }

    public void setjId(long jId) {
        this.jId = jId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getjFrom() {
        return jFrom;
    }

    public void setjFrom(LocalDate jFrom) {
        this.jFrom = jFrom;
    }

    public LocalDate getjTo() {
        return jTo;
    }

    public void setjTo(LocalDate jTo) {
        this.jTo = jTo;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public ApplicationForm getApplicationForm() {
        return applicationForm;
    }

    public void setApplicationForm(ApplicationForm applicationForm) {
        this.applicationForm = applicationForm;
    }
}
