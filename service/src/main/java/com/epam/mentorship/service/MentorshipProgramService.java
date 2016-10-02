package com.epam.mentorship.service;

import java.util.List;

import com.epam.mentorship.model.MentorshipProgram;

public interface MentorshipProgramService {
	MentorshipProgram save(MentorshipProgram entity);

	MentorshipProgram update(MentorshipProgram entity);

	void delete(Long id);

	MentorshipProgram findById(Long id);

	List<MentorshipProgram> findMentorshipPrograms();
}
