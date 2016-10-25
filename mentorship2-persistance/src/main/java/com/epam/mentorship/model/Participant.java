package com.epam.mentorship.model;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(
        name = "participant")
@Inheritance(
        strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name = "participant_type")
public abstract class Participant extends BaseEntity<Long> {
    private static final long serialVersionUID = -5892744491800884816L;
    @OneToOne
    @JoinColumn(
            name = "user_id")
    private User user;
    @ManyToOne
    @JoinColumn(
            name = "mentorship_program_id")
    @JsonBackReference
    private MentorshipProgram mentorshipProgram;

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public MentorshipProgram getMentorshipProgram() {
        return mentorshipProgram;
    }

    public void setMentorshipProgram(
            final MentorshipProgram mentorshipProgram) {
        this.mentorshipProgram = mentorshipProgram;
    }
}
