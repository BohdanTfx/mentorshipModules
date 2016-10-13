package com.epam.mentorship.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentorship.dao.MenteeDao;
import com.epam.mentorship.enums.Location;
import com.epam.mentorship.model.Mentee;
import com.epam.mentorship.service.MenteeService;

@Service
public class MenteeServiceImpl implements MenteeService {

	@Autowired
	private MenteeDao menteeDao;

	@Override
	public Mentee create(Mentee entity) {
		return menteeDao.save(entity);
	}

	@Override
	public Mentee update(Mentee entity) {
		return menteeDao.update(entity);
	}

	@Override
	public void delete(Mentee entity) {
		menteeDao.delete(entity);
	}

	@Override
	public void delete(Long id) {
		menteeDao.delete(menteeDao.getById(id));
	}

	@Override
	public Mentee findById(Long id) {
		return menteeDao.getById(id);
	}

	@Override
	public List<Mentee> findMentees() {
		return menteeDao.getAll();
	}

	@Override
	public List<Mentee> findMenteesWithoutMentorByLocation(Location location) {
		return menteeDao.getMenteesWithoutMentorByLocation(location);
	}

	@Override
	public List<Mentee> filterMentees(boolean descendingOrder, int startPosition, int itemsNumber) {
		return menteeDao.filterMentees(descendingOrder, startPosition, itemsNumber);
	}

	@Override
	public Double getFinishStatistic(Date startDate, Date endDate, boolean successfullyFinished) {
		return menteeDao.getFinishStatistic(startDate, endDate, successfullyFinished);
	}

	@Override
	@Transactional
	public List<Mentee> getMenteesFromIds(List<Long> menteesIds) {
		List<Mentee> mentees = new ArrayList<>();
		for (Long id : menteesIds) {
			mentees.add(findById(id));
		}
		return mentees;
	}
}