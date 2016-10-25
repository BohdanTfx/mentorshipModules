package com.epam.mentorship.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentorship.api.client.MentorshipProgramApiClient;
import com.epam.mentorship.api.model.dto.ApiResponse;
import com.epam.mentorship.api.model.dto.MentorshipProgramDto;
import com.epam.mentorship.model.MentorshipProgram;

@Controller
@RequestMapping(
        path = "/api/mentorship")
public class MentorshipProgramController {
    @Autowired
    private MentorshipProgramApiClient mentorshipProgramApiClient;

    @RequestMapping(
            method = RequestMethod.POST)
    public ApiResponse<MentorshipProgram> createMentorshipProgram(
            @RequestBody @Valid final MentorshipProgramDto mentorshipProgramDto,
            final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ApiResponse<>(bindingResult.getAllErrors());
        }

        MentorshipProgram mentorshipProgram = mentorshipProgramApiClient
                .createMentorshipProgram(mentorshipProgramDto);
        return new ApiResponse<>(mentorshipProgram);
    }

    @RequestMapping(
            path = "/{id}", method = RequestMethod.POST)
    public ApiResponse<MentorshipProgram> updateMentorshipProgram(
            @PathVariable final Long id,
            @RequestBody @Valid final MentorshipProgramDto mentorshipProgramDto,
            final BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ApiResponse<>(bindingResult.getAllErrors());
        }

        return new ApiResponse<>(mentorshipProgramApiClient
                .updateMentorshipProgram(id, mentorshipProgramDto));
    }

    @RequestMapping(
            path = "/{id}", method = RequestMethod.GET)
    public ApiResponse<MentorshipProgram> findById(
            @PathVariable final Long id) {
        return new ApiResponse<>(mentorshipProgramApiClient.findById(id));
    }
}
