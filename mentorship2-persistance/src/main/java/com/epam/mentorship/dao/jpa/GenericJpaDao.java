package com.epam.mentorship.dao.jpa;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.epam.mentorship.aspect.annotation.Loggable;
import com.epam.mentorship.dao.GenericDao;
import com.epam.mentorship.exception.DatabaseException;
import com.epam.mentorship.model.BaseEntity;

@Loggable
public class GenericJpaDao<T extends BaseEntity<ID>, ID extends Serializable> implements GenericDao<T, ID> {
	private static final long serialVersionUID = 1L;
	private Map<ID, T> database = new HashMap<>();

	@Override
	public T save(T entity) {
		database.putIfAbsent(entity.getId(), entity);
		return entity;
	}

	@Override
	public T update(T entity) {
		if (getById(entity.getId()) == null) {
			throw new DatabaseException("Entity doesn't exist");
		}
		database.put(entity.getId(), entity);
		return entity;
	}

	@Override
	public void delete(ID id) {
		T removed = database.remove(id);
		if (removed == null) {
			throw new DatabaseException("Entity doesn't exist");
		}
	}

	@Override
	public T getById(ID id) {
		return database.get(id);
	}

	@Override
	public List<T> getAll() {
		return database.entrySet().stream().map(Map.Entry::getValue).collect(Collectors.toList());
	}

}
