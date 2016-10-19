package com.epam.mentorship.api.util;

import org.springframework.stereotype.Component;

import com.epam.mentorship.api.model.dto.MentorshipProgramDto;
import com.epam.mentorship.api.model.dto.UserDto;
import com.epam.mentorship.model.MentorshipProgram;
import com.epam.mentorship.model.User;

@Component
public class DtoEntityConverter {

	public User convert(UserDto userDto) {
		User user = new User();
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setDateOfBirth(userDto.getDateOfBirth());
		user.setJobTitle(userDto.getJobTitle());
		return user;
	}

	public User merge(User user, UserDto userDto) {
		user.setFirstName(userDto.getFirstName());
		user.setLastName(userDto.getLastName());
		user.setDateOfBirth(userDto.getDateOfBirth());
		user.setJobTitle(userDto.getJobTitle());
		return user;
	}

	public MentorshipProgram convert(MentorshipProgramDto mentorshipProgramDto) {
		MentorshipProgram mentorshipProgram = new MentorshipProgram();
		mentorshipProgram.setLocation(mentorshipProgramDto.getLocation());
		mentorshipProgram.setTechnology(mentorshipProgramDto.getTechnology());
		mentorshipProgram.setTitle(mentorshipProgramDto.getTitle());
		return mentorshipProgram;
	}

	public MentorshipProgram merge(MentorshipProgram mentorshipProgram, MentorshipProgramDto mentorshipProgramDto) {
		mentorshipProgram.setLocation(mentorshipProgramDto.getLocation());
		mentorshipProgram.setTechnology(mentorshipProgramDto.getTechnology());
		mentorshipProgram.setTitle(mentorshipProgramDto.getTitle());
		return mentorshipProgram;
	}
}
