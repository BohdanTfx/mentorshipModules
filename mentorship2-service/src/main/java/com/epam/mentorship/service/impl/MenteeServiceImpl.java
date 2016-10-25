package com.epam.mentorship.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentorship.dao.MenteeDao;
import com.epam.mentorship.enums.Location;
import com.epam.mentorship.model.Mentee;
import com.epam.mentorship.service.MenteeService;

@Service
public class MenteeServiceImpl implements MenteeService {

    @Autowired
    private MenteeDao menteeDao;

    @Override
    public Mentee create(final Mentee entity) {
        return menteeDao.save(entity);
    }

    @Override
    public Mentee update(final Mentee entity) {
        return menteeDao.update(entity);
    }

    @Override
    public void delete(final Mentee entity) {
        menteeDao.delete(entity);
    }

    @Override
    public void delete(final Long id) {
        menteeDao.delete(menteeDao.getById(id));
    }

    @Override
    public Mentee findById(final Long id) {
        return menteeDao.getById(id);
    }

    @Override
    public List<Mentee> findMentees() {
        return menteeDao.getAll();
    }

    @Override
    public List<Mentee> findMenteesWithoutMentorByLocation(
            final Location location) {
        return menteeDao.getMenteesWithoutMentorByLocation(location);
    }

    @Override
    public List<Mentee> filterMentees(final boolean descendingOrder,
            final int startPosition, final int itemsNumber) {
        return menteeDao.filterMentees(descendingOrder, startPosition,
                itemsNumber);
    }

    @Override
    public Double getFinishStatistic(final Date startDate, final Date endDate,
            final boolean successfullyFinished) {
        return menteeDao.getFinishStatistic(startDate, endDate,
                successfullyFinished);
    }

    @Override
    public List<Mentee> getMenteesFromIds(final List<Long> menteesIds) {
        List<Mentee> mentees = new ArrayList<>();
        for (Long id : menteesIds) {
            mentees.add(findById(id));
        }
        return mentees;
    }
}
