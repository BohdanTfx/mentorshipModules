package com.epam.mentorship.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.epam.mentorship.dao.UserDao;
import com.epam.mentorship.model.User;
import com.epam.mentorship.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;
	private Long inc = 0L;
	
	public User save(User entity) {
		entity.setId(++inc);
		return userDao.save(entity);
	}

	public User update(User entity) {
		return userDao.update(entity);
	}

	public void delete(Long id) {
		userDao.delete(id);
	}

	public User findById(Long id) {
		return userDao.getById(id);
	}

	public List<User> findUsers() {
		return userDao.getAll();
	}

}
