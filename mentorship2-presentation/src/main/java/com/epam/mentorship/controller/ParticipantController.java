package com.epam.mentorship.controller;

import java.util.Date;
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

import com.epam.mentorship.api.client.ParticipantApiClient;
import com.epam.mentorship.api.model.dto.MenteeStateDto;
import com.epam.mentorship.enums.Location;

@Controller
@RequestMapping(
        path = "/mentorship/participants")
public class ParticipantController {
    @Autowired
    private ParticipantApiClient participantApiClient;

    @RequestMapping(
            path = "/{mentorshipProgramId}/mentor", method = RequestMethod.POST)
    public String createMentor(@PathVariable final Long mentorshipProgramId,
            @RequestParam final Long userId, final Model model) {
        model.addAttribute("mentor",
                participantApiClient.createMentor(mentorshipProgramId, userId));
        return "mentorProfile";
    }

    @RequestMapping(
            path = "/mentor/{id}", method = RequestMethod.GET)
    public String findMentor(@PathVariable final Long id, final Model model) {
        model.addAttribute("mentor", participantApiClient.findMentorById(id));
        return "mentorProfile";
    }

    @RequestMapping(
            path = "/mentor/{id}/mentees", method = RequestMethod.POST)
    public String addMentees(@PathVariable final Long id,
            @RequestParam final List<Long> menteesId, final Model model) {
        model.addAttribute("mentor",
                participantApiClient.addMentees(id, menteesId));
        return "mentorProfile";
    }

    @RequestMapping(
            path = "/mentor/{mentorId}/mentees/{menteeId}",
            method = RequestMethod.GET)
    public String removeMentees(@PathVariable final Long mentorId,
            @PathVariable final Long menteeId, final Model model) {
        model.addAttribute("mentor",
                participantApiClient.removeMentees(mentorId, menteeId));
        return "mentorProfile";
    }

    @RequestMapping(
            path = "/mentors", method = RequestMethod.GET)
    public String getMentorsByParams(@RequestParam final Integer menteesAmount,
            @RequestParam final Boolean onlyActive, final Model model) {
        model.addAttribute("mentors", participantApiClient
                .getMentorsByMenteesAmount(menteesAmount, onlyActive));
        return "mentorsList";
    }

    @RequestMapping(
            path = "mentee/{menteeId}", method = RequestMethod.GET)
    public String findMentee(@PathVariable final Long menteeId,
            final Model model) {
        model.addAttribute("mentee",
                participantApiClient.findMenteeById(menteeId));
        return "menteeProfile";
    }

    @RequestMapping(
            path = "{mentorshipProgramId}/mentee", method = RequestMethod.POST)
    public String createMentee(@PathVariable final Long mentorshipProgramId,
            @RequestParam final Long userId, final Model model) {
        model.addAttribute("mentee",
                participantApiClient.createMentee(mentorshipProgramId, userId));
        return "menteeProfile";
    }

    @RequestMapping(
            path = "mentee/{menteeId}", method = RequestMethod.POST)
    public String assignMentor(@PathVariable final Long menteeId,
            @RequestParam final Long mentorId, final Model model) {
        model.addAttribute("mentee",
                participantApiClient.assignMentor(menteeId, mentorId));
        return "menteeProfile";
    }

    @RequestMapping(
            path = "mentee/{menteeId}/state", method = RequestMethod.POST)
    public String changeMenteeState(@PathVariable final Long menteeId,
            @RequestBody final MenteeStateDto menteeStateDto,
            final Model model) {
        model.addAttribute("mentee", participantApiClient
                .changeMenteeState(menteeId, menteeStateDto));
        return "menteeProfile";
    }

    @RequestMapping(
            path = "mentees", method = RequestMethod.GET)
    public String findMenteesByLocation(@RequestParam final Location location,
            final Model model) {
        model.addAttribute("mentees", participantApiClient
                .findMenteesWithoutMentorByLocation(location));
        return "menteeList";
    }

    @RequestMapping(
            path = "mentees/filter", method = RequestMethod.GET)
    public String filterMentees(@RequestParam(
            required = false, defaultValue = "false") final Boolean desc,
            @RequestParam(
                    required = false, defaultValue = "0") final Integer start,
            @RequestParam(
                    required = false, defaultValue = "10") final Integer amount,
            final Model model) {
        model.addAttribute("mentees",
                participantApiClient.filterMentees(desc, start, amount));
        return "menteeList";
    }

    @RequestMapping(
            path = "statistic", method = RequestMethod.GET)
    public ResponseEntity<Double> findMenteesByLocation(@RequestParam(
            required = false) final Date startDate,
            @RequestParam(
                    required = false) final Date endDate,
            @RequestParam(
                    required = false) final Boolean successfullyFinished) {

        Double result = participantApiClient.getMenteesFinishStatistic(
                startDate, endDate, successfullyFinished);
        return ResponseEntity.ok(result);
    }
}
