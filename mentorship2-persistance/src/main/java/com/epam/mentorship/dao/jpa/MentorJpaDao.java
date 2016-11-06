package com.epam.mentorship.dao.jpa;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.epam.mentorship.dao.MentorDao;
import com.epam.mentorship.model.Mentor;

@Repository
public class MentorJpaDao extends GenericJpaDao<Mentor, Long>
        implements MentorDao {
    private static final long serialVersionUID = 8253199488344079950L;

    public MentorJpaDao() {
        super(Mentor.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Mentor> getMentorsByMenteesAmount(final int menteesAmount,
            final boolean onlyActive) {
        Query query = getEntityManager()
                .createQuery(
                        "Select m from " + getPersistanceClass().getSimpleName()
                                + " m join fetch m.mentees mentee where "
                                + "size(m.mentees) > :menteesAmount and "
                                + "mentee.active = :onlyActive",
                        Mentor.class)
                .setParameter("menteesAmount", menteesAmount)
                .setParameter("onlyActive", onlyActive);
        return query.getResultList();
    }

}
