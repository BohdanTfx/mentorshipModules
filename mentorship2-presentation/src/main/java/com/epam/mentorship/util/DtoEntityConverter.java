package com.epam.mentorship.util;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.epam.mentorship.model.MentorshipProgram;
import com.epam.mentorship.model.User;
import com.epam.mentorship.model.dto.MentorshipProgramDto;
import com.epam.mentorship.model.dto.UserDto;
import com.epam.mentorship.service.UserService;

@Component
public class DtoEntityConverter {
	private ModelMapper mapper = new ModelMapper();
	
	@Autowired
	private UserService userService;

	public User convert(UserDto userDto) {
		return mapper.map(userDto, User.class);
	}
	
	public MentorshipProgram convert(MentorshipProgramDto mentorshipProgramDto) {
		MentorshipProgram mentorshipProgram = new MentorshipProgram();
		mentorshipProgram.setLocation(mentorshipProgramDto.getLocation());
		mentorshipProgram.setTechnology(mentorshipProgramDto.getTechnology());
		mentorshipProgram.setTitle(mentorshipProgramDto.getTitle());
		mentorshipProgram.setHead(userService.findById(mentorshipProgramDto.getHeadId()));
		return mentorshipProgram;
	}
}
