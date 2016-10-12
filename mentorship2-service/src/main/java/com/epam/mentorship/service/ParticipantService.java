package com.epam.mentorship.service;

import java.util.Date;
import java.util.List;

import com.epam.mentorship.enums.Location;
import com.epam.mentorship.model.Mentee;
import com.epam.mentorship.model.Mentor;

public interface ParticipantService {
	List<Mentor> findMentorsByMenteesAmount(int menteesAmount, boolean onlyActive);

	List<Mentee> findMenteesWithoutMentorByLocation(Location location);

	List<Mentee> filterMentees(boolean descendingOrder, int startPosition, int itemsNumber);

	Double getFinishStatistic(Date startDate, Date endDate, boolean successfullyFinished);
}
