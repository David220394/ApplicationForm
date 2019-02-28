package com.applicationform.entities;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="APPLICATION_FORM")
public class Education {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long educationId;

	@Column(name = "SCHOOL")
	private String secondarySchools;

	@Column(name = "FROM")
	private int fromYear;

	@Column(name = "TO")
	private int to;

	@Column(name = "LEVEL")
	private String highestLevelAttained;

	@OneToMany(mappedBy = "education")
	private List<Subject> subjects;

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

	public int getTo() {
		return to;
	}

	public void setTo(int to) {
		this.to = to;
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
}
