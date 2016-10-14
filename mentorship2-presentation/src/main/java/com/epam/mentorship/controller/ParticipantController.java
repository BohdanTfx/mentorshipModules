package com.epam.mentorship.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.mentorship.model.Mentee;
import com.epam.mentorship.model.Mentor;
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
}
