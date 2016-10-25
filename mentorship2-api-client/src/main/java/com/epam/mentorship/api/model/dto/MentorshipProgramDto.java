package com.epam.mentorship.api.model.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.epam.mentorship.enums.Location;
import com.epam.mentorship.enums.Technology;

public class MentorshipProgramDto {
    private static final int TITLE_LENGTH = 50;
    @NotEmpty
    @Size(
            max = TITLE_LENGTH)
    private String title;
    @Min(0L)
    private Long headId;
    @NotNull
    private Technology technology;
    @NotNull
    private Location location;

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public Long getHeadId() {
        return headId;
    }

    public void setHeadId(final Long headId) {
        this.headId = headId;
    }

    public Technology getTechnology() {
        return technology;
    }

    public void setTechnology(final Technology technology) {
        this.technology = technology;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(final Location location) {
        this.location = location;
    }
}
