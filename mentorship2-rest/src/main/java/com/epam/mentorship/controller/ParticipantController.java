package com.epam.mentorship.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.epam.mentorship.api.client.ParticipantApiClient;
import com.epam.mentorship.api.model.dto.ApiResponse;
import com.epam.mentorship.api.model.dto.MenteeStateDto;
import com.epam.mentorship.enums.Location;
import com.epam.mentorship.model.Mentee;
import com.epam.mentorship.model.Mentor;

@Controller
@RequestMapping(
        path = "/api/mentorship/participants")
public class ParticipantController {
    @Autowired
    private ParticipantApiClient participantApiClient;

    @RequestMapping(
            path = "/{mentorshipProgramId}/mentor", method = RequestMethod.POST)
    public ApiResponse<Mentor> createMentor(
            @PathVariable final Long mentorshipProgramId,
            @RequestParam final Long userId) {
        return new ApiResponse<>(
                participantApiClient.createMentor(mentorshipProgramId, userId));
    }

    @RequestMapping(
            path = "/mentor/{id}", method = RequestMethod.GET)
    public ApiResponse<Mentor> findMentor(@PathVariable final Long id) {
        return new ApiResponse<>(participantApiClient.findMentorById(id));
    }

    @RequestMapping(
            path = "/mentor/{id}/mentees", method = RequestMethod.POST)
    public ApiResponse<Mentor> addMentees(@PathVariable final Long id,
            @RequestParam final List<Long> menteesId) {
        return new ApiResponse<>(
                participantApiClient.addMentees(id, menteesId));
    }

    @RequestMapping(
            path = "/mentor/{mentorId}/mentees/{menteeId}",
            method = RequestMethod.DELETE)
    public ApiResponse<Mentor> removeMentees(@PathVariable final Long mentorId,
            @PathVariable final Long menteeId) {
        return new ApiResponse<>(
                participantApiClient.removeMentees(mentorId, menteeId));
    }

    @RequestMapping(
            path = "/mentors", method = RequestMethod.GET)
    public ApiResponse<List<Mentor>> getMentorsByParams(
            @RequestParam final Integer menteesAmount,
            @RequestParam final Boolean onlyActive) {
        return new ApiResponse<>(participantApiClient
                .getMentorsByMenteesAmount(menteesAmount, onlyActive));
    }

    @RequestMapping(
            path = "mentee/{menteeId}", method = RequestMethod.GET)
    public ApiResponse<Mentee> findMentee(@PathVariable final Long menteeId) {
        return new ApiResponse<>(participantApiClient.findMenteeById(menteeId));
    }

    @RequestMapping(
            path = "{mentorshipProgramId}/mentee", method = RequestMethod.POST)
    public ApiResponse<Mentee> createMentee(
            @PathVariable final Long mentorshipProgramId,
            @RequestParam final Long userId) {
        return new ApiResponse<>(
                participantApiClient.createMentee(mentorshipProgramId, userId));
    }

    @RequestMapping(
            path = "mentee/{menteeId}", method = RequestMethod.PUT)
    public ApiResponse<Mentee> assignMentor(@PathVariable final Long menteeId,
            @RequestParam final Long mentorId) {
        return new ApiResponse<>(
                participantApiClient.assignMentor(menteeId, mentorId));
    }

    @RequestMapping(
            path = "mentee/{menteeId}/state", method = RequestMethod.PUT)
    public ApiResponse<Mentee> changeMenteeState(
            @PathVariable final Long menteeId,
            @RequestBody final MenteeStateDto menteeStateDto,
            final Model model) {
        return new ApiResponse<>(participantApiClient
                .changeMenteeState(menteeId, menteeStateDto));
    }

    @RequestMapping(
            path = "mentees", method = RequestMethod.GET)
    public ApiResponse<List<Mentee>> findMenteesByLocation(
            @RequestParam final Location location) {
        return new ApiResponse<>(participantApiClient
                .findMenteesWithoutMentorByLocation(location));
    }

    @RequestMapping(
            path = "mentees/filter", method = RequestMethod.GET)
    public ApiResponse<List<Mentee>> filterMentees(@RequestParam(
            required = false, defaultValue = "false") final Boolean desc,
            @RequestParam(
                    required = false, defaultValue = "0") final Integer start,
            @RequestParam(
                    required = false,
                    defaultValue = "10") final Integer amount) {
        return new ApiResponse<>(
                participantApiClient.filterMentees(desc, start, amount));
    }

    @RequestMapping(
            path = "statistic", method = RequestMethod.GET)
    public ApiResponse<Double> findMenteesByLocation(@RequestParam(
            required = false) final Date startDate,
            @RequestParam(
                    required = false) final Date endDate,
            @RequestParam(
                    required = false) final Boolean successfullyFinished) {

        return new ApiResponse<>(participantApiClient.getMenteesFinishStatistic(
                startDate, endDate, successfullyFinished));
    }
}
