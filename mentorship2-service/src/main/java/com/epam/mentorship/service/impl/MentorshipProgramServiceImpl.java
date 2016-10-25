package com.epam.mentorship.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentorship.dao.MentorshipProgramDao;
import com.epam.mentorship.model.Mentor;
import com.epam.mentorship.model.MentorshipProgram;
import com.epam.mentorship.model.Participant;
import com.epam.mentorship.service.MentorshipProgramService;

@Service
public class MentorshipProgramServiceImpl implements MentorshipProgramService {
    @Autowired
    private MentorshipProgramDao mentorshipProgramDao;

    @Override
    public MentorshipProgram save(final MentorshipProgram entity) {
        return mentorshipProgramDao.save(entity);
    }

    @Override
    public MentorshipProgram update(final MentorshipProgram entity) {
        return mentorshipProgramDao.update(entity);
    }

    @Override
    public void delete(final MentorshipProgram mentorshipProgram) {
        mentorshipProgramDao.delete(mentorshipProgram);
    }

    @Override
    public void delete(final Long id) {
        mentorshipProgramDao.delete(mentorshipProgramDao.getById(id));
    }

    @Override
    @Transactional
    public MentorshipProgram findById(final Long id) {
        MentorshipProgram mentorshipProgram = mentorshipProgramDao.getById(id);
        for (Participant participant : mentorshipProgram.getParticipants()) {
            if (participant instanceof Mentor) {
                Hibernate.initialize(((Mentor) participant).getMentees());
            }
        }
        return mentorshipProgram;
    }

    @Override
    public List<MentorshipProgram> findMentorshipPrograms() {
        return mentorshipProgramDao.getAll();
    }
}
