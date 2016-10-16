package com.epam.mentorship.controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.mentorship.enums.Location;
import com.epam.mentorship.model.Mentee;
import com.epam.mentorship.model.Mentor;
import com.epam.mentorship.model.dto.MenteeStateDto;
import com.epam.mentorship.service.MenteeService;
import com.epam.mentorship.service.MentorService;
import com.epam.mentorship.service.MentorshipProgramService;
import com.epam.mentorship.service.UserService;

@Controller
@RequestMapping(path = "/api/mentorship/participants")
public class ParticipantController {
	@Autowired
	private MentorService mentorService;
	@Autowired
	private MenteeService menteeService;
	@Autowired
	private UserService userService;
	@Autowired
	private MentorshipProgramService mentorshipProgramService;

	@RequestMapping(path = "/{mentorshipProgramId}/mentor", method = RequestMethod.POST)
	public String createMentor(@PathVariable Long mentorshipProgramId, @RequestParam Long userId, Model model) {
		Mentor mentor = new Mentor();
		mentor.setUser(userService.findById(userId));
		mentor.setMentorshipProgram(mentorshipProgramService.findById(mentorshipProgramId));

		model.addAttribute("mentor", mentorService.create(mentor));
		return "mentorProfile";
	}

	@RequestMapping(path = "/mentor/{id}", method = RequestMethod.GET)
	public String findMentor(@PathVariable Long id, Model model) {
		Mentor mentor = mentorService.findById(id);
		model.addAttribute("mentor", mentor);
		return "mentorProfile";
	}

	@RequestMapping(path = "/mentor/{id}/mentees", method = RequestMethod.PUT)
	public String addMentees(@PathVariable Long id, @RequestParam List<Long> menteesId, Model model) {
		Mentor mentor = mentorService.findById(id);
		if (mentor.getMentees() != null) {
			mentor.getMentees().addAll(menteeService.getMenteesFromIds(menteesId));
		} else {
			mentor.setMentees(menteeService.getMenteesFromIds(menteesId));
		}
		model.addAttribute("mentor", mentorService.update(mentor));
		return "mentorProfile";
	}

	@RequestMapping(path = "/mentor/{mentorId}/mentees/{menteeId}", method = RequestMethod.DELETE)
	public String removeMentees(@PathVariable Long mentorId, @PathVariable Long menteeId, Model model) {
		Mentor mentor = mentorService.findById(mentorId);
		List<Mentee> mentees = mentor.getMentees();
		for (Iterator<Mentee> iterator = mentees.iterator(); iterator.hasNext();) {
			Mentee mentee = (Mentee) iterator.next();
			if (Long.compare(mentee.getId(), menteeId) == 0) {
				iterator.remove();
			}
		}

		model.addAttribute("mentor", mentorService.update(mentor));
		return "mentorProfile";
	}

	@RequestMapping(path = "/mentors", method = RequestMethod.GET)
	public String getMentorsByParams(@RequestParam Integer menteesAmount, @RequestParam Boolean onlyActive,
			Model model) {
		model.addAttribute("mentors", mentorService.getMentorsByMenteesAmount(menteesAmount, onlyActive));
		return "mentorsList";
	}

	@RequestMapping(path = "mentee/{menteeId}", method = RequestMethod.GET)
	public String findMentee(@PathVariable Long menteeId, Model model) {
		model.addAttribute("mentee", menteeService.findById(menteeId));
		return "menteeProfile";
	}

	@RequestMapping(path = "{mentorshipProgramId}/mentee", method = RequestMethod.POST)
	public String createMentee(@PathVariable Long mentorshipProgramId, @RequestParam Long userId, Model model) {
		Mentee mentee = new Mentee();
		mentee.setUser(userService.findById(userId));
		mentee.setMentorshipProgram(mentorshipProgramService.findById(mentorshipProgramId));

		model.addAttribute("mentee", menteeService.create(mentee));
		return "menteeProfile";
	}

	@RequestMapping(path = "mentee/{menteeId}", method = RequestMethod.PUT)
	public String assignMentor(@PathVariable Long menteeId, @RequestParam Long mentorId, Model model) {
		Mentee mentee = menteeService.findById(menteeId);
		mentee.setMentor(mentorService.findById(mentorId));

		model.addAttribute("mentee", menteeService.update(mentee));
		return "menteeProfile";
	}

	@RequestMapping(path = "mentee/{menteeId}/state", method = RequestMethod.PUT)
	public String changeMenteeState(@PathVariable Long menteeId, @RequestBody MenteeStateDto menteeStateDto,
			Model model) {
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

		model.addAttribute("mentee", menteeService.update(mentee));
		return "menteeProfile";
	}

	@RequestMapping(path = "mentees", method = RequestMethod.GET)
	public String findMenteesByLocation(@RequestParam Location location, Model model) {
		model.addAttribute("mentees", menteeService.findMenteesWithoutMentorByLocation(location));
		return "menteeList";
	}

	@RequestMapping(path = "mentees/filter", method = RequestMethod.GET)
	public String filterMentees(@RequestParam(required = false, defaultValue = "false") Boolean desc,
			@RequestParam(required = false, defaultValue = "0") Integer start,
			@RequestParam(required = false, defaultValue = "10") Integer amount, Model model) {
		model.addAttribute("mentees", menteeService.filterMentees(desc, start, amount));
		return "menteeList";
	}

	@RequestMapping(path = "statistic", method = RequestMethod.GET)
	public Double findMenteesByLocation(@RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate,
			@RequestParam(required = false) Boolean successfullyFinished) {
		startDate = startDate == null ? new GregorianCalendar(1990, 1, 1).getTime() : startDate;
		endDate = endDate == null ? new Date() : endDate;
		successfullyFinished = successfullyFinished == null ? true : successfullyFinished;

		Double result = menteeService.getFinishStatistic(startDate, endDate, successfullyFinished);
		return result;
	}
}
