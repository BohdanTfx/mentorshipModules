package com.epam.mentorship.dao;

import java.util.Date;
import java.util.List;

import com.epam.mentorship.enums.Location;
import com.epam.mentorship.model.Mentee;

public interface MenteeDao extends GenericDao<Mentee, Long> {
    List<Mentee> getMenteesWithoutMentorByLocation(Location location);

    List<Mentee> filterMentees(boolean descendingOrder, int startPosition,
            int itemsNumber);

    Double getFinishStatistic(Date startDate, Date endDate,
            boolean successfullyFinished);
}
