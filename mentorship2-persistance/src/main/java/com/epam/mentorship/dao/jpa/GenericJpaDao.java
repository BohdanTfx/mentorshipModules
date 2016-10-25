package com.epam.mentorship.dao.jpa;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.transaction.annotation.Transactional;

import com.epam.mentorship.aspect.annotation.Loggable;
import com.epam.mentorship.dao.GenericDao;
import com.epam.mentorship.model.BaseEntity;

@Loggable
@Transactional
public class GenericJpaDao<T extends BaseEntity<ID>, ID extends Serializable>
        implements GenericDao<T, ID> {
    private static final long serialVersionUID = 1L;

    @PersistenceContext
    private EntityManager entityManager;

    private Class<T> persistanceClass;

    public GenericJpaDao(final Class<T> persistanceClass) {
        this.persistanceClass = persistanceClass;
    }

    @Override
    public T save(final T entity) {
        getEntityManager().persist(entity);
        return entity;
    }

    @Override
    public T update(final T entity) {
        return getEntityManager().merge(entity);
    }

    @Override
    public void delete(final T entity) {
        getEntityManager().remove(entity);
    }

    @Override
    public T getById(final ID id) {
        return getEntityManager().find(getPersistanceClass(), id);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<T> getAll() {
        return getEntityManager()
                .createQuery("select x from "
                        + getPersistanceClass().getSimpleName() + " x")
                .getResultList();
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected Class<T> getPersistanceClass() {
        return persistanceClass;
    }
}
