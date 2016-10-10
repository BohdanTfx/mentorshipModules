package com.epam.mentorship.dao.jpa;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Query;

import com.epam.mentorship.dao.MentorDao;
import com.epam.mentorship.model.Mentee;
import com.epam.mentorship.model.Mentor;

public class MentorJpaDao extends GenericJpaDao<Mentor, Long> implements MentorDao {
	private static final long serialVersionUID = 8253199488344079950L;

	public MentorJpaDao() {
		super(Mentor.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Mentor> getMentorsByMenteesAmount(int menteesAmount, boolean onlyActive) {
		Query query = getEntityManager()
				.createQuery("Select m from " + getPersistanceClass().getSimpleName()
						+ " m where size(m.mentees) > :menteesAmount", Mentor.class)
				.setParameter("menteesAmount", menteesAmount);
		List<Mentor> mentors = query.getResultList();
		return mentors.stream().filter(m -> {
			for (Mentee mentee : m.getMentees()) {
				if (Boolean.compare(onlyActive, mentee.isActive()) != 0) {
					return false;
				}
			}

			return true;
		}).collect(Collectors.toList());
	}

}