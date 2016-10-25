package com.epam.mentorship.service;

import java.util.Date;
import java.util.List;

import com.epam.mentorship.enums.Location;
import com.epam.mentorship.model.Mentee;

public interface MenteeService {
    Mentee create(Mentee entity);

    Mentee update(Mentee entity);

    void delete(Mentee entity);

    void delete(Long id);

    Mentee findById(Long id);

    List<Mentee> findMentees();

    List<Mentee> findMenteesWithoutMentorByLocation(Location location);

    List<Mentee> filterMentees(boolean descendingOrder, int startPosition,
            int itemsNumber);

    Double getFinishStatistic(Date startDate, Date endDate,
            boolean successfullyFinished);

    List<Mentee> getMenteesFromIds(List<Long> menteesId);
}
