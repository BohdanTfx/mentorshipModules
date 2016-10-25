package com.epam.mentorship.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.ConstraintMode;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@DiscriminatorValue("mentee")
public class Mentee extends Participant {
    private static final long serialVersionUID = 4805639326935214139L;
    @ManyToOne(
            fetch = FetchType.LAZY)
    @JoinColumn(
            name = "mentor_id", foreignKey = @ForeignKey(
                    value = ConstraintMode.NO_CONSTRAINT))
    @JsonBackReference("mentor-mentee")
    private Mentor mentor;
    @Column
    private boolean active;
    @Column(
            name = "started_date")
    private Date startedDate;
    @Column(
            name = "end_date")
    private Date endDate;
    @Column
    private boolean started;
    @Column
    private boolean finished;
    @Column(
            name = "successfully_finished")
    private Boolean successfullyFinished;
    @Column(
            name = "mentorship_duration")
    private int mentorshipDuration;

    public Date getEndDate() {
        return endDate == null ? null : new Date(endDate.getTime());
    }

    public void setEndDate(final Date endDate) {
        this.endDate = new Date(endDate.getTime());
    }

    public boolean isStarted() {
        return started;
    }

    public void setStarted(final boolean started) {
        this.started = started;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(final boolean finished) {
        this.finished = finished;
    }

    public Boolean getSuccessfullyFinished() {
        return successfullyFinished;
    }

    public void setSuccessfullyFinished(final Boolean successfullyFinished) {
        this.successfullyFinished = successfullyFinished;
    }

    public Date getStartedDate() {
        return startedDate == null ? null : new Date(startedDate.getTime());
    }

    public void setStartedDate(final Date startedDate) {
        this.startedDate = new Date(startedDate.getTime());
    }

    public int getMentorshipDuration() {
        return mentorshipDuration;
    }

    public void setMentorshipDuration(final int mentorshipDuration) {
        this.mentorshipDuration = mentorshipDuration;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(final Mentor mentor) {
        this.mentor = mentor;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(final boolean active) {
        this.active = active;
    }
}
