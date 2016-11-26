package com.epam.mentorship.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@JsonIdentityInfo(
        generator = ObjectIdGenerators.IntSequenceGenerator.class,
        property = "id")
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class User extends BaseEntity<Long> {
    private static final long serialVersionUID = -5521224528701477777L;
    @Column(
            name = "first_name")
    private String firstName;
    @Column(
            name = "last_name")
    private String lastName;
    @Column(
            name = "dob")
    private Date dateOfBirth;
    @Column(
            name = "job")
    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;
    @Column
    private Date created;
    @Column(
            name = "last_modified")
    private Date lastModified;
    @JoinColumn(
            name = "modificator_id")
    @ManyToOne
    @XmlTransient
    private User lastModifiedByUser;
    @JoinColumn(
            name = "creator_id")
    @ManyToOne(
            cascade = CascadeType.PERSIST)
    @XmlTransient
    private User createdByUser;

    public Date getCreated() {
        return created == null ? null : new Date(created.getTime());
    }

    public void setCreated(final Date created) {
        this.created = new Date(created.getTime());
    }

    public Date getLastModified() {
        return lastModified == null ? null : new Date(lastModified.getTime());
    }

    public void setLastModified(final Date lastModified) {
        this.lastModified = new Date(lastModified.getTime());
    }

    public User getLastModifiedByUser() {
        return lastModifiedByUser;
    }

    public void setLastModifiedByUser(final User lastModifiedByUser) {
        this.lastModifiedByUser = lastModifiedByUser;
    }

    public User getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(final User createdByUser) {
        this.createdByUser = createdByUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public JobTitle getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(final JobTitle jobTitle) {
        this.jobTitle = jobTitle;
    }

    public Date getDateOfBirth() {
        return dateOfBirth == null ? null : new Date(dateOfBirth.getTime());
    }

    public void setDateOfBirth(final Date dateOfBirth) {
        this.dateOfBirth = new Date(dateOfBirth.getTime());
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
