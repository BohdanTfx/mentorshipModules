package com.epam.mentorship.service;

import java.util.List;

import com.epam.mentorship.model.User;

public interface UserService {

	User save(User entity);

	User update(User entity);

	void delete(Long id);

	User findById(Long id);

	List<User> findUsers();
}
