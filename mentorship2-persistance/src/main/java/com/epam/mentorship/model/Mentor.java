package com.epam.mentorship.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@DiscriminatorValue("mentor")
public class Mentor extends Participant {
    private static final long serialVersionUID = 1808193470121300085L;
    @OneToMany(
            fetch = FetchType.LAZY, cascade = CascadeType.ALL,
            orphanRemoval = false, mappedBy = "mentor")
    @JsonManagedReference("mentor-mentee")
    private List<Mentee> mentees;

    public List<Mentee> getMentees() {
        return mentees;
    }

    public void setMentees(final List<Mentee> mentees) {
        this.mentees = mentees;
    }
}
