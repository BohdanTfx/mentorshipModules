package com.epam.mentorship.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentorship.api.client.MentorshipProgramApiClient;
import com.epam.mentorship.api.model.dto.MentorshipProgramDto;
import com.epam.mentorship.model.MentorshipProgram;

@Controller
@RequestMapping(
        path = "/mentorship")
public class MentorshipProgramController {
    @Autowired
    private MentorshipProgramApiClient mentorshipProgramApiClient;

    @RequestMapping(
            method = RequestMethod.POST)
    public String createMentorshipProgram(
            @RequestBody @Valid final MentorshipProgramDto mentorshipProgramDto,
            final BindingResult bindingResult, final Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "mentorshipProgram";
        }

        MentorshipProgram mentorshipProgram = mentorshipProgramApiClient
                .createMentorshipProgram(mentorshipProgramDto);
        mentorshipProgram.getParticipants().size();
        model.addAttribute("mentorshipProgram", mentorshipProgram);
        return "mentorshipProgram";
    }

    @RequestMapping(
            path = "/{id}", method = RequestMethod.POST)
    public String updateMentorshipProgram(@PathVariable final Long id,
            @RequestBody @Valid final MentorshipProgramDto mentorshipProgramDto,
            final BindingResult bindingResult, final Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("errors", bindingResult.getAllErrors());
            return "mentorshipProgram";
        }

        MentorshipProgram mentorshipProgram = mentorshipProgramApiClient
                .updateMentorshipProgram(id, mentorshipProgramDto);
        model.addAttribute("mentorshipProgram", mentorshipProgram);
        return "mentorshipProgram";
    }

    @RequestMapping(
            path = "/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable final Long id, final Model model) {
        MentorshipProgram mentorshipProgram = mentorshipProgramApiClient
                .findById(id);
        model.addAttribute("mentorshipProgram", mentorshipProgram);
        return "mentorshipProgram";
    }
}
