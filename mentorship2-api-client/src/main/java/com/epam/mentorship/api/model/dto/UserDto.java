package com.epam.mentorship.api.model.dto;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.epam.mentorship.enums.JobTitle;

public class UserDto {
    private static final int NAME_LENGTH = 50;

    @NotEmpty
    @Size(
            max = NAME_LENGTH)
    private String firstName;
    @NotEmpty
    @Size(
            max = NAME_LENGTH)
    private String lastName;
    @NotNull
    private Date dateOfBirth;
    @NotNull
    private JobTitle jobTitle;

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
}
