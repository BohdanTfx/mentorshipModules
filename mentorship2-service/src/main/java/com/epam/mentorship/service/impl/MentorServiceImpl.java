package com.epam.mentorship.service.impl;

import java.util.List;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentorship.dao.MentorDao;
import com.epam.mentorship.model.Mentor;
import com.epam.mentorship.service.MentorService;

@Service
public class MentorServiceImpl implements MentorService {

	@Autowired
	private MentorDao mentorDao;

	@Override
	public Mentor create(Mentor entity) {
		return mentorDao.save(entity);
	}

	@Override
	public Mentor update(Mentor entity) {
		return mentorDao.update(entity);
	}

	@Override
	public void delete(Mentor entity) {
		mentorDao.delete(entity);
	}

	@Override
	public void delete(Long id) {
		mentorDao.delete(mentorDao.getById(id));
	}

	@Override
	@Transactional
	public Mentor findById(Long id) {
		Mentor mentor = mentorDao.getById(id);
		Hibernate.initialize(mentor.getMentees());
		return mentor;
	}

	@Override
	public List<Mentor> findMentors() {
		return mentorDao.getAll();
	}

	@Override
	public List<Mentor> getMentorsByMenteesAmount(int menteesAmount, boolean onlyActive) {
		return mentorDao.getMentorsByMenteesAmount(menteesAmount, onlyActive);
	}

}
