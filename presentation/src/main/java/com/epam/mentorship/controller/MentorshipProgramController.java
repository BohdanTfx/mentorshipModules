package com.epam.mentorship.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.epam.mentorship.model.MentorshipProgram;
import com.epam.mentorship.model.User;
import com.epam.mentorship.model.dto.ApiResponse;
import com.epam.mentorship.model.dto.MentorshipProgramDto;
import com.epam.mentorship.service.MentorshipProgramService;
import com.epam.mentorship.service.UserService;
import com.epam.mentorship.util.DtoEntityConverter;

@Controller
@RequestMapping(path = "/api/mentorship", produces = { MediaType.APPLICATION_JSON_VALUE,
		MediaType.APPLICATION_XML_VALUE })
public class MentorshipProgramController {
	@Autowired
	private MentorshipProgramService mentorshipProgramService;
	@Autowired
	private UserService userService;
	@Autowired
	private DtoEntityConverter dtoEntityConverter;

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ApiResponse<MentorshipProgram>> createMentorshipProgram(
			@RequestBody @Valid MentorshipProgramDto mentorshipProgramDto, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return new ResponseEntity<>(new ApiResponse<>(null, bindingResult.getAllErrors()), HttpStatus.OK);
		}

		MentorshipProgram entity = dtoEntityConverter.convert(mentorshipProgramDto);
		return new ResponseEntity<>(new ApiResponse<>(mentorshipProgramService.save(entity), null), HttpStatus.OK);
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

	@RequestMapping(path = "/{programId}/participants/{userId}", method = RequestMethod.PUT)
	public ResponseEntity<ApiResponse<MentorshipProgram>> addParticipant(@PathVariable("programId") Long programId,
			@PathVariable("userId") Long userId) {

		MentorshipProgram entity = mentorshipProgramService.findById(programId);
		if (entity == null) {
			return new ResponseEntity<ApiResponse<MentorshipProgram>>(HttpStatus.BAD_REQUEST);
		}
		User user = userService.findById(userId);
		if (user == null) {
			return new ResponseEntity<ApiResponse<MentorshipProgram>>(HttpStatus.BAD_REQUEST);
		}

		List<User> participants = entity.getParticipants();
		if (participants == null) {
			participants = new ArrayList<>();
		}

		participants.add(user);
		entity.setParticipants(participants);
		mentorshipProgramService.update(entity);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<MentorshipProgram> findById(@PathVariable Long id) {
		return new ResponseEntity<MentorshipProgram>(mentorshipProgramService.findById(id), HttpStatus.OK);
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
