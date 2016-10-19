package com.epam.mentorship.api.facade;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentorship.api.facade.annotation.ApiFacade;
import com.epam.mentorship.api.model.dto.MenteeStateDto;
import com.epam.mentorship.enums.Location;
import com.epam.mentorship.model.Mentee;
import com.epam.mentorship.model.Mentor;
import com.epam.mentorship.service.MenteeService;
import com.epam.mentorship.service.MentorService;
import com.epam.mentorship.service.MentorshipProgramService;
import com.epam.mentorship.service.UserService;

@ApiFacade
public class ParticipantApiService {
	@Autowired
	private MentorService mentorService;
	@Autowired
	private MenteeService menteeService;
	@Autowired
	private UserService userService;
	@Autowired
	private MentorshipProgramService mentorshipProgramService;

	public Mentor createMentor(Long mentorshipProgramId, Long userId) {
		Mentor mentor = new Mentor();
		mentor.setUser(userService.findById(userId));
		mentor.setMentorshipProgram(mentorshipProgramService.findById(mentorshipProgramId));
		return mentorService.create(mentor);
	}

	public Mentor addMentees(Long id, List<Long> menteesId) {
		Mentor mentor = mentorService.findById(id);
		if (mentor.getMentees() != null) {
			mentor.getMentees().addAll(menteeService.getMenteesFromIds(menteesId));
		} else {
			mentor.setMentees(menteeService.getMenteesFromIds(menteesId));
		}
		return mentorService.update(mentor);
	}

	public Mentor removeMentees(Long mentorId, Long menteeId) {
		Mentor mentor = mentorService.findById(mentorId);
		List<Mentee> mentees = mentor.getMentees();
		for (Iterator<Mentee> iterator = mentees.iterator(); iterator.hasNext();) {
			Mentee mentee = (Mentee) iterator.next();
			if (Long.compare(mentee.getId(), menteeId) == 0) {
				iterator.remove();
			}
		}

		return mentorService.update(mentor);
	}

	public Mentee createMentee(Long mentorshipProgramId, Long userId) {
		Mentee mentee = new Mentee();
		mentee.setUser(userService.findById(userId));
		mentee.setMentorshipProgram(mentorshipProgramService.findById(mentorshipProgramId));

		return menteeService.create(mentee);
	}

	public Mentee assignMentor(Long menteeId, Long mentorId) {
		Mentee mentee = menteeService.findById(menteeId);
		mentee.setMentor(mentorService.findById(mentorId));

		return menteeService.update(mentee);
	}

	public Mentee changeMenteeState(Long menteeId, MenteeStateDto menteeStateDto) {
		Mentee mentee = menteeService.findById(menteeId);
		if (menteeStateDto.getActive() != null) {
			mentee.setActive(menteeStateDto.getActive());
		}
		if (menteeStateDto.getStart() != null && menteeStateDto.getStart()) {
			mentee.setStarted(true);
			mentee.setStartedDate(new Date());
		}
		if (menteeStateDto.getEnd() != null && menteeStateDto.getEnd()) {
			mentee.setFinished(true);
			mentee.setEndDate(new Date());
		}

		return menteeService.update(mentee);
	}

	public Double getMenteesFinishStatistic(Date startDate, Date endDate, Boolean successfullyFinished) {
		startDate = startDate == null ? new GregorianCalendar(1990, 1, 1).getTime() : startDate;
		endDate = endDate == null ? new Date() : endDate;
		successfullyFinished = successfullyFinished == null ? true : successfullyFinished;

		return menteeService.getFinishStatistic(startDate, endDate, successfullyFinished);
	}

	public Mentee updateMentee(Mentee entity) {
		return menteeService.update(entity);
	}

	public void deleteMentee(Mentee entity) {
		menteeService.delete(entity);
	}

	public void deleteMentee(Long id) {
		menteeService.delete(id);
	}

	public Mentee findMenteeById(Long id) {
		return menteeService.findById(id);
	}

	public List<Mentee> findMentees() {
		return menteeService.findMentees();
	}

	public List<Mentee> findMenteesWithoutMentorByLocation(Location location) {
		return menteeService.findMenteesWithoutMentorByLocation(location);
	}

	public List<Mentee> filterMentees(boolean descendingOrder, int startPosition, int itemsNumber) {
		return menteeService.filterMentees(descendingOrder, startPosition, itemsNumber);
	}

	public Mentor updateMentor(Mentor entity) {
		return mentorService.update(entity);
	}

	public void deleteMentor(Mentor entity) {
		mentorService.delete(entity);
	}

	public void deleteMentor(Long id) {
		mentorService.delete(id);
	}

	public Mentor findMentorById(Long id) {
		return mentorService.findById(id);
	}

	public List<Mentor> findMentors() {
		return mentorService.findMentors();
	}

	public List<Mentor> getMentorsByMenteesAmount(int menteesAmount, boolean onlyActive) {
		return mentorService.getMentorsByMenteesAmount(menteesAmount, onlyActive);
	}
}
