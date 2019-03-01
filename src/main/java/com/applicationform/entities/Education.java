package com.applicationform.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="EDUCATION")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long educationId;

	@Column(name = "SCHOOL")
	private String secondarySchools;

	@Column(name = "FROM_YEAR")
	private int fromYear;

	@Column(name = "TO_YEAR")
	private int toYear;

	@Column(name = "LEVEL")
	private String highestLevelAttained;

	@ManyToOne
	@JoinColumn(name="aId")
	private ApplicationForm applicationForm;

	@OneToMany(mappedBy = "education")
	@Column(name="Subject")
	@JsonIgnore
	private List<Subject> subjects = new ArrayList<>();

	public long getEducationId() {
		return educationId;
	}

	public void setEducationId(long educationId) {
		this.educationId = educationId;
	}

	public String getSecondarySchools() {
		return secondarySchools;
	}

	public void setSecondarySchools(String secondarySchools) {
		this.secondarySchools = secondarySchools;
	}

	public int getFromYear() {
		return fromYear;
	}

	public void setFromYear(int fromYear) {
		this.fromYear = fromYear;
	}

	public int getToYear() {
		return toYear;
	}

	public void setToYear(int toYear) {
		this.toYear = toYear;
	}

	public String getHighestLevelAttained() {
		return highestLevelAttained;
	}

	public void setHighestLevelAttained(String highestLevelAttained) {
		this.highestLevelAttained = highestLevelAttained;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public ApplicationForm getApplicationForm() {
		return applicationForm;
	}

	public void setApplicationForm(ApplicationForm applicationForm) {
		this.applicationForm = applicationForm;
	}
}
