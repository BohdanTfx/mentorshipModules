package com.epam.mentorship.api.model.dto;

public class MenteeStateDto {
    private Boolean active;
    private Boolean start;
    private Boolean end;

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public Boolean getStart() {
        return start;
    }

    public void setStart(final Boolean start) {
        this.start = start;
    }

    public Boolean getEnd() {
        return end;
    }

    public void setEnd(final Boolean end) {
        this.end = end;
    }
}
