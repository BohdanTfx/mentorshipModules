package com.epam.mentorship.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.epam.mentorship.aspect.annotation.BeforeSave;
import com.epam.mentorship.aspect.annotation.BeforeUpdate;
import com.epam.mentorship.enums.JobTitle;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends BaseEntity<Long> {
	private static final long serialVersionUID = -5521224528701477777L;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "dob")
	private Date dateOfBirth;
	@Column(name = "job")
	@Enumerated(EnumType.STRING)
	private JobTitle jobTitle;
	@Column
	private Date created;
	@Column(name = "last_modified")
	private Date lastModified;
	@JoinColumn(name = "modificator_id")
	@ManyToOne(cascade = CascadeType.ALL)
	@XmlTransient
	private User lastModifiedByUser;
	@JoinColumn(name = "creator_id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	@XmlTransient
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
	public void beforeSave() {
		created = new Date();
		lastModified = created;
	}
}
