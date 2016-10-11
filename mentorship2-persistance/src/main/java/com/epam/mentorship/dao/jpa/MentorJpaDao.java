package com.epam.mentorship.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import com.epam.mentorship.dao.MentorDao;
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
						+ " m where size(m.mentees) > :menteesAmount and m.mentees.active = :onlyActive", Mentor.class)
				.setParameter("menteesAmount", menteesAmount).setParameter("onlyActive", onlyActive);
		return query.getResultList();
	}

}