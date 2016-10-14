package com.epam.mentorship.controller;

import java.util.List;

import javax.validation.Valid;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentorship.model.MentorshipProgram;
import com.epam.mentorship.model.dto.ApiResponse;
import com.epam.mentorship.model.dto.MentorshipProgramDto;
import com.epam.mentorship.service.MentorshipProgramService;
import com.epam.mentorship.util.DtoEntityConverter;

@Controller
@RequestMapping(path = "/api/mentorship")
public class MentorshipProgramController {
	@Autowired
	private MentorshipProgramService mentorshipProgramService;

	@Autowired
	private DtoEntityConverter dtoEntityConverter;

	@RequestMapping(method = RequestMethod.POST)
	public String createMentorshipProgram(@RequestBody @Valid MentorshipProgramDto mentorshipProgramDto,
			BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "mentorshipProgram";
		}

		MentorshipProgram entity = dtoEntityConverter.convert(mentorshipProgramDto);
		
		MentorshipProgram mentorshipProgram = mentorshipProgramService.save(entity);
		mentorshipProgram.getParticipants().size();
		model.addAttribute("mentorshipProgram", mentorshipProgram);
		return "mentorshipProgram";
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<ApiResponse<MentorshipProgram>> updateMentorshipProgram(@PathVariable Long id,
			@RequestBody @Valid MentorshipProgramDto mentorshipProgramDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(null, bindingResult.getAllErrors()), HttpStatus.OK);
		}

		MentorshipProgram entity = mentorshipProgramService.findById(id);
		if (entity == null) {
			return new ResponseEntity<ApiResponse<MentorshipProgram>>(HttpStatus.BAD_REQUEST);
		}
		entity = dtoEntityConverter.convert(mentorshipProgramDto);
		entity.setId(id);
		return new ResponseEntity<ApiResponse<MentorshipProgram>>(
				new ApiResponse<>(mentorshipProgramService.update(entity), null), HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public String findById(@PathVariable Long id, Model model) {
		MentorshipProgram mentorshipProgram = mentorshipProgramService.findById(id);
		model.addAttribute("mentorshipProgram", mentorshipProgram);
		return "mentorshipProgram";
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteMentorshipProgram(@PathVariable Long id) {
		mentorshipProgramService.delete(id);
		return ResponseEntity.ok().build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<MentorshipProgram>> findMentorshipPrograms() {
		return new ResponseEntity<List<MentorshipProgram>>(mentorshipProgramService.findMentorshipPrograms(),
				HttpStatus.OK);
	}
}
