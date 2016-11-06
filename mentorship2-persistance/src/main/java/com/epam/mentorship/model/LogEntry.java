package com.epam.mentorship.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.epam.mentorship.aspect.annotation.BeforeSave;

@Entity
public class LogEntry extends BaseEntity<Long> {
    private static final int DESCRIPTION_MAX_LENGTH = 3000;
    private static final long serialVersionUID = -5145006007646402468L;
    @Column(
            nullable = false)
    private String title;
    @Column(
            length = DESCRIPTION_MAX_LENGTH)
    private String description;
    @Column
    private Date logDate;
    @Column
    private String type;

    public LogEntry(final String title, final String description,
            final String type) {
        this.title = title;
        this.description = description;
        this.type = type;
    }

    public LogEntry(final String title, final String description) {
        this.title = title;
        this.description = description;
    }

    @BeforeSave
    public void prePersist() {
        logDate = new Date();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Date getLogDate() {
        return logDate == null ? null : new Date(logDate.getTime());
    }

    public void setLogDate(final Date logDate) {
        this.logDate = new Date(logDate.getTime());
    }

    public String getType() {
        return type;
    }

    public void setType(final String type) {
        this.type = type;
    }

}
