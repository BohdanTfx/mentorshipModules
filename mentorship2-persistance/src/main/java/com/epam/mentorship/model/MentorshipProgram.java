package com.epam.mentorship.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.epam.mentorship.enums.Location;
import com.epam.mentorship.enums.Technology;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "mentorship_program")
public class MentorshipProgram extends BaseEntity<Long> {
	private static final long serialVersionUID = 2323549146427836149L;
	@XmlElement
	@Column
	private String title;
	@XmlElement
	@OneToOne
	@JoinColumn(name = "head_id")
	private User head;
	@XmlElement
	@Column
	@Enumerated(EnumType.STRING)
	private Technology technology;
	@XmlElement
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "mentorshipProgram")
	private List<Participant> participants;
	@XmlElement
	@Column
	@Enumerated(EnumType.STRING)
	private Location location;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private boolean started;
	@Column
	private boolean finished;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isStarted() {
		return started;
	}

	public void setStarted(boolean started) {
		this.started = started;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Participant> getParticipants() {
		return participants;
	}

	public void setParticipants(List<Participant> participants) {
		this.participants = participants;
	}

	public User getHead() {
		return head;
	}

	public void setHead(User head) {
		this.head = head;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}
}
