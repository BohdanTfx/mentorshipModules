package com.epam.mentorship.model.mongo;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

public class LogEntry implements Serializable {
    private static final long serialVersionUID = -5145006007646402468L;
    @Id
    private Long id;
    private String title;
    private String description;
    private Date logDate;
    private String type;

    public LogEntry() {
    }

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

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

}
