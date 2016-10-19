package com.epam.mentorship.api.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.epam.mentorship.api.facade.annotation.ApiFacade;
import com.epam.mentorship.api.model.dto.MentorshipProgramDto;
import com.epam.mentorship.api.util.DtoEntityConverter;
import com.epam.mentorship.model.MentorshipProgram;
import com.epam.mentorship.service.MentorshipProgramService;
import com.epam.mentorship.service.UserService;

@ApiFacade
public class MentorshipProgramApiService {
	@Autowired
	private MentorshipProgramService mentorshipProgramService;
	@Autowired
	private UserService userService;
	@Autowired
	private DtoEntityConverter dtoEntityConverter;

	public MentorshipProgram createMentorshipProgram(MentorshipProgramDto mentorshipProgramDto) {
		MentorshipProgram mentorshipProgram = dtoEntityConverter.convert(mentorshipProgramDto);
		mentorshipProgram.setHead(userService.findById(mentorshipProgramDto.getHeadId()));
		return mentorshipProgramService.save(mentorshipProgram);
	}

	public MentorshipProgram updateMentorshipProgram(Long id, MentorshipProgramDto mentorshipProgramDto) {
		MentorshipProgram mentorshipProgram = mentorshipProgramService.findById(id);
		if (mentorshipProgram == null) {
			return null;
		}

		dtoEntityConverter.merge(mentorshipProgram, mentorshipProgramDto);
		if (mentorshipProgram.getHead() != null
				&& Long.compare(mentorshipProgram.getHead().getId(), mentorshipProgramDto.getHeadId()) != 0) {
			mentorshipProgram.setHead(userService.findById(mentorshipProgramDto.getHeadId()));
		}

		return mentorshipProgramService.update(mentorshipProgram);

	}

	public void delete(MentorshipProgram mentorshipProgram) {
		mentorshipProgramService.delete(mentorshipProgram);
	}

	public void delete(Long id) {
		mentorshipProgramService.delete(id);
	}

	public MentorshipProgram findById(Long id) {
		return mentorshipProgramService.findById(id);
	}

	public List<MentorshipProgram> findMentorshipPrograms() {
		return mentorshipProgramService.findMentorshipPrograms();
	}
}
