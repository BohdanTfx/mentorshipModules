package com.epam.mentorship.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.epam.mentorship.aspect.annotation.BeforeSave;
import com.epam.mentorship.aspect.annotation.BeforeUpdate;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends BaseEntity<Long> {
	@XmlElement
	private String firstName;
	@XmlElement
	private String lastName;
	@XmlElement
	private Date dateOfBirth;
	@XmlElement
	private JobTitle jobTitle;
	private Date created;
	private Date lastModified;
	private User lastModifiedByUser;
	private User createdByUser;

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

	public User getLastModifiedByUser() {
		return lastModifiedByUser;
	}

	public void setLastModifiedByUser(User lastModifiedByUser) {
		this.lastModifiedByUser = lastModifiedByUser;
	}

	public User getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(User createdByUser) {
		this.createdByUser = createdByUser;
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

	public JobTitle getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(JobTitle jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	@BeforeUpdate
	public void beforeUpdate() {
		lastModified = new Date();
	}
	
	@BeforeSave
	public void beforeSave(){
		created = new Date();
	}
}
