package com.epam.mentorship.controller;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.mentorship.api.facade.ParticipantApiService;
import com.epam.mentorship.api.model.dto.MenteeStateDto;
import com.epam.mentorship.enums.Location;

@Controller
@RequestMapping(path = "/mentorship/participants")
public class ParticipantController {
	@Autowired
	private ParticipantApiService participantApiService;

	@RequestMapping(path = "/{mentorshipProgramId}/mentor", method = RequestMethod.POST)
	public String createMentor(@PathVariable Long mentorshipProgramId, @RequestParam Long userId, Model model) {
		model.addAttribute("mentor", participantApiService.createMentor(mentorshipProgramId, userId));
		return "mentorProfile";
	}

	@RequestMapping(path = "/mentor/{id}", method = RequestMethod.GET)
	public String findMentor(@PathVariable Long id, Model model) {
		model.addAttribute("mentor", participantApiService.findMentorById(id));
		return "mentorProfile";
	}

	@RequestMapping(path = "/mentor/{id}/mentees", method = RequestMethod.POST)
	public String addMentees(@PathVariable Long id, @RequestParam List<Long> menteesId, Model model) {
		model.addAttribute("mentor", participantApiService.addMentees(id, menteesId));
		return "mentorProfile";
	}

	@RequestMapping(path = "/mentor/{mentorId}/mentees/{menteeId}", method = RequestMethod.DELETE)
	public String removeMentees(@PathVariable Long mentorId, @PathVariable Long menteeId, Model model) {
		model.addAttribute("mentor", participantApiService.removeMentees(mentorId, menteeId));
		return "mentorProfile";
	}

	@RequestMapping(path = "/mentors", method = RequestMethod.GET)
	public String getMentorsByParams(@RequestParam Integer menteesAmount, @RequestParam Boolean onlyActive,
			Model model) {
		model.addAttribute("mentors", participantApiService.getMentorsByMenteesAmount(menteesAmount, onlyActive));
		return "mentorsList";
	}

	@RequestMapping(path = "mentee/{menteeId}", method = RequestMethod.GET)
	public String findMentee(@PathVariable Long menteeId, Model model) {
		model.addAttribute("mentee", participantApiService.findMenteeById(menteeId));
		return "menteeProfile";
	}

	@RequestMapping(path = "{mentorshipProgramId}/mentee", method = RequestMethod.POST)
	public String createMentee(@PathVariable Long mentorshipProgramId, @RequestParam Long userId, Model model) {
		model.addAttribute("mentee", participantApiService.createMentee(mentorshipProgramId, userId));
		return "menteeProfile";
	}

	@RequestMapping(path = "mentee/{menteeId}", method = RequestMethod.PUT)
	public String assignMentor(@PathVariable Long menteeId, @RequestParam Long mentorId, Model model) {
		model.addAttribute("mentee", participantApiService.assignMentor(menteeId, mentorId));
		return "menteeProfile";
	}

	@RequestMapping(path = "mentee/{menteeId}/state", method = RequestMethod.PUT)
	public String changeMenteeState(@PathVariable Long menteeId, @RequestBody MenteeStateDto menteeStateDto,
			Model model) {
		model.addAttribute("mentee", participantApiService.changeMenteeState(menteeId, menteeStateDto));
		return "menteeProfile";
	}

	@RequestMapping(path = "mentees", method = RequestMethod.GET)
	public String findMenteesByLocation(@RequestParam Location location, Model model) {
		model.addAttribute("mentees", participantApiService.findMenteesWithoutMentorByLocation(location));
		return "menteeList";
	}

	@RequestMapping(path = "mentees/filter", method = RequestMethod.GET)
	public String filterMentees(@RequestParam(required = false, defaultValue = "false") Boolean desc,
			@RequestParam(required = false, defaultValue = "0") Integer start,
			@RequestParam(required = false, defaultValue = "10") Integer amount, Model model) {
		model.addAttribute("mentees", participantApiService.filterMentees(desc, start, amount));
		return "menteeList";
	}

	@RequestMapping(path = "statistic", method = RequestMethod.GET)
	public ResponseEntity<Double> findMenteesByLocation(@RequestParam(required = false) Date startDate,
			@RequestParam(required = false) Date endDate,
			@RequestParam(required = false) Boolean successfullyFinished) {
		startDate = startDate == null ? new GregorianCalendar(1990, 1, 1).getTime() : startDate;
		endDate = endDate == null ? new Date() : endDate;
		successfullyFinished = successfullyFinished == null ? true : successfullyFinished;

		Double result = participantApiService.getMenteesFinishStatistic(startDate, endDate, successfullyFinished);
		return ResponseEntity.ok(result);
	}
}
