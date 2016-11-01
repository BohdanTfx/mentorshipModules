package com.epam.mentorship.dao;

import java.io.Serializable;
import java.util.List;

import com.epam.mentorship.model.BaseEntity;

public interface GenericDao<T extends BaseEntity<ID>, ID extends Serializable>
        extends Serializable {

    T save(T entity);

    T update(T entity);

    void delete(T entity);

    T getById(ID id);

    List<T> getAll();
}
