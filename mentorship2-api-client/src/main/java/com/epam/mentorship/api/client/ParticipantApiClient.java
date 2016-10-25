package com.epam.mentorship.api.client;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.epam.mentorship.api.client.annotation.ApiClient;
import com.epam.mentorship.api.model.dto.MenteeStateDto;
import com.epam.mentorship.enums.Location;
import com.epam.mentorship.model.Mentee;
import com.epam.mentorship.model.Mentor;
import com.epam.mentorship.service.MenteeService;
import com.epam.mentorship.service.MentorService;
import com.epam.mentorship.service.MentorshipProgramService;
import com.epam.mentorship.service.UserService;

@ApiClient
public class ParticipantApiClient {
    private static final Integer DEFAULT_START_YEAR = 1990;
    @Autowired
    private MentorService mentorService;
    @Autowired
    private MenteeService menteeService;
    @Autowired
    private UserService userService;
    @Autowired
    private MentorshipProgramService mentorshipProgramService;

    public Mentor createMentor(final Long mentorshipProgramId,
            final Long userId) {
        Mentor mentor = new Mentor();
        mentor.setUser(userService.findById(userId));
        mentor.setMentorshipProgram(
                mentorshipProgramService.findById(mentorshipProgramId));
        return mentorService.create(mentor);
    }

    @Transactional
    public Mentor addMentees(final Long id, final List<Long> menteesId) {
        Mentor mentor = mentorService.findById(id);
        List<Mentee> mentees = menteeService.getMenteesFromIds(menteesId);
        setMentor(mentor, mentees);
        if (mentor.getMentees() != null) {
            mentor.getMentees().addAll(mentees);
        } else {
            mentor.setMentees(mentees);
        }
        return mentorService.update(mentor);
    }

    private void setMentor(final Mentor mentor, final List<Mentee> mentees) {
        for (Mentee mentee : mentees) {
            mentee.setMentor(mentor);
        }
    }

    @Transactional
    public Mentor removeMentees(final Long mentorId, final Long menteeId) {
        Mentor mentor = mentorService.findById(mentorId);
        List<Mentee> mentees = mentor.getMentees();
        for (Iterator<Mentee> iterator = mentees.iterator(); iterator
                .hasNext();) {
            Mentee mentee = iterator.next();
            if (Long.compare(mentee.getId(), menteeId) == 0) {
                iterator.remove();
                mentee.setMentor(null);
                menteeService.update(mentee);
            }
        }

        return mentorService.update(mentor);
    }

    public Mentee createMentee(final Long mentorshipProgramId,
            final Long userId) {
        Mentee mentee = new Mentee();
        mentee.setUser(userService.findById(userId));
        mentee.setMentorshipProgram(
                mentorshipProgramService.findById(mentorshipProgramId));

        return menteeService.create(mentee);
    }

    @Transactional
    public Mentee assignMentor(final Long menteeId, final Long mentorId) {
        Mentee mentee = menteeService.findById(menteeId);
        mentee.setMentor(mentorService.findById(mentorId));

        return menteeService.update(mentee);
    }

    public Mentee changeMenteeState(final Long menteeId,
            final MenteeStateDto menteeStateDto) {
        Mentee mentee = menteeService.findById(menteeId);
        if (menteeStateDto.getActive() != null) {
            mentee.setActive(menteeStateDto.getActive());
        }
        if (menteeStateDto.getStart() != null && menteeStateDto.getStart()) {
            mentee.setStarted(true);
            mentee.setStartedDate(new Date());
        }
        if (menteeStateDto.getEnd() != null && menteeStateDto.getEnd()) {
            mentee.setFinished(true);
            mentee.setEndDate(new Date());
        }

        return menteeService.update(mentee);
    }

    public Double getMenteesFinishStatistic(final Date startDate,
            final Date endDate, final Boolean successfullyFinished) {
        Date newStartDate = startDate == null
                ? new GregorianCalendar(DEFAULT_START_YEAR, 1, 1).getTime()
                : startDate;
        Date newEndDate = endDate == null ? new Date() : endDate;
        boolean newSuccessfullyFinished = successfullyFinished == null;

        return menteeService.getFinishStatistic(newStartDate, newEndDate,
                newSuccessfullyFinished);
    }

    public Mentee updateMentee(final Mentee entity) {
        return menteeService.update(entity);
    }

    public void deleteMentee(final Mentee entity) {
        menteeService.delete(entity);
    }

    public void deleteMentee(final Long id) {
        menteeService.delete(id);
    }

    public Mentee findMenteeById(final Long id) {
        return menteeService.findById(id);
    }

    public List<Mentee> findMentees() {
        return menteeService.findMentees();
    }

    public List<Mentee> findMenteesWithoutMentorByLocation(
            final Location location) {
        return menteeService.findMenteesWithoutMentorByLocation(location);
    }

    public List<Mentee> filterMentees(final boolean descendingOrder,
            final int startPosition, final int itemsNumber) {
        return menteeService.filterMentees(descendingOrder, startPosition,
                itemsNumber);
    }

    public Mentor updateMentor(final Mentor entity) {
        return mentorService.update(entity);
    }

    public void deleteMentor(final Mentor entity) {
        mentorService.delete(entity);
    }

    public void deleteMentor(final Long id) {
        mentorService.delete(id);
    }

    public Mentor findMentorById(final Long id) {
        return mentorService.findById(id);
    }

    public List<Mentor> findMentors() {
        return mentorService.findMentors();
    }

    public List<Mentor> getMentorsByMenteesAmount(final int menteesAmount,
            final boolean onlyActive) {
        return mentorService.getMentorsByMenteesAmount(menteesAmount,
                onlyActive);
    }
}
