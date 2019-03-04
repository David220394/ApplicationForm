package com.applicationform.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="APPLICATION_FORM")
public class ApplicationForm {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long aId;

	@Column(name="POST")
	private String post;

	@Column(name="FIRST_NAME")
	private String firstName;

	@Column(name="LAST_NAME")
	private String lastName;

	@Column(name = "ADDRESS")
	private String address;

	@Column(name = "EMAIL")
	private String emailAddress;

	@Column(name = "PHONE")
	private String phoneNumber;

	@Column(name = "MOBILE")
	private String mobilePhoneNumber;

	@OneToMany(mappedBy = "applicationForm",fetch = FetchType.EAGER)

	private List<Education> educations;

	@OneToMany(mappedBy = "applicationForm")

	private List<TEducation> tEducations;

	@OneToMany(mappedBy = "applicationForm")

	private List<Job> jobs;

	public long getaId() {
		return aId;
	}

	public void setaId(long aId) {
		this.aId = aId;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getMobilePhoneNumber() {
		return mobilePhoneNumber;
	}

	public void setMobilePhoneNumber(String mobilePhoneNumber) {
		this.mobilePhoneNumber = mobilePhoneNumber;
	}


	public List<Education> getEducations() {
		return educations;
	}

	public void setEducations(List<Education> educations) {
		this.educations = educations;
	}

	public List<TEducation> gettEducations() {
		return tEducations;
	}

	public void settEducations(List<TEducation> tEducations) {
		this.tEducations = tEducations;
	}

	public List<Job> getJobs() {
		return jobs;
	}

	public void setJobs(List<Job> jobs) {
		this.jobs = jobs;
	}
}
