package com.epam.mentorship.dao.jpa;

import java.util.Date;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.epam.mentorship.dao.MenteeDao;
import com.epam.mentorship.enums.Location;
import com.epam.mentorship.model.Mentee;

public class MenteeJpaDao extends GenericJpaDao<Mentee, Long> implements MenteeDao {
	private static final long serialVersionUID = 7053996539111610993L;

	public MenteeJpaDao() {
		super(Mentee.class);
	}

	@Override
	public List<Mentee> getMenteesWithoutMentorByLocation(Location location) {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Mentee> query = builder.createQuery(Mentee.class);
		Root<Mentee> root = query.from(Mentee.class);
		query.select(root)
				.where(builder.and(builder.equal(root.get("mentorshipProgram").get("location"), location), builder.isNull(root.get("mentor"))));
		
		return getEntityManager().createQuery(query).getResultList();
	}

	@Override
	public List<Mentee> filterMentees(boolean descendingOrder, int startPosition, int itemsNumber) {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Mentee> query = builder.createQuery(Mentee.class);
		Root<Mentee> root = query.from(Mentee.class);
		query.select(root).orderBy(builder.desc(root.get("mentorshipDuration")));
		return getEntityManager().createQuery(query).setFirstResult(startPosition).setMaxResults(itemsNumber)
				.getResultList();
	}

	@Override
	public Double getFinishStatistic(Date startDate, Date endDate, boolean successfullyFinished) {
		CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> queryForFiltering = builder.createQuery(Long.class);
		Root<Mentee> filteredRoot = queryForFiltering.from(Mentee.class);
		queryForFiltering.select(builder.countDistinct(filteredRoot))
				.where(builder.and(builder.between(filteredRoot.<Date>get("endDate"), startDate, endDate),
						builder.equal(filteredRoot.get("successfullyFinished"), successfullyFinished)));
		Long filteredMenteesCount = getEntityManager().createQuery(queryForFiltering).getSingleResult();

		CriteriaQuery<Long> queryForCountAll = builder.createQuery(Long.class);
		Root<Mentee> allRoot = queryForCountAll.from(Mentee.class);
		queryForCountAll.select(builder.countDistinct(allRoot));
		Long allMenteesCount = getEntityManager().createQuery(queryForCountAll).getSingleResult();
		return filteredMenteesCount / (double) allMenteesCount;
	}
}