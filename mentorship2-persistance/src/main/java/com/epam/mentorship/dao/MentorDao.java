package com.epam.mentorship.dao;

import java.util.List;

import com.epam.mentorship.model.Mentor;

public interface MentorDao extends GenericDao<Mentor, Long> {
	List<Mentor> getMentorsByMenteesAmount(int menteesAmount, boolean onlyActive);
}