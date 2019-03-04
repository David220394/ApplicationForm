package com.applicationform.entities;

import javax.persistence.*;

@Entity
@Table(name="SUBJECT")
public class Subject {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long subjectId;

	@Column(name = "SUBJECT_NAME")
	private String subject;

	@Column(name = "RESULT")
	private String result;

	@ManyToOne
	@JoinColumn(name="EDUCATION_ID")
	private Education education;

	public Subject() {
	}

	public Subject(String subject, String result) {
		this.subject = subject;
		this.result = result;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Education getEducation() {
		return education;
	}

	public void setEducation(Education education) {
		this.education = education;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
