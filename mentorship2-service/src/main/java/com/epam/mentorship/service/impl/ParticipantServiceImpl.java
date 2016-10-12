package com.epam.mentorship.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentorship.dao.MenteeDao;
import com.epam.mentorship.dao.MentorDao;
import com.epam.mentorship.enums.Location;
import com.epam.mentorship.model.Mentee;
import com.epam.mentorship.model.Mentor;
import com.epam.mentorship.service.ParticipantService;

@Service
public class ParticipantServiceImpl implements ParticipantService {

	@Autowired
	private MenteeDao menteeDao;

	@Autowired
	private MentorDao mentorDao;

	@Override
	public List<Mentor> findMentorsByMenteesAmount(int menteesAmount, boolean onlyActive) {
		return mentorDao.getMentorsByMenteesAmount(menteesAmount, onlyActive);
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

}
